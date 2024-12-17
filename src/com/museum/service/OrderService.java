package com.museum.service;

import com.museum.bean.Order;

import java.util.List;

public interface OrderService {
	List<Order> findByUserId(int userId); // 根据用户ID查询订单
}
