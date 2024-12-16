package com.museum.dao;

import com.museum.bean.Goods;

import java.util.List;

public interface GoodsDao {
	Goods findById(int id);

	List<Goods> findAll();

	int saveGoods(Goods goods);

	int updateGoods(Goods goods);

	int deleteGoods(int id);
}
