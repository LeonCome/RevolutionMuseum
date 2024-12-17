package com.museum.service.impl;

import com.museum.bean.Order;
import com.museum.dao.OrderDao;
import com.museum.dao.impl.OrderDaoImpl;
import com.museum.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> findByUserId(int userId) {
		OrderDao orderDao = new OrderDaoImpl();
		return orderDao.findByUserId(userId);
	}
}
