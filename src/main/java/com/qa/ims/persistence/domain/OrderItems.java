package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {

	private long orderItemsId;
	private long fkOrderId;
	private long fkItemId;

	// Constructor w/o primary key
	public OrderItems(long fkOrderId, long fkItemId) {
		this.fkOrderId = fkOrderId;
		this.fkItemId = fkItemId;
	}
	
	// Constructor with fkOrderId only
	public OrderItems(long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	// Constructor with primary key
	public OrderItems(long orderItemsId, long fkOrderId, long fkItemId) {
		this.orderItemsId = orderItemsId;
		this.fkOrderId = fkOrderId;
		this.fkItemId = fkItemId;
	}

	public long getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public long getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public long getFkItemId() {
		return fkItemId;
	}

	public void setFkItemId(long fkItemId) {
		this.fkItemId = fkItemId;
	}

	@Override
	public String toString() {
		return "orderItemsId=" + orderItemsId + ", fkOrderId=" + fkOrderId + ", fkItemId=" + fkItemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkItemId, fkOrderId, orderItemsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return fkItemId == other.fkItemId && fkOrderId == other.fkOrderId && orderItemsId == other.orderItemsId;
	}

}
