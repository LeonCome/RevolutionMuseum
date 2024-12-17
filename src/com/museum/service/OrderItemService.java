package com.museum.service;

import com.museum.bean.OrderItem;

import java.util.List;

public interface OrderItemService {
	OrderItem findById(int id); // 根据订单ID查询订单项
	boolean saveOrderItem(OrderItem orderItem); // 保存订单项
	boolean updateOrderItem(int id,int count,int totalPrice,int order_status);
	List<OrderItem> findByUserId(int userId);
	List<OrderItem> findAll();
}
