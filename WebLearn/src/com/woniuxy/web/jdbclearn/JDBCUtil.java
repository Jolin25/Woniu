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
 * �����ࣺ�Լ����Ĺ�
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class JDBCUtil {
	// ���url�����ݿ���ۣ��̶���ʽ��jdbc:mysql://���ݿ��������˿ں�/���ݿ�����?user=�˺�&password=����
	// characterEncoding=utf8���ñ����ʽ
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/woniushop?characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	//��Ϊ����������һ�ξͺ���
	static {
		// 1.����������
		try {
			// Ҫд��ȫ����������+����
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  2.��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		/*��ʽ���������ļ�����ʽ
		 * // ���������ļ�����ʽ����urlһ����Ϊ��������ȡ���ݿ�����
		Properties jdbcPro = new Properties();
		// ����properties�ļ�
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
		 * ��ʽ����url��user��password
		 */
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// �ͷ���Դ
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
	// �ͷ���Դ

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

	// �ͷ���Դ
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

	// �ͷ���Դ
	public static void close(Statement state) {

		try {
			if (state != null)
				state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// �ͷ���Դ
	public static void close(Connection con) {

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
