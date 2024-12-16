package com.museum.dao;

import com.museum.bean.Order;

import java.util.List;

public interface OrderDao {
	Order findById(int id); // 根据订单ID查询订单
	List<Order> findByUserId(int userId); // 根据用户ID查询订单
	int saveOrder(Order order); // 保存订单
	int updateOrderStatus(int id, int status); // 更新订单状态
}
