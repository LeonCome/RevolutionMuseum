package com.museum.servlet;

import com.museum.bean.User;
import com.museum.dao.impl.UserDaoImpl;
import com.museum.service.UserService;
import com.museum.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UserRegisterServlet",urlPatterns = "/client/user_register")
public class UserClientRegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("===================UserRegisterServlet====================");
		//获取请求中的用户名和密码
		String regUsername = req.getParameter("regUsername");
		String regPassword = (req.getParameter("regPassword").equals(req.getParameter("regConfirmPassword")) ? req.getParameter("regConfirmPassword") : "");
		String regPhone = req.getParameter("regPhone");
		String regName = req.getParameter("regName");
		String regEmail = req.getParameter("regEmail");
		String regAddress = req.getParameter("regAddress");
		User user = new User(null,regUsername,null, regPassword, regName, regEmail, regPhone, regAddress, false, true);

		//验证表单数据
		//验证用户名
		String usernamePatt = "[a-zA-Z0-9_-]{4,16}";
		if (!regUsername.matches(usernamePatt)) {
			//用户名不合法，设置回显错误消息
			req.setAttribute("failMsg", "username invalid");
			System.out.println("username invalid");
			//设置用户信息回显
			req.setAttribute("user", user);
			//跳转回新增用户页面
			req.getRequestDispatcher("/client").forward(req, resp);
			return;
		}
		if (regPassword.isEmpty()) {
			req.setAttribute("failMsg", "password error");
			System.out.println("password error");
			req.getRequestDispatcher("/client").forward(req, resp);
			return;
		}
		//验证其他数据......

		UserService userService = new UserServiceImpl(new UserDaoImpl());
		//判断用户名是否重复
		if (userService.isUsernameTaken(regUsername)) {
			// 把回显信息，保存到Request域中
			req.setAttribute("failMsg", "user exist");
			System.out.println("user exist");
			req.setAttribute("user", user);
			req.getRequestDispatcher("/client").forward(req, resp);
			return;
		}
		boolean result = userService.registerUser(user);
		if (result) {
			//注册成功后，直接登录
			user = userService.loginUser(user.getUsername(), user.getPassword());
			req.getSession().setAttribute("user", user);

			//跳转到原页面
			req.setAttribute("alertMsg", "user register success");
			System.out.println("user register");
			req.getRequestDispatcher("/client").forward(req, resp);
		} else {
			req.setAttribute("failMsg", "user register fail");
			System.out.println("user register fail");
			req.setAttribute("user", user);
			req.getRequestDispatcher("/client").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
