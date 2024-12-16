package com.museum.servlet;

import com.museum.service.CartItemService;
import com.museum.service.impl.CartItemServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "UserOrderServlet" , urlPatterns = "/order")
public class UserOrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserOrderServlet====================");

		//确认登录
		if (req.getSession().getAttribute("userId")!=null){
			int userId= (int) req.getSession().getAttribute("userId");
//			CartItemService cartItemService = new CartItemServiceImpl();
//			req.setAttribute("cartItems",cartItemService.findByUserId(userId));
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/web/user/order.jsp");
			dispatcher.forward(req, resp);
			return;
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/web/user/order.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
