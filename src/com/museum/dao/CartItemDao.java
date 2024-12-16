package com.museum.dao;

import com.museum.bean.CartItem;

import java.util.List;

public interface CartItemDao {

	CartItem findById(int id);
	List<CartItem> findByUserId(int userId); // 根据用户ID查询购物车项
	int saveCartItem(CartItem cartItem); // 保存购物车项
	int deleteCartItem(int id); // 删除购物车项
	int updateCartItem(int id, int count, double totalPrice); // 更新购物车项
	CartItem findByUserIdAndGoodsId(int userId ,int goodId);
}
