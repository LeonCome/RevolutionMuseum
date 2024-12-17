package com.museum.servlet;

import com.museum.bean.User;
import com.museum.dao.impl.UserDaoImpl;
import com.museum.service.UserService;
import com.museum.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/admin/admin_login")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================AdminLoginServlet====================");

		//获取参数
		String adminName = req.getParameter("adminName");
		String adminPassword = req.getParameter("adminPassword");
		String rememberMeAdmin = req.getParameter("rememberMeAdmin");

		UserService userService = new UserServiceImpl( new UserDaoImpl());
		User user = userService.loginUser(adminName, adminPassword);

		//用户账号存在且可用
		if (user != null && user.getIsValidate()&&user.getIsAdmin()) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInAdmin", user);
			session.setAttribute("adminId",user.getId());

			if ("1".equals(rememberMeAdmin)) {
				setRememberMeCookiesAdmin(resp, adminName, adminPassword, 7 * 24 * 60 * 60); // 7天有效
			} else {
				setRememberMeCookiesAdmin(resp, "", "", 0); // 删除 Cookie
			}

			resp.sendRedirect(req.getContextPath() + "/admin/control");
		} else {
			req.setAttribute("AdminLoginFailMsg", "用户名或密码错误，请重试！");
			req.getRequestDispatcher("/admin/login").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	private void setRememberMeCookiesAdmin(HttpServletResponse resp, String adminName, String adminPassword, int maxAge) {
		Cookie adminNameCookie = new Cookie("adminName", adminName);
		Cookie adminPasswordCookie = new Cookie("adminPassword", adminPassword);
		adminNameCookie.setMaxAge(maxAge);
		adminPasswordCookie.setMaxAge(maxAge);
		adminNameCookie.setPath("/");
		adminPasswordCookie.setPath("/");
		resp.addCookie(adminNameCookie);
		resp.addCookie(adminPasswordCookie);
	}
}
