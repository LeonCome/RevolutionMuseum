package com.museum.dao;

import com.museum.bean.User;

import java.util.List;

public interface UserDao {
	User findByUsernameAndPassword(String username, String password); // 根据用户名和密码查询用户
	int saveUser(User user); // 保存用户
	User findByUsername(String username); // 根据用户名查询用户
	User findByUserId(int userId); // 根据用户名查询用户
	int update(User user);
	int deleteByUsername(String username);
}
