package com.museum.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AdminPageServlet" , urlPatterns = "/admin/login")
public class AdminPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 登录的情况下跳转到管理页面
		HttpSession session = req.getSession();
		if (session.getAttribute("loggedInAdmin") != null) {
			// 已经登录，直接跳转到管理员控制面板
			req.getRequestDispatcher("/admin/control").forward(req, resp);
			return;
		}
		
		System.out.println("===================AdminPageServlet====================");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/web/admin/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
