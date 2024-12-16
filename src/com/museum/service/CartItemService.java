package com.museum.service;

import com.museum.bean.CartItem;

import java.util.List;

public interface CartItemService {
	CartItem findById(int id);
	List<CartItem> findByUserId(int userId);

	CartItem findByUserIdAndGoodsId(int userId, int goodsId);

	boolean updateCartItem(int id, int count , double totalPrice);
	boolean updateCartItemCount(int id,int count);
	boolean removeCartItemCount(int id);

	boolean addCartItemCount(int goodsId ,int userId);
}
