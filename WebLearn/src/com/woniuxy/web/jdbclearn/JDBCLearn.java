package com.woniuxy.web.jdbclearn;
/**
 * JDBCѧϰ��
 * ��Ҫ��ע������ǧ��𵼴��ˣ�ȫ����sql���µ�໣����������Ҫת�����͵����飬��ô����ǵ���������
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
 * ����JDBCӦ�ó���
 * 
 * @author С���ӵ�С�ճ�
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
	 * CallableStatement��ʹ��
	 * ����ִ�����ݿ��еĴ洢����
	 */
	public void callableSt(){
		//1.���������࣬��ȡ���ݿ�����
		Connection con = JDBCUtil.getConnection();
		CallableStatement state =null;
		//2.׼��sql����ע���������ݿ���Ĵ洢����Ҫ��{}ȥ�������Ĺ�
		String sql = "{CALL pro_cal(?,?)}";
		//3.����״̬���ύsql
		try {
			state = con.prepareCall(sql);
			//���ò���
			state.setString(1, "17760990684");
			//ע���������
			//char�����ݿ���������ͱ�ʾ
			state.registerOutParameter(2, java.sql.Types.CHAR);
			//ִ��sql
			state.execute();
			//��ȡ���������������ȻҪ��ô��ȡ����
			//String��java������ͱ�ʾ
			String password = state.getString(2);
			System.out.println(password);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, state);
		}
				
	}
	/*
	 *  ʹ��prepareStatement�����İ汾:
	 *  	prepareStatement ��  statement���ӽӿ�
	 *   	����excuteϵ�з�����ʱ�򣬼ǵò��ܴ������Ĺ�
	 */
	public void prepareSt() {
		// ���û�����Ҫɾ�����û���
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫɾ�����û�����");
		String name = sc.nextLine();
		// ������������ȡ��������
		Connection con = JDBCUtil.getConnection();
		// ׼��sql
		//�ã���ռλ
		String sql = "DELETE FROM roles WHERE r_name = ? ";
		// ����״̬���ύ��ִ��sql
		PreparedStatement state = null;
		try {
			state = con.prepareStatement(sql);
			//Ҫ���ò����Ĺ�����һ������Ϊ���õڼ��������ڶ���������Ҫ���õĲ���ֵ
			state.setString(1,name);
			int row = state.executeUpdate();
			System.out.println("��Ӱ�������Ϊ��" + row);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtil.close(con, state);
		}

	}

	// ��װ�˼��صȹ����Ժ�İ汾
	public void learnTwoWithUtil() {
		// ���û�����Ҫ�������û���
		Scanner sc = new Scanner(System.in);
		System.out.println("�������µ��û�����");
		String name = sc.nextLine();
		// ������������ȡ��������
		Connection con = JDBCUtil.getConnection();
		// ׼��sql
		String sql = "INSERT INTO roles(r_name) VALUES('" + name + "') ";
		// ����״̬���ύ��ִ��sql
		Statement state = null;
		try {
			state = con.createStatement();
			int row = state.executeUpdate(sql);
			System.out.println("��Ӱ�������Ϊ��" + row);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			JDBCUtil.close(con, state);
		}

	}

	// �����
	public void learnOne() {
		// 1.����������
		try {
			// Ҫд��ȫ����������+����
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.��ȡ���ݿ�����
		// ���url�����ݿ���ۣ��̶���ʽ��jdbc:mysql://���ݿ��������˿ں�/���ݿ�����?user=�˺�&password=����
		String url = "jdbc:mysql://localhost:3306/woniushop";
		// ���������ļ�����ʽ����urlһ����Ϊ��������ȡ���ݿ�����
		Properties jdbcPro = new Properties();
		// ����properties�ļ�
		try {
			jdbcPro.load(new FileReader(new File("jdbc.properties")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/*
		 * ��������Դ����Ҫ�ͷŵ�Ӵ���������������ǻ�������ġ����Բ������ͷ�һ���֣�Ȼ��Ѷ�����Ϊ����ֵ����˭��
		 * ���Ҫ����˭�Ļ���Ҫ�ñ��ʲô��������ˣ�Ȼ�󴫻�ȥ��
		 */
		Connection con = null;
		Statement statement = null;
		ResultSet rSet = null;
		ResultSet rSet2 = null;
		try {
			// ��ȡ���ݿ�����໣�2����ʣ��໣�
			con = DriverManager.getConnection(url, jdbcPro);
			// System.out.println(con);
			// 3.׼��sql
			String sql = "INSERT INTO roles(r_name) VALUES('aha')";
			String sql2 = "DELETE FROM roles WHERE r_name = 'aha'";
			String sql3 = "SELECT r_name,r_flag FROM roles";
			// 4.ִ��sql���
			// ����statement������ΪҪ�ص��ۣ���������������໣�
			statement = con.createStatement();
			// �ύsql������ִ�У����£�
			int row = statement.executeUpdate(sql2);
			// �ύsql������ִ�У���ѯ��
			rSet = statement.executeQuery(sql3);
			// ��ϰ��excute����
			// boolean hasSet = statement.execute(sql3);
			// System.out.println("�Ƿ��н������" + hasSet);
			// excute()��������Ҫ�Լ��ֶ�ȡ�������
			// rSet2 = statement.getResultSet();
			// 5.������
			System.out.println("��Ӱ��������" + row);
			/*
			 * ���ڲ�ѯ���Ľ�������� ����һ�����ϣ���Ϊ���صĿ���Ϊ������䣬ÿ��������Լ�ֵ�Ե���ʽ���ڵ� ���Բ���ѭ����ʽ��ȡ��
			 * ����ȡ��ÿ������Ժ�Ҫ�Ѹ�������е���Ҫ����ȡ������ ������ṩ��getXXX������XXX������ʲô�������͵���ʽȡ������
			 * �������������߶�Ӧ��λ����������Ϊ������ ��ע�����������.next�������ص���һ��boolean��ֵ�����������Ƿ�����һ������
			 * ����У���ô�ý����������Զ��л�����һ�����ݣ�������true�����û����᷵��false��
			 */
			while (rSet.next()) {// ���ص���boolear���
				String name = rSet.getString("r_name");
				int flag = rSet.getInt("r_flag");
				System.out.println("r_name:" + name + ",r_flag:" + flag);
			}
			System.out.println("excute()���ֶ���ý������ȡ������������ݣ�");
			// while (rSet2.next()) {// ���ص���boolear���
			// String name = rSet2.getString("r_name");
			// int flag = rSet2.getInt("r_flag");
			// System.out.println("r_name:" + name + ",r_flag:" + flag);
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.�ͷ���Դ�����ӡ�statement��
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
