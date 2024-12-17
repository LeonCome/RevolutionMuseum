package com.museum.servlet;

import com.museum.bean.User;
import com.museum.dao.impl.UserDaoImpl;
import com.museum.service.UserService;
import com.museum.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/client/user_login")
public class UserClientLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserLoginServlet====================");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("rememberMe");

		UserService userService = new UserServiceImpl( new UserDaoImpl());
		User user = userService.loginUser(username, password);

		//用户账号存在且可用
		if (user != null && user.getIsValidate()) {
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", user);
			session.setAttribute("userId",user.getId());

			if ("on".equals(rememberMe)) {
				setRememberMeCookies(resp, username, password, 7 * 24 * 60 * 60); // 7天有效
			} else {
				setRememberMeCookies(resp, "", "", 0); // 删除 Cookie
			}

			resp.sendRedirect(req.getContextPath() + "/client");
		} else {
			req.setAttribute("loginFailMsg", "用户名或密码错误，请重试！");
			req.getRequestDispatcher("/client").forward(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	private void setRememberMeCookies(HttpServletResponse resp, String username, String password, int maxAge) {
		Cookie usernameCookie = new Cookie("username", username);
		Cookie passwordCookie = new Cookie("password", password);
		usernameCookie.setMaxAge(maxAge);
		passwordCookie.setMaxAge(maxAge);
		usernameCookie.setPath("/");
		passwordCookie.setPath("/");
		resp.addCookie(usernameCookie);
		resp.addCookie(passwordCookie);
	}
}
