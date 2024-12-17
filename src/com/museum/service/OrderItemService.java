package com.museum.service;

import com.museum.bean.OrderItem;

import java.util.List;

public interface OrderItemService {
	OrderItem findById(int id); // 根据订单ID查询订单项
	boolean saveOrderItem(OrderItem orderItem); // 保存订单项
	boolean updateOrderItem(int id,int count,Double totalPrice,int order_status);
	boolean deleteOrderItem(int id);
	List<OrderItem> findByUserId(int userId);
	List<OrderItem> findAll();
}
