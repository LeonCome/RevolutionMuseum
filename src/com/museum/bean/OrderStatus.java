package com.museum.bean;

public class OrderStatus {
	private int id;
	private String orderStatus;

	public OrderStatus() {
	}

	public OrderStatus(int id) {
		this.id = id;
	}

	public OrderStatus(String orderStatus, int id) {
		this.orderStatus = orderStatus;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
