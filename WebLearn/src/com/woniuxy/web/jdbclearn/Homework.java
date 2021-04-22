package com.woniuxy.web.jdbclearn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 1����ɵ�¼ע�Ṧ�ܣ����û�ͨ������̨�����˺�������Ϣ�����ݴ洢����Դ�����ݿ⣻ ������
 * Ҫ��ע�ᡢ��½��ע����Ϣ���������ݿ��У���½ͨ����ȡ���ݿ���Ϣ�Ա� ˼·��ע�᣺ͨ���������ݿ���woniushop�����users�����һ�����ݣ�
 * ��½��seclect��ȡusers������ݣ����жԱ� ������JDBC��ʹ�����������������������Բ��ã�
 * ϸ�ڣ�ע�᣺�绰��11λ��������ʽ������6λ��������ʽ���绰�Ų�׼�ظ��� ��½����ûɶ
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Homework {
	// ��һ��һ��ʼ�������ˣ�������������ݣ��Ƿ��ȡ����ʱҲ��õ������µġ�--->�ǵġ���������Ϊ��ʱ���Ѿ����ȥ��
	static Connection con = null;
	static Scanner sc = null;

	static {
		// ���������࣬��ȡ���ݿ�����
		con = JDBCUtil.getConnection();
	}

	/*
	 * ������
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Homework h = new Homework();
		h.signUp();
		h.signIn();
		// �ر�����
		JDBCUtil.close(con);
		// �ر�Scanner
		sc.close();
	}

	/*
	 * ��ȡ���ݿ���users�����Ϣ
	 */
	public static String[][] getMessage(Connection con) {
		// ������洢�����ݿ��ж�ȡ������(�˺ţ�����)
		String[][] users = new String[100][2];
		// ׼��sql
		String sql = "SELECT u_account,u_password FROM users";
		// ����state��ִ��sql
		Statement state = null;
		ResultSet rSet = null;
		try {
			state = con.createStatement();
			rSet = state.executeQuery(sql);
			int i = 0;
			while (rSet.next()) {
				// ����ȡ�������ݴ���users������
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
	 * ͨ����������˺�
	 */
	public static boolean findAccount(String account, String[][] users) {
		int j = 0;// ͬ��i
		for (int i = 0; i < users.length; i++) {
			if (account.equals(users[i][0])) {
				break;
			}
			j++;
		}
		if (j == users.length) {
			return false;// ����ͬ�˺�
		} else {
			return true;// ����ͬ�˺�
		}

	}
	/*
	 * ͨ���˺Ų�������
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
	 * ע��
	 */
	public void signUp() {

		/*
		 * ׼��sql���
		 */
		// ����û�������Ϣ

		System.out.println("-----ע��-----");
		System.out.println("�������˺ţ��ֻ��ţ���");
		String account = sc.nextLine();
		System.out.println("���������룺");
		String password = sc.nextLine();
		// �ж��Ƿ�Ϸ�
		String accoutRegex = "[1][0-9]{10}";
		String passRegex = "[0-9a-zA-Z]{6}";
		boolean accountIsLegal = account.matches(accoutRegex);
		boolean passIsLegal = password.matches(passRegex);
		if (!accountIsLegal) {
			System.out.println("�˺����벻��ȷ��������11λ�ֻ���");
		} else if (!passIsLegal) {
			System.out.println("�������벻��ȷ������������ĸ+���ֵ�6λ����");
		} else {// ���˺�����Ϸ�
			/*
			 * �ж��˺��Ƿ��Ѵ���
			 */
			// ��ȡ���ݿ�����
			String[][] users = getMessage(con);
			// �ж��˺��Ƿ��Ѵ���
			boolean isExist = findAccount(account, users);
			if (!isExist) {// ����˺Ų����ڣ�������û���Ϣ
				// ׼��sql���
				String sql = "INSERT INTO users(u_account,u_password) VALUES(?,?)";
				/*
				 * ����״̬���ύsql���
				 */
				PreparedStatement state = null;
				try {
					state = con.prepareStatement(sql);
					//���ò���
					state.setString(1, account);
					state.setString(2, password);
					//ִ��sql
					int row = state.executeUpdate();
					if(row>0){
						System.out.println("ע��ɹ�");						
					}else{
						System.out.println("ע��ʧ��");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					JDBCUtil.close(state);
				}
			} else {
				System.out.println("�˺��Ѵ���");
			}

		}

	}

	/*
	 * ��½
	 */
	public void signIn() {
		System.out.println("-----��¼-----");
		System.out.println("�������˺ţ�");
		String account = sc.nextLine();
		System.out.println("���������룺");
		String password = sc.nextLine();
		//��ȡ���ݿ�users����
		String[][] users = getMessage(con);
		//�����˺š������Ƿ������ƥ��
		boolean isRight = findPassword(account, password, users);
		if(isRight){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
		
	}
}
