package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

public class OrderItemsController implements OiCrudController<OrderItems> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemsDAO orderItemsDAO;
	private Utils utils;

	public OrderItemsController(OrderItemsDAO orderItemsDAO, Utils utils) {
		super();
		this.orderItemsDAO = orderItemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<OrderItems> readAll() {
		List<OrderItems> orderItems = orderItemsDAO.readAll();
		for (OrderItems oi : orderItems) {
			LOGGER.info(oi);
		}
		return orderItems;
	}

	/**
	 * Adds an item to an order by taking in user input
	 */
	@Override
	public OrderItems create() {
		LOGGER.info("Please enter the id of the order for which to add an item");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the id of the item you would like to add to the order");
		Long itemId = utils.getLong();
		OrderItems orderItems = orderItemsDAO.create(new OrderItems(orderId, itemId));
		LOGGER.info("item added to order with id " + orderId);
		return orderItems;
	}

	/**
	 * calculates the cost of an order by taking in user input
	 */
	@Override
	public double calcCost() {
		LOGGER.info("Please enter the id of the order you would like to calculate the total cost off");
		Long orderId = utils.getLong();
		double orderCost = orderItemsDAO.calcCost(orderId);
		LOGGER.info("total cost of order retrieved");
		return orderCost;
	}

	/**
	 * Deletes an item from a specific order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete an item from");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the name of the item you would like to delete from the order");
		String itemName = utils.getString();
		return orderItemsDAO.delete(orderId, itemName);
	}

}
