package com.museum.service.impl;

import com.museum.bean.OrderStatus;
import com.museum.dao.OrderStatusDao;
import com.museum.dao.impl.OrderStatusDaoImpl;

import java.util.List;

public class OrderStatusServiceImpl implements OrderStatusDao {
	@Override
	public OrderStatus findById(int id) {
		return new OrderStatusDaoImpl().findById(id);
	}

	@Override
	public List<OrderStatus> findAll() {
		return new OrderStatusDaoImpl().findAll();
	}
}
