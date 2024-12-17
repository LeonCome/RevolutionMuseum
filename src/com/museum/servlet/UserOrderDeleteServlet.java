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
@WebServlet(name = "UserOrderDeleteServlet",urlPatterns = "/order/delete")
public class UserOrderDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserOrderDeleteServlet====================");
		//获取参数
		int orderId = Integer.parseInt(req.getParameter("orderId"));

		//创建服务类
		OrderItemService orderItemService = new OrderItemServiceImpl();
		boolean result = orderItemService.deleteOrderItem(orderId);
		if (!result){
			req.setAttribute("failMsg","订单删除出错");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/order");
			dispatcher.forward(req, resp);
			return;
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/order");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
