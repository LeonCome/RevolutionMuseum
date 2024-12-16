package com.museum.service.impl;

import com.museum.bean.Goods;
import com.museum.dao.GoodsDao;
import com.museum.dao.impl.GoodsDaoImpl;
import com.museum.service.GoodsService;

import java.util.List;

public class GoodsServletImpl implements GoodsService {

	@Override
	public List<Goods> queryAllGoods() {
		GoodsDao goodsDao = new GoodsDaoImpl();
		return goodsDao.findAll();
	}
}
