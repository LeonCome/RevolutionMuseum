package com.museum.service.impl;

import com.museum.bean.User;
import com.museum.dao.UserDao;
import com.museum.dao.impl.UserDaoImpl;
import com.museum.service.UserService;
import java.util.List;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	public UserServiceImpl(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	/**
	 * 注册用户
	 *
	 * @param user 用户信息
	 * @return 注册是否成功
	 */
	@Override
	public boolean registerUser(User user) {
		if (userDao.findByUsername(user.getUsername()) != null) {
			return false; // 用户名已存在
		}
		return userDao.saveUser(user) > 0;
	}

	/**
	 * 用户登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回用户对象，失败返回 null
	 */
	@Override
	public User loginUser(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}

	/**
	 * 根据用户名检查是否已存在
	 *
	 * @param username 用户名
	 * @return 用户名是否已存在
	 */
	@Override
	public boolean isUsernameTaken(String username) {
		return userDao.findByUsername(username) != null;
	}

	/**
	 * 更新用户信息
	 *
	 * @param user 用户信息
	 * @return 更新是否成功
	 */
	@Override
	public boolean updateUser(User user) {
		return userDao.update(user) > 0;
	}

	@Override
	public boolean deleteUser(String username) {
		return userDao.deleteByUsername(username) > 0;
	}

	@Override
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
