package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	// fields
	private long itemId;
	private String name;
	private double cost;

	// constructor w/o id
	public Item(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	// constructor w id
	public Item(long itemId, String name, double cost) {
		this.itemId = itemId;
		this.name = name;
		this.cost = cost;
	}

	// Getters and setters
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "itemId:" + itemId + ", name:" + name + ", cost:" + cost + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, itemId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && itemId == other.itemId
				&& Objects.equals(name, other.name);
	}

}
