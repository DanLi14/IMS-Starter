package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemsController;
import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemsControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderItemsDAO dao;

	@InjectMocks
	private OrderItemsController controller;

	@Test
	public void testCreate() {
		final Long fkOrderId = (long) 1;
		final Long fkItemId = (long) 1;
		final OrderItems created = new OrderItems(fkOrderId, fkItemId);

		Mockito.when(utils.getLong()).thenReturn(fkOrderId, fkItemId);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<OrderItems> orderItems = new ArrayList<>();
		orderItems.add(new OrderItems(1L, 1, 1));

		Mockito.when(dao.readAll()).thenReturn(orderItems);

		assertEquals(orderItems, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testCalcCost() {

		final long ID = 1L;
		final double price = 59.99;
		final double delta = 0;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.calcCost(ID)).thenReturn(price);

		assertEquals(59.99, controller.calcCost(), delta);

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).calcCost(ID);
	}

	@Test
	public void testDelete() {
		final long orderId = 1L;
		final long itemId = 1L;

		Mockito.when(utils.getLong()).thenReturn(orderId, itemId);
		Mockito.when(dao.delete(orderId, itemId)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(orderId, itemId);
	}

}
