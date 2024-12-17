package com.museum.dao;

import com.museum.bean.OrderItem;
import com.museum.bean.OrderStatus;

import java.util.List;

public interface OrderStatusDao {
	OrderStatus findById(int id);
	List<OrderStatus> findAll();
}
