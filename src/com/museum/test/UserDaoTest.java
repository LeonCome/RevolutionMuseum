package com.museum.test;

import com.museum.bean.User;
import com.museum.dao.UserDao;
import com.museum.dao.impl.UserDaoImpl;

public class UserDaoTest {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();

		// 测试保存用户
		User newUser = new User();
		newUser.setUsername("testuser");
		newUser.setPassword("password");
		newUser.setName("测试用户");
		newUser.setEmail("test@example.com");
		newUser.setPhone("123456789");
		newUser.setAddress("测试地址");
		newUser.setIsAdmin(false);
		newUser.setIsValidate(true);
		int result = userDao.saveUser(newUser);
		System.out.println(result > 0 ? "保存成功" : "保存失败");

		// 测试登录查询
		User user = userDao.findByUsernameAndPassword("testuser", "password");
		if (user != null) {
			System.out.println("登录成功：" + user.getName());
		} else {
			System.out.println("登录失败");
		}

		// 测试通过用户名查询用户
		User foundUser = userDao.findByUsername("testuser");
		if (foundUser != null) {
			System.out.println("用户查询成功：" + foundUser.getName());
		} else {
			System.out.println("用户不存在");
		}
	}
}
