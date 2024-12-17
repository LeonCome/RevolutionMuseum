package com.museum.dao.impl;

import com.museum.bean.Order;
import com.museum.bean.OrderItem;
import com.museum.dao.BaseDao;
import com.museum.dao.OrderDao;
import com.museum.dao.OrderItemDao;
import com.museum.dao.UserDao;
import com.museum.service.UserService;
import com.museum.service.impl.UserServiceImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	@Override
	public Order findById(int id) {
		String sql = "SELECT * FROM `order` WHERE id = ?";
		ResultSet rs = query(sql, id);
		try {
			if (rs.next()) {
				return mapOrder(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return null;
	}

	@Override
	public List<Order> findByUserId(int userId) {
		String sql = "SELECT * FROM `order` WHERE user_id = ?";
		ResultSet rs = query(sql, userId);
		List<Order> orderList = new ArrayList<>();
		try {
			while (rs.next()) {
				orderList.add(mapOrder(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderList;
	}

	@Override
	public int saveOrder(Order order) {
		String sql = "INSERT INTO `order` (status, total, amount, create_time, user_id) VALUES (?, ?, ?, ?, ?)";
		return update(sql, order.getStatus(), order.getTotal(), order.getAmount(), order.getCreateTime(), order.getUser().getId());
	}

	@Override
	public int updateOrderStatus(int id, int status) {
		String sql = "UPDATE `order` SET status = ? WHERE id = ?";
		return update(sql, status, id);
	}

	private Order mapOrder(ResultSet rs) throws Exception {
		Order order = new Order();
		order.setId(rs.getInt("id"));
		order.setStatus(rs.getInt("status"));
		order.setTotal(rs.getDouble("total"));
		order.setAmount(rs.getInt("amount"));
		order.setCreateTime(rs.getTimestamp("create_time"));
		// 设置其他属性（如关联用户、订单项）时需根据业务逻辑查询其他表
		UserDao userDao = new UserDaoImpl();
		order.setUser(userDao.findByUserId(rs.getInt("user_id")));

		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		order.setOrderItems(orderItemDao.findByOrderId(rs.getInt("id")));

		return order;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
