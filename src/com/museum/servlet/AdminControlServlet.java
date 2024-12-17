package com.museum.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "AdminControlServlet", urlPatterns = "/admin/control")
public class AdminControlServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================AdminControlServlet====================");



		//确认登录
		if (req.getSession().getAttribute("adminId")!=null){
			int adminId= (int) req.getSession().getAttribute("adminId");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/web/admin/control.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		req.setAttribute("AdminLoginFailMsg", "用户名或密码错误，请重试！");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/login");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
