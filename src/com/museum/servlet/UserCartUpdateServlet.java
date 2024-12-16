package com.museum.servlet;

import com.museum.service.CartItemService;
import com.museum.service.impl.CartItemServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserCartUpdateServlet" ,urlPatterns = "/cart/update_cart_item")
public class UserCartUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserCartUpdateServlet====================");
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int newCount = Integer.parseInt(req.getParameter("count"));

		//获取服务类
		CartItemService cartItemService = new CartItemServiceImpl();
		//更新数据
		boolean result = cartItemService.updateCartItemCount(itemId,newCount);
		if (!result){
			req.setAttribute("SqlFailMsg","无法更新，请联系管理员!");
			req.getRequestDispatcher("/cart").forward(req,resp);
			return;
		}
		//跳转回购物车页面
		req.getRequestDispatcher("/cart").forward(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
