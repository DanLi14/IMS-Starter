package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.DBUtils;

public class OrderItemsDAOTest {

	private final OrderItemsDAO DAO = new OrderItemsDAO();
	private final ItemDAO IDAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item addItem = new Item(2L, "Battlefield1", 9.99);
		IDAO.create(addItem);
		final OrderItems created = new OrderItems(2L, 1, 2);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<OrderItems> expected = new ArrayList<>();
		expected.add(new OrderItems(1L, 1, 1));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new OrderItems(1L, 1, 1), DAO.readLatest());
	}

	@Test
	public void testCalcCost() {
		final Item addItem = new Item(2L, "Battlefield1", 9.99);
		IDAO.create(addItem);
		final OrderItems created = new OrderItems(2L, 1, 2);
		DAO.create(created);
		final double delta = 0;
		assertEquals(69.98, DAO.calcCost(1), delta);
	}

	@Test
	public void testdelete() {
		assertEquals(1, DAO.delete(1L, 1L));
	}

}
