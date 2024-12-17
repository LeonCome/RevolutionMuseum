package com.museum.dao;

import com.museum.bean.OrderItem;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;

import java.util.List;

public interface OrderItemDao {
	OrderItem findById(int id); // 根据订单ID查询订单项
	int saveOrderItem(OrderItem orderItem); // 保存订单项
	int updateOrderItem(int id,int count,int totalPrice,int order_status);
	List<OrderItem> findByUserId(int userId);
	List<OrderItem> findAll();
}
