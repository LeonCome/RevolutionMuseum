package com.museum.dao;

import com.museum.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public abstract class BaseDao {

	/**
	 * 通用的增删改操作
	 *
	 * @param sql  执行的 SQL 语句
	 * @param args 可变参数列表
	 * @return 受影响的行数
	 */
	public int update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库操作失败");
		} finally {
			DbUtil.close(null, ps, conn);
		}
	}

	/**
	 * 通用的查询操作
	 *
	 * @param sql  执行的 SQL 语句
	 * @param args 可变参数列表
	 * @return 查询结果集
	 */
	public ResultSet query(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("Executing query: " + sql + " with parameters: " + Arrays.toString(args));
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			DbUtil.close(null, ps, conn);
			throw new RuntimeException("sql query error");
		}
	}
}
