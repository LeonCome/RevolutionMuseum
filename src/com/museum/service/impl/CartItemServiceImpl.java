package com.museum.service.impl;

import com.museum.bean.CartItem;
import com.museum.bean.Goods;
import com.museum.bean.User;
import com.museum.dao.CartItemDao;
import com.museum.dao.impl.CartItemDaoImpl;
import com.museum.dao.impl.GoodsDaoImpl;
import com.museum.dao.impl.UserDaoImpl;
import com.museum.service.CartItemService;

import java.util.List;

public class CartItemServiceImpl implements CartItemService {

	public CartItem findById(int id) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		return cartItemDao.findById(id);
	}

	@Override
	public List<CartItem> findByUserId(int userId) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		return cartItemDao.findByUserId(userId);
	}

	@Override
	public CartItem findByUserIdAndGoodsId(int userId, int goodsId) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		return cartItemDao.findByUserIdAndGoodsId(userId ,goodsId);
	}

	@Override
	public boolean updateCartItem(int id, int count , double totalPrice) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		return cartItemDao.updateCartItem(id, count, totalPrice) > 0;
	}

	@Override
	public boolean updateCartItemCount(int id, int count) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		double totalPrice = 0.0;
		totalPrice = findById(id).getGoods().getPrice()*count;

		return cartItemDao.updateCartItem(id, count, totalPrice) > 0;
	}



	@Override
	public boolean removeCartItemCount(int id) {
		CartItemDao cartItemDao = new CartItemDaoImpl();
		return cartItemDao.deleteCartItem(id)>0;
	}

	@Override
	public boolean addCartItemCount(int goodsId ,int userId) {
		CartItemDao cartItemDao = new CartItemDaoImpl();

		Goods goods = new GoodsDaoImpl().findById(goodsId);
		Double totalPrice = new GoodsDaoImpl().findById(goodsId).getPrice();
		User user = new UserDaoImpl().findByUserId(userId);
		
		CartItem cartItem = findByUserIdAndGoodsId(userId,goodsId );
		if(cartItem==null){
			return cartItemDao.saveCartItem(new CartItem(null, goods, 1, totalPrice,user))>0;
		}
		if (cartItem.getCount()>=1){
			//cartItem不为空和cartItem.getCount()>=1的情况
			return updateCartItem(cartItem.getId(),cartItem.getCount()+1,cartItem.getTotalPrice()+cartItem.getGoods().getPrice());
		}else {
			//cartItem为空和cartItem.getCount()<1的情况
			return cartItemDao.saveCartItem(new CartItem(null, goods, 1, totalPrice,user))>0;
		}
	}
}
