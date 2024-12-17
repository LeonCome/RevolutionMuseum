package com.museum.service.impl;

import com.museum.bean.OrderItem;
import com.museum.dao.impl.OrderItemDaoImpl;
import com.museum.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
	@Override
	public OrderItem findById(int id) {
		return new OrderItemDaoImpl().findById(id);
	}

	@Override
	public boolean saveOrderItem(OrderItem orderItem) {
		return new OrderItemDaoImpl().saveOrderItem(orderItem)>0;
	}

	@Override
	public boolean updateOrderItem(int id, int count, Double totalPrice, int order_status) {
		return new OrderItemDaoImpl().updateOrderItem(id,count,totalPrice,order_status)>0;
	}

	@Override
	public List<OrderItem> findByUserId(int userId) {
		return new OrderItemDaoImpl().findByUserId(userId);
	}

	@Override
	public List<OrderItem> findAll() {
		return new OrderItemDaoImpl().findAll();
	}
}
