package com.museum.dao.impl;

import com.museum.bean.Goods;
import com.museum.dao.BaseDao;
import com.museum.dao.GoodsDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	@Override
	public Goods findById(int id) {
		String sql = "SELECT * FROM goods WHERE id = ?";
		ResultSet rs = query(sql, id);
		try {
			if (rs.next()) {
				return mapGoods(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return null;
	}

	@Override
	public List<Goods> findAll() {
		String sql = "SELECT * FROM goods";
		ResultSet rs = query(sql);
		List<Goods> goodsList = new ArrayList<>();
		try {
			while (rs.next()) {
				goodsList.add(mapGoods(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
		}
		return goodsList;
	}

	@Override
	public int saveGoods(Goods goods) {
		String sql = "INSERT INTO goods (name, price, stock, image) VALUES (?, ?, ?, ?)";
		return update(sql, goods.getName(), goods.getPrice(), goods.getStock(), goods.getImage());
	}

	@Override
	public int updateGoods(Goods goods) {
		String sql = "UPDATE goods SET name = ?, price = ?, stock = ?, image = ? WHERE id = ?";
		return update(sql, goods.getName(), goods.getPrice(), goods.getStock(), goods.getImage(), goods.getId());
	}

	@Override
	public int deleteGoods(int id) {
		String sql = "DELETE FROM goods WHERE id = ?";
		return update(sql, id);
	}

	private Goods mapGoods(ResultSet rs) throws Exception {
		Goods goods = new Goods();
		goods.setId(rs.getInt("id"));
		goods.setName(rs.getString("name"));
		goods.setPrice(rs.getDouble("price"));
		goods.setStock(rs.getInt("stock"));
		goods.setImage(rs.getString("image"));
		return goods;
	}

	private void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
