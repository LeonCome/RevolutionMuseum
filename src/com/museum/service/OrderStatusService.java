package com.museum.service;

import com.museum.bean.OrderStatus;

import java.util.List;

public interface OrderStatusService {
	OrderStatus findById(int id);
	List<OrderStatus> findAll();
}
