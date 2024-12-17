package com.museum.servlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.museum.bean.*;
import com.museum.service.CartItemService;
import com.museum.service.OrderItemService;
import com.museum.service.impl.CartItemServiceImpl;
import com.museum.service.impl.OrderItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserGoodsAddToCartServlet", urlPatterns = "/goods/add_cart")
public class UserGoodsAddToCartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserGoodsAddToCartServlet====================");

		//确保登录
		if (req.getSession().getAttribute("loggedInUser") == null) {
			System.out.println("no login!!!");
			req.setAttribute("noLoginFailMsg", "请先登录");
			req.getRequestDispatcher("/goods").forward(req, resp);
			return;
		}

		//获取参数
		int goodsId = Integer.parseInt(req.getParameter("id"));

		//获取服务类
		CartItemService cartItemService = new CartItemServiceImpl();
		//添加数据到购物车
		boolean result = cartItemService.addCartItemCount( goodsId,(Integer) req.getSession().getAttribute("userId"));

		if (!result){
			req.setAttribute("SqlFailMsg","无法更新，请联系管理员!");
			req.getRequestDispatcher("/cart").forward(req,resp);
			return;
		}
		//跳转到购物车页面
		req.getRequestDispatcher("/cart").forward(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
