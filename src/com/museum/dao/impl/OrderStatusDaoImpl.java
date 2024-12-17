package com.museum.dao.impl;

import com.museum.bean.OrderStatus;
import com.museum.dao.BaseDao;
import com.museum.dao.OrderStatusDao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusDaoImpl extends BaseDao implements OrderStatusDao {
	@Override
	public OrderStatus findById(int id) {
		String sql = "SELECT * FROM order_status WHERE id = ?";
		ResultSet rs = query(sql,id);
		OrderStatus orderStatus = new OrderStatus();
		try {
			if (rs.next()) {
				orderStatus=mapOrderStatus(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderStatus;
	}

	@Override
	public List<OrderStatus> findAll() {
		String sql = "SELECT * FROM order_status ";
		ResultSet rs = query(sql);
		List<OrderStatus> orderStatusList = new ArrayList<>();
		try {
			if (rs.next()) {
				orderStatusList.add(mapOrderStatus(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderStatusList;
	}
	private OrderStatus mapOrderStatus(ResultSet rs) throws Exception {
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(rs.getInt("id"));
		orderStatus.setOrderStatus(rs.getString("status_name"));
		return orderStatus;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
