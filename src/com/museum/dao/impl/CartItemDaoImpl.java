package com.museum.dao.impl;

import com.museum.bean.CartItem;
import com.museum.bean.Goods;
import com.museum.dao.BaseDao;
import com.museum.dao.CartItemDao;
import com.museum.dao.GoodsDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDaoImpl extends BaseDao implements CartItemDao {

	@Override
	public CartItem findById(int id) {
		String sql = "SELECT * FROM cart_item WHERE id = ?";
		ResultSet rs = query(sql, id);
		CartItem cartItem = null;
		try {
			if (rs.next()) {
				cartItem = mapCartItem(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return cartItem;
	}

	@Override
	public List<CartItem> findByUserId(int userId) {
		String sql = "SELECT * FROM cart_item WHERE user_id = ?";
		ResultSet rs = query(sql, userId);
		List<CartItem> cartItemList = new ArrayList<>();
		try {
			while (rs.next()) {
				cartItemList.add(mapCartItem(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return cartItemList;
	}

	@Override
	public CartItem findByUserIdAndGoodsId(int userId, int goodId) {
		String sql = "SELECT * FROM cart_item WHERE user_id = ? AND goods_id = ?";
		ResultSet rs = query(sql, userId, goodId);
		CartItem cartItem = null;
		try {
			System.out.println(rs);
			if (rs.next()) {
				cartItem = mapCartItem(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return cartItem;
	}

	@Override
	public int saveCartItem(CartItem cartItem) {
		String sql = "INSERT INTO cart_item (id,user_id, goods_id ,count , total_price) VALUES (?, ?, ?, ?, ?)";
		return update(sql, null, cartItem.getUser().getId(), cartItem.getGoods().getId(), cartItem.getCount(), cartItem.getTotalPrice());
	}

	@Override
	public int deleteCartItem(int id) {
		String sql = "DELETE FROM cart_item WHERE id = ?";
		return update(sql, id);
	}

	@Override
	public int updateCartItem(int id, int count, double totalPrice) {
		String sql = "UPDATE cart_item SET count = ?, total_price = ? WHERE id = ?";
		return update(sql, count, totalPrice, id);
	}


	private CartItem mapCartItem(ResultSet rs) throws Exception {
		CartItem cartItem = new CartItem();
		cartItem.setId(rs.getInt("id"));
		cartItem.setUser(new UserDaoImpl().findByUserId(rs.getInt("user_id")));
		cartItem.setGoods(new GoodsDaoImpl().findById(rs.getInt("goods_id")));
		cartItem.setCount(rs.getInt("count"));
		cartItem.setTotalPrice(rs.getDouble("total_price"));

		return cartItem;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
