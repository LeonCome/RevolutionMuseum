package com.museum.service;

import com.museum.bean.User;

import java.util.List;

public interface UserService {

	// 用户注册
	boolean registerUser(User user);

	// 用户登录
	User loginUser(String username, String password);

	// 检查用户名是否已存在
	boolean isUsernameTaken(String username);

	// 更新用户信息
	boolean updateUser(User user);

	// 删除用户
	boolean deleteUser(String username);

	// 根据用户名称查询用户
	User findUserByUsername(String username);
}
