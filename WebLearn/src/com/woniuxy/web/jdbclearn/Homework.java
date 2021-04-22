package com.woniuxy.web.jdbclearn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 1，完成登录注册功能，由用户通过控制台输入账号密码信息，数据存储，来源于数据库； 分析：
 * 要求：注册、登陆。注册信息放置于数据库中，登陆通过读取数据库信息对比 思路：注册：通过操作数据库向woniushop库里的users表添加一条数据；
 * 登陆：seclect获取users表的内容，进行对比 技术：JDBC，使用事务操作（诶诶？好像可以不用）
 * 细节：注册：电话号11位，正则表达式。密码6位，正则表达式。电话号不准重复。 登陆：唔。没啥
 * 
 * @author 小虫子的小日常
 *
 */
public class Homework {
	// 试一下一开始就连接了，如果更改了数据，是否读取数据时也获得的是最新的。--->是的。。可能因为当时就已经插进去了
	static Connection con = null;
	static Scanner sc = null;

	static {
		// 加载驱动类，获取数据库连接
		con = JDBCUtil.getConnection();
	}

	/*
	 * 主方法
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Homework h = new Homework();
		h.signUp();
		h.signIn();
		// 关闭连接
		JDBCUtil.close(con);
		// 关闭Scanner
		sc.close();
	}

	/*
	 * 获取数据库中users表的信息
	 */
	public static String[][] getMessage(Connection con) {
		// 用数组存储从数据库中读取的资料(账号，密码)
		String[][] users = new String[100][2];
		// 准备sql
		String sql = "SELECT u_account,u_password FROM users";
		// 创建state，执行sql
		Statement state = null;
		ResultSet rSet = null;
		try {
			state = con.createStatement();
			rSet = state.executeQuery(sql);
			int i = 0;
			while (rSet.next()) {
				// 将读取到的数据传入users数组中
				users[i][0] = rSet.getString("u_account");
				users[i][1] = rSet.getString("u_password");
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(state, rSet);
		}
		return users;
	}

	/*
	 * 通过数组查找账号
	 */
	public static boolean findAccount(String account, String[][] users) {
		int j = 0;// 同步i
		for (int i = 0; i < users.length; i++) {
			if (account.equals(users[i][0])) {
				break;
			}
			j++;
		}
		if (j == users.length) {
			return false;// 无相同账号
		} else {
			return true;// 有相同账号
		}

	}
	/*
	 * 通过账号查找密码
	 */
	public static boolean findPassword(String account,String password,String[][]users){
		int j =0;
		for(int i = 0;i<users.length;i++){
//			System.out.println(i+" "+users[i][0]+" "+users[i][1]);
			if (account.equals(users[i][0])) {
				if(password.equals(users[i][1])){
					break;
				}
			}
			j++;
		}
//		System.out.println(j);
		if(j==users.length){
			return false;
		}else{
			return true;
		}
	}
	/*
	 * 注册
	 */
	public void signUp() {

		/*
		 * 准备sql语句
		 */
		// 获得用户键入信息

		System.out.println("-----注册-----");
		System.out.println("请输入账号（手机号）：");
		String account = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		// 判断是否合法
		String accoutRegex = "[1][0-9]{10}";
		String passRegex = "[0-9a-zA-Z]{6}";
		boolean accountIsLegal = account.matches(accoutRegex);
		boolean passIsLegal = password.matches(passRegex);
		if (!accountIsLegal) {
			System.out.println("账号输入不正确，请输入11位手机号");
		} else if (!passIsLegal) {
			System.out.println("密码输入不正确，请输入由字母+数字的6位密码");
		} else {// 若账号密码合法
			/*
			 * 判断账号是否已存在
			 */
			// 获取数据库资料
			String[][] users = getMessage(con);
			// 判断账号是否已存在
			boolean isExist = findAccount(account, users);
			if (!isExist) {// 如果账号不存在，则插入用户信息
				// 准备sql语句
				String sql = "INSERT INTO users(u_account,u_password) VALUES(?,?)";
				/*
				 * 创建状态，提交sql语句
				 */
				PreparedStatement state = null;
				try {
					state = con.prepareStatement(sql);
					//设置参数
					state.setString(1, account);
					state.setString(2, password);
					//执行sql
					int row = state.executeUpdate();
					if(row>0){
						System.out.println("注册成功");						
					}else{
						System.out.println("注册失败");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(state);
				}
			} else {
				System.out.println("账号已存在");
			}

		}

	}

	/*
	 * 登陆
	 */
	public void signIn() {
		System.out.println("-----登录-----");
		System.out.println("请输入账号：");
		String account = sc.nextLine();
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		//获取数据库users资料
		String[][] users = getMessage(con);
		//查找账号、密码是否存在且匹配
		boolean isRight = findPassword(account, password, users);
		if(isRight){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		
	}
}
