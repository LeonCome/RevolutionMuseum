package com.museum.servlet;

import com.museum.service.CartItemService;
import com.museum.service.impl.CartItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserCartRemoveServlet",urlPatterns = "/cart/remove_cart_item")
public class UserCartRemoveServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================HttpServletRequest====================");
		int itemId = Integer.parseInt(req.getParameter("itemId"));

		//获取服务类
		CartItemService cartItemService = new CartItemServiceImpl();
		//删除数据
		boolean result = cartItemService.removeCartItemCount(itemId);

		if (!result){
			req.setAttribute("SqlFailMsg","无法更新，请联系管理员!");
			req.getRequestDispatcher("/cart").forward(req,resp);
			return;
		}
		//跳转回购物车页面
		req.getRequestDispatcher("/cart").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
