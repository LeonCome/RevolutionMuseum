package com.museum.dao.impl;

import com.museum.bean.OrderItem;
import com.museum.bean.Goods;
import com.museum.bean.Order;
import com.museum.dao.BaseDao;
import com.museum.dao.OrderItemDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		String sql = "SELECT * FROM order_item WHERE order_id = ?";
		ResultSet rs = query(sql, orderId);
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
	public int saveOrderItem(OrderItem orderItem) {
		String sql = "INSERT INTO order_item (amount, goods_id, order_id) VALUES (?, ?, ?)";
		return update(sql, orderItem.getAmount(), orderItem.getGoods().getId(), orderItem.getOrder().getId());
	}

	private OrderItem mapOrderItem(ResultSet rs) throws Exception {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getInt("id"));
		orderItem.setAmount(rs.getInt("amount"));

		// 创建关联的 Goods 对象
		Goods goods = new Goods();
		goods.setId(rs.getInt("goods_id"));
		orderItem.setGoods(goods);

		// 创建关联的 Order 对象
		Order order = new Order();
		order.setId(rs.getInt("order_id"));
		orderItem.setOrder(order);

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
