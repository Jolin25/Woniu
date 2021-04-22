package com.woniuxy.web.jdbclearn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类：自己建的哈
 * 
 * @author 小虫子的小日常
 *
 */
public class JDBCUtil {
	// 这个url是数据库的哇，固定格式：jdbc:mysql://数据库主机：端口号/数据库名称?user=账号&password=密码
	// characterEncoding=utf8设置编码格式
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/woniushop?characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	//因为加载驱动类一次就好了
	static {
		// 1.加载驱动类
		try {
			// 要写类全名哈：包名+类名
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  2.获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		/*方式三：配置文件的形式
		 * // 采用配置文件的形式，和url一起作为参数来获取数据库连接
		Properties jdbcPro = new Properties();
		// 加载properties文件
		try {
			jdbcPro.load(new FileReader(new File("jdbc.properties")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, jdbcPro);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		/*
		 * 方式二：url，user，password
		 */
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 释放资源
	public static void close(Connection con, Statement state) {
		try {
			if (state != null)
				state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 释放资源

	public static void close(Connection con, Statement state, ResultSet set) {
		try {
			if (set != null)
				set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (state != null)
					state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 释放资源
	public static void close(Statement state, ResultSet set) {
		try {
			if (set != null)
				set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (state != null)
					state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 释放资源
	public static void close(Statement state) {

		try {
			if (state != null)
				state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 释放资源
	public static void close(Connection con) {

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
