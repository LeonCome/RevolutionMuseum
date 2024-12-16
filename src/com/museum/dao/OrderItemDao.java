package com.museum.dao;

import com.museum.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
	List<OrderItem> findByOrderId(int orderId); // 根据订单ID查询订单项
	int saveOrderItem(OrderItem orderItem); // 保存订单项
}
