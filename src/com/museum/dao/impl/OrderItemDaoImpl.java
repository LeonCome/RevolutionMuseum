package com.museum.dao.impl;

import com.museum.bean.OrderItem;
import com.museum.dao.BaseDao;
import com.museum.dao.GoodsDao;
import com.museum.dao.OrderItemDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {


	@Override
	public OrderItem findById(int id) {
		String sql = "SELECT * FROM order_item WHERE id = ?";
		ResultSet rs = query(sql, id);
		OrderItem orderItem = new OrderItem();
		try {
			if (rs.next()) {
				orderItem=mapOrderItem(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderItem;
	}

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		String sql = "INSERT INTO order_item (id, user_id, goods_id, order_status_id, count, total_price) VALUES (?, ?, ?, ?, ?, ?)";
		return update(sql, orderItem.getId(), orderItem.getUser().getId(), orderItem.getGoods().getId(),orderItem.getOrderStatus().getId(),orderItem.getCount(),orderItem.getTotalPrice());
	}

	@Override
	public int updateOrderItem(int id,int count,int totalPrice,int order_status) {
		String sql = "UPDATE order_item SET count=?,totalPrice=?, order_status=? WHERE id=?";
		return update(sql,count,totalPrice,order_status,id);
	}

	@Override
	public List<OrderItem> findByUserId(int userId) {
		String sql = "SELECT * FROM order_item WHERE user_id = ?";
		ResultSet rs = query(sql, userId);
		List<OrderItem> orderItemList = new ArrayList<>();
		try {
			while (rs.next()) {
				orderItemList.add(mapOrderItem(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderItemList;
	}

	@Override
	public List<OrderItem> findAll() {
		String sql = "SELECT * FROM order_item ";
		ResultSet rs = query(sql);
		List<OrderItem> orderItemList = new ArrayList<>();
		try {
			if (rs.next()) {
				orderItemList.add(mapOrderItem(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return orderItemList;
	}

	private OrderItem mapOrderItem(ResultSet rs) throws Exception {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getInt("id"));
		orderItem.setUser(new UserDaoImpl().findByUserId(rs.getInt("user_id")));
		orderItem.setGoods(new GoodsDaoImpl().findById(rs.getInt("goods_id")));
		orderItem.setOrderStatus(new OrderStatusDaoImpl().findById(rs.getInt("order_status_id")));
		orderItem.setCount(rs.getInt("count"));
		orderItem.setTotalPrice(rs.getDouble("total_price"));

		return orderItem;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
