package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAO implements Oidao<OrderItems> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItems modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderItemsId = resultSet.getLong("order_items_id");
		Long fkOrderId = resultSet.getLong("fk_order_id");
		Long fkItemId = resultSet.getLong("fk_item_id");
		return new OrderItems(orderItemsId, fkOrderId, fkItemId);
	}

	/**
	 * Reads all entries from the database
	 * 
	 * @return the relationship between item(s) and order(s).
	 */
	@Override
	public List<OrderItems> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items");) {
			List<OrderItems> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderItems readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM order_items ORDER BY order_items_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Add an item to an order using an intermediary table.
	 * 
	 * @param orderItems - takes in an OrderItems object.
	 */
	@Override
	public OrderItems create(OrderItems orderItems) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(fk_order_id, fk_item_id) VALUES (?, ?)");) {
			statement.setLong(1, orderItems.getFkOrderId());
			statement.setLong(2, orderItems.getFkItemId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * calculates the total cost of an order in the database
	 * 
	 * @param orderItems - takes in an OrderItems object, the fk_order_id will be
	 *                   used to identify which items' costs will be aggregated
	 * 
	 * @return total order cost value.
	 */
	@Override
	public double calcCost(long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"SELECT SUM(cost) FROM items i JOIN order_items oi ON i.item_id=oi.fk_item_id WHERE oi.fk_order_id = ?");) {
			statement.setLong(1, orderId);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			double sum = resultSet.getDouble("SUM(cost)");
			System.out.println(sum);
			return sum;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * Deletes an item from an order in the database
	 * 
	 * @param id - id of the order && name - name of the item
	 *
	 */
	@Override
	public int delete(long orderId, long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM order_items WHERE fk_order_id = ? AND fk_item_id = ?");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
