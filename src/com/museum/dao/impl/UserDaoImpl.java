package com.museum.dao.impl;

import com.museum.bean.User;
import com.museum.dao.BaseDao;
import com.museum.dao.UserDao;
import com.museum.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return mapUser(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs, ps, conn);
		}
		return null;
	}

	@Override
	public int saveUser(User user) {
		String sql = "INSERT INTO user (username , avatar, password, name, email, phone, address, is_admin, is_validate) " +
				"VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)";
		return update(sql, user.getUsername(), user.getAvatar(),user.getPassword(), user.getName(), user.getEmail(),
				user.getPhone(), user.getAddress(), user.getIsAdmin(), user.getIsValidate());
	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return mapUser(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs, ps, conn);
		}
		return null;
	}

	@Override
	public User findByUserId(int userId) {
		String sql = "SELECT * FROM user WHERE id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(userId));
			rs = ps.executeQuery();
			if (rs.next()) {
				return mapUser(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs, ps, conn);
		}
		return null;
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user SET username=?,avatar=?, password=?, name=?, email=?, phone=?, address=?, is_admin=?, is_validate=? WHERE id=?";
		return update(sql, user.getUsername(), user.getAvatar(),user.getPassword(), user.getName(), user.getEmail(),
				user.getPhone(), user.getAddress(), user.getIsAdmin(), user.getIsValidate());
	}

	@Override
	public int deleteByUsername(String username) {
		String sql = "DELETE FROM tbl_user WHERE username=?";
		return update(sql, username);
	}

	/**
	 * 将 ResultSet 映射到 User 对象
	 *
	 * @param rs 查询结果集
	 * @return User 对象
	 */
	private User mapUser(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setIsAdmin(rs.getBoolean("is_admin"));
		user.setIsValidate(rs.getBoolean("is_validate"));
		return user;
	}
}
