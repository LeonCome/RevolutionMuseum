package com.museum.servlet;

import com.museum.bean.Goods;
import com.museum.service.GoodsService;
import com.museum.service.impl.GoodsServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserGoodsServlet" ,urlPatterns="/goods")
public class UserGoodsServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserGoodsServlet====================");
		req.setAttribute("activeNum",2);

		GoodsService goodsService = new GoodsServiceImpl();
		List<Goods> goodsList =  goodsService.queryAllGoods();
		req.setAttribute("goods",goodsList);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/web/user/goods.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
