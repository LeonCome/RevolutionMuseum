package com.museum.servlet;

import com.museum.bean.OrderItem;
import com.museum.service.OrderItemService;
import com.museum.service.impl.OrderItemServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "UserOrderServlet" , urlPatterns = "/order")
public class UserOrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserOrderServlet====================");

		//确认登录
		if (req.getSession().getAttribute("userId")!=null){
			int userId= (int) req.getSession().getAttribute("userId");

			OrderItemService orderService = new OrderItemServiceImpl();
			List<OrderItem> orderItems = orderService.findByUserId(userId);
			req.setAttribute("orderItems",orderItems);
			System.out.println("orderItems:"+orderItems);
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
