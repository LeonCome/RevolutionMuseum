package com.museum.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库操作的工具类
 */
public class DbUtil {
    private static String jdbcDriver;
    private static String jdbcUrl;
    private static String jdbcUser;
    private static String jdbcPassword;

    static {
        try {
            //读取属性文件db.properties
            InputStream in = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            jdbcDriver = properties.getProperty("jdbcDriver");
            jdbcUrl = properties.getProperty("jdbcUrl");
            jdbcUser = properties.getProperty("jdbcUser");
            jdbcPassword = properties.getProperty("jdbcPassword");
            //注册JDBC驱动
            Class.forName(jdbcDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @return 若返回null，表示数据库连接失败
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库对象，释放资源
     * @param rs 返回
     * @param stmt 语句
     * @param conn 连接
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
