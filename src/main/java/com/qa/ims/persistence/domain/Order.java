package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private long orderId;
	private long fkCustomerId;

	// constructor w/o primary id
	public Order(long fkCustomerId) {
		this.fkCustomerId = fkCustomerId;
	}

	// constructor with primary id
	public Order(long orderId, long fkCustomerId) {
		super();
		this.orderId = orderId;
		this.fkCustomerId = fkCustomerId;
	}

	// Getters and setters
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getFkCustomerId() {
		return fkCustomerId;
	}

	@Override
	public String toString() {
		return "orderId=" + orderId + ", fkCustomerId=" + fkCustomerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkCustomerId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return fkCustomerId == other.fkCustomerId && orderId == other.orderId;
	}

}
