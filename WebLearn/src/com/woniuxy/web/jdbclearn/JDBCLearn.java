package com.woniuxy.web.jdbclearn;
/**
 * JDBC学习：
 * 重要备注：导包千万别导错了：全都是sql包下的嗷，如果发生了要转换类型的事情，那么多半是导包倒错了
 * import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


/**
 * 构建JDBC应用程序
 * 
 * @author 小虫子的小日常
 *
 */
public class JDBCLearn {
	public static void main(String[] args) {
		JDBCLearn jLearn = new JDBCLearn();
		//jLearn.learnTwoWithUtil();
		//jLearn.prepareSt();
		jLearn.callableSt();
	}
	/*
	 * CallableStatement的使用
	 * 用于执行数据库中的存储过程
	 */
	public void callableSt(){
		//1.加载驱动类，获取数据库连接
		Connection con = JDBCUtil.getConnection();
		CallableStatement state =null;
		//2.准备sql：备注：调用数据库里的存储过程要用{}去包起来的哈
		String sql = "{CALL pro_cal(?,?)}";
		//3.创建状态，提交sql
		try {
			state = con.prepareCall(sql);
			//设置参数
			state.setString(1, "17760990684");
			//注册输出参数
			//char是数据库里面的类型表示
			state.registerOutParameter(2, java.sql.Types.CHAR);
			//执行sql
			state.execute();
			//获取输出参数。。。居然要这么获取。。
			//String是java里的类型表示
			String password = state.getString(2);
			System.out.println(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, state);
		}
				
	}
	/*
	 *  使用prepareStatement（）的版本:
	 *  	prepareStatement 是  statement的子接口
	 *   	调用excute系列方法的时候，记得不能传参数的哈
	 */
	public void prepareSt() {
		// 让用户输入要删除的用户名
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要删除的用户名：");
		String name = sc.nextLine();
		// 加载驱动、获取数据连接
		Connection con = JDBCUtil.getConnection();
		// 准备sql
		//用？来占位
		String sql = "DELETE FROM roles WHERE r_name = ? ";
		// 创建状态，提交并执行sql
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			//要设置参数的哈，第一个参数为设置第几个？，第二个参数是要设置的参数值
			state.setString(1,name);
			int row = state.executeUpdate();
			System.out.println("受影响的行数为：" + row);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtil.close(con, state);
		}

	}

	// 封装了加载等工具以后的版本
	public void learnTwoWithUtil() {
		// 让用户输入要新增的用户名
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入新的用户名：");
		String name = sc.nextLine();
		// 加载驱动、获取数据连接
		Connection con = JDBCUtil.getConnection();
		// 准备sql
		String sql = "INSERT INTO roles(r_name) VALUES('" + name + "') ";
		// 创建状态，提交并执行sql
		Statement state = null;
		try {
			state = con.createStatement();
			int row = state.executeUpdate(sql);
			System.out.println("受影响的行数为：" + row);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCUtil.close(con, state);
		}

	}

	// 最初版
	public void learnOne() {
		// 1.加载驱动类
		try {
			// 要写类全名哈：包名+类名
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.获取数据库连接
		// 这个url是数据库的哇，固定格式：jdbc:mysql://数据库主机：端口号/数据库名称?user=账号&password=密码
		String url = "jdbc:mysql://localhost:3306/woniushop";
		// 采用配置文件的形式，和url一起作为参数来获取数据库连接
		Properties jdbcPro = new Properties();
		// 加载properties文件
		try {
			jdbcPro.load(new FileReader(new File("jdbc.properties")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*
		 * 这三个资源都是要释放的哟，而且他们三个是互相关联的。所以不可以释放一部分，然后把对象作为返回值传给谁。
		 * 如果要传给谁的话，要用别的什么对象接受了，然后传回去。
		 */
		Connection con = null;
		Statement statement = null;
		ResultSet rSet = null;
		ResultSet rSet2 = null;
		try {
			// 获取数据库连接嗷（2步骤剩余嗷）
			con = DriverManager.getConnection(url, jdbcPro);
			// System.out.println(con);
			// 3.准备sql
			String sql = "INSERT INTO roles(r_name) VALUES('aha')";
			String sql2 = "DELETE FROM roles WHERE r_name = 'aha'";
			String sql3 = "SELECT r_name,r_flag FROM roles";
			// 4.执行sql语句
			// 创建statement对象（因为要关的哇，所以提升作用域嗷）
			statement = con.createStatement();
			// 提交sql，并且执行（跟新）
			int row = statement.executeUpdate(sql2);
			// 提交sql，并且执行（查询）
			rSet = statement.executeQuery(sql3);
			// 练习用excute方法
			// boolean hasSet = statement.execute(sql3);
			// System.out.println("是否有结果集：" + hasSet);
			// excute()方法，需要自己手动取出结果集
			// rSet2 = statement.getResultSet();
			// 5.处理结果
			System.out.println("受影响行数：" + row);
			/*
			 * 对于查询语句的结果集处理： 类似一个集合？因为返回的可能为多条语句，每条语句是以键值对的形式存在的 所以采用循环形式获取。
			 * 当获取到每条语句以后要把该条语句中的需要的列取出来， 结果集提供了getXXX方法，XXX代表以什么数据类型的形式取出来。
			 * 可以用列名或者对应的位置数字来作为参数。 备注：结果集对象.next（）返回的是一个boolean型值，其代表的是是否有下一行数据
			 * 如果有，那么该结果集对象会自动切换到下一行数据，并返回true；如果没有则会返回false。
			 */
			while (rSet.next()) {// 返回的是boolear型嗷
				String name = rSet.getString("r_name");
				int flag = rSet.getInt("r_flag");
				System.out.println("r_name:" + name + ",r_flag:" + flag);
			}
			System.out.println("excute()后，手动获得结果集，取出结果集的内容：");
			// while (rSet2.next()) {// 返回的是boolear型嗷
			// String name = rSet2.getString("r_name");
			// int flag = rSet2.getInt("r_flag");
			// System.out.println("r_name:" + name + ",r_flag:" + flag);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源（连接、statement）
			// try {
			// rSet2.close();
			// } catch (SQLException e) {
			// e.printStackTrace();
			// } finally {
			try {
				if (rSet != null)
					rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null)
						statement.close();
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
	}
}
