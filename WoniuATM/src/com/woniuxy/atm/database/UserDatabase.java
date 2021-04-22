package com.woniuxy.atm.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
 * �û���Ϣ���ݿ�
 */
public class UserDatabase {
	// �����û���Ϣ�Ķ�������
	public static UserTemplateDatabase[] userData = new UserTemplateDatabase[3];// ��Ϊstatic����ʲôӰ�죿
	public static String nowUserName;// ���ڱ���Ŀǰ��½�û����û���
	public static int nowBalance;// ���ڱ���Ŀǰ��½�û������
	public static String nowPass;// ���ڱ���Ŀǰ��½�û�������
	public static int nowChangeMoney;// ���ڱ���Ŀǰ��½�˻����в����Ľ��
	public static String nowUserAccount;// ���ڴ���Ŀǰ��½�û����˺�
	/*
	 * ����ǰ��¼���󵥶�������һ�������ļ���
	 */

	public static void saveNowUser() throws FileNotFoundException, IOException {
		File file = new File("d:\\TestFile1\\nowUser.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		UserTemplateDatabase u = new UserTemplateDatabase();
		u.setAccountNumber(nowUserAccount);
		u.setName(nowUserName);
		u.setMoney(nowBalance);
		u.setPassword(nowPass);
		oos.writeObject(u);
		oos.close();

	}

	/*
	 * ��ʼ�����ݿ�
	 */
	static {
		UserDatabase ud = new UserDatabase();
		try {
			// ud.addNull();
			ud.loadUsers();// ��ʼʱ�����ļ�����
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��������ǰ���ֶ����null
	 */
	/*
	 * public void addNull() throws FileNotFoundException, IOException { File file =
	 * new File("d:\\TestFile1\\users.txt"); ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(file)); oos.writeObject(null);
	 * oos.flush(); oos.close(); }
	 */
	/*
	 * �������ݣ�RandomAccessFile�汾
	 */
	public void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("d:\\TestFile1\\users.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String str = raf.readLine();
		int i = 0;
		while (str != null && str != "") {
			UserTemplateDatabase u = new UserTemplateDatabase();
			String[] strs = str.split(":");
			u.setAccountNumber(strs[0]);
			u.setName(strs[1]);
			u.setPassword(strs[2]);
			System.out.println("��ǰ��" + Integer.valueOf(strs[3]));
			if (Integer.valueOf(strs[3]) < 1000) {// ��������1000������Ϊ1000
				// System.out.println(str.length());
				System.out.println("��ǰָ�룺" + raf.getFilePointer());
				if (raf.getFilePointer() + 29 > 85) {// �ж���û�е����һ�У���Ϊ���һ�еĺ���û��/r/n
					System.out.println("=======");
					// long pointer = raf.getFilePointer();
					// System.out.println("readLine()�Ժ��ָ��λ�ã�"+pointer);
					// raf.seek(pointer - (29));

					u.setMoney(1000);
					long pointer = raf.getFilePointer();
					raf.seek(pointer - 8);
					raf.write("001000".getBytes());// ��������1000������Ϊ1000,�����ļ�
					pointer = raf.getFilePointer();
					raf.seek(pointer + 2);
					System.out.println("����һ�������Ժ�ƻ����ﵱǰ�������һ�����ף�" + raf.getFilePointer());
					System.out.println("=======");
				} else {
					System.out.println("=======");
					// long pointer = raf.getFilePointer();
					// System.out.println("�������һ��ǰһ��readLine()�Ժ��ָ��λ�ã�"+pointer);
					// raf.seek(pointer - (27));
					System.out.println("�ƻ����һ�����׵�λ�ã�" + raf.getFilePointer());
					u.setMoney(1000);
					long pointer = raf.getFilePointer();
					raf.seek(pointer - 6);
					raf.write("001000".getBytes());// ��������1000������Ϊ1000,�����ļ�
					// pointer = raf.getFilePointer();
					// raf.seek(pointer);
				}
			} else {
				u.setMoney(Integer.valueOf(strs[3]));
			}
			// ��̬����
			if (userData.length < i + 1) {

				UserTemplateDatabase[] newUserData = new UserTemplateDatabase[(int) (userData.length + 1)];

				UserTemplateDatabase nUser = new UserTemplateDatabase();
				for (int j = 0; j < userData.length; j++) {
					newUserData[j] = userData[j];
				}
				userData = newUserData;

			}
			userData[i++] = u;
			str = raf.readLine();
		}
		raf.close();

	}

	/*
	 * �������ݣ��������汾
	 */
	/*
	 * public void loadUsers() throws FileNotFoundException, IOException,
	 * ClassNotFoundException { File file = new File("d:\\TestFile1\\users.txt");
	 * ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	 * Object o = ois.readObject(); int i = 0; while (o != null) {
	 * UserTemplateDatabase u = (UserTemplateDatabase) ois.readObject(); if
	 * (userData.length < i + 1) {
	 * 
	 * UserTemplateDatabase[] newUserData = new UserTemplateDatabase[(int)
	 * (userData.length * 1.5)];
	 * 
	 * UserTemplateDatabase nUser = new UserTemplateDatabase(); for (int j = 0; j <
	 * userData.length; j++) { newUserData[j] = userData[j]; } userData =
	 * newUserData;
	 * 
	 * } userData[i++] = u;
	 * 
	 * } ois.close();
	 * 
	 * }
	 */
	/*
	 * ��������:�������汾
	 */
	/*
	 * public void loadUsers() throws IOException { File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedReader br = new BufferedReader(new
	 * FileReader(file)); String str = br.readLine(); int i = 0; while (str != null
	 * && str != "") {
	 * 
	 * String[] strs = str.split(":"); // System.out.println(Arrays.toString(strs));
	 * UserTemplateDatabase u = new UserTemplateDatabase();
	 * u.setAccountNumber(strs[0]); u.setName(strs[1]); u.setPassword(strs[2]);
	 * u.setMoney(Integer.valueOf(strs[3])); // �����������������������̬���� if (userData.length
	 * < i + 1) { UserTemplateDatabase[] newUserData = new
	 * UserTemplateDatabase[(int) (userData.length * 1.5)]; UserTemplateDatabase
	 * nUser = new UserTemplateDatabase();
	 * 
	 * for (int j = 0; j < userData.length; j++) { newUserData[j] = userData[j]; }
	 * userData = newUserData; } userData[i++] = u;
	 * 
	 * // System.out.println(userData[i].toString());
	 * 
	 * str = br.readLine(); } System.out.println("=========="); for
	 * (UserTemplateDatabase u : userData) { if (u != null)
	 * System.out.println(u.toString()); }
	 * 
	 * br.close();
	 * 
	 * }
	 */
	/*
	 * �����û���Ϣ���������汾
	 */
	// Test�����޷����ã���
	// ��ΪTest���while������ж������true�����޷�����whileѭ������ȥ��д�κ����

	// �����еĶ�������浽�ļ���
	/*
	 * public void upload() throws IOException { File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new BufferedWriter(new
	 * FileWriter(file)); for (int i = 0; i < userData.length; i++) { if
	 * (userData[i] != null) { bw.write(userData[i].getAccountNumber() + ":" +
	 * userData[i].getName() + ":" + userData[i].getPassword() + ":" +
	 * userData[i].getMoney()); bw.newLine(); } } bw.flush(); bw.close(); }
	 */
	/*
	 * �����û���Ϣ���������汾
	 */
	/*
	 * public void upload() throws FileNotFoundException, IOException { File file =
	 * new File("d:\\TestFile1\\users.txt"); ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(file)); for (int i = 0; i <
	 * userData.length; i++) { if (userData[i] != null) {
	 * oos.writeObject(userData[i]); } }
	 * 
	 * oos.flush(); oos.close(); }
	 */
	/*
	 * �������ݣ�RandomAccessFile�汾
	 */
	public void upload() throws IOException {
		File file = new File("d:\\TestFile1\\users.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		for (int i = 0; i < userData.length; i++) {
			if (userData[i] != null) {
				byte[] b = (userData[i].getAccountNumber() + ":" + userData[i].getName() + ":"
						+ userData[i].getPassword() + ":" + userData[i].getMoney()).getBytes();
				raf.write(b);
				raf.write("\r\n".getBytes());

			}
		}
		raf.close();
	}
	// Ԥ������
	/*
	 * public void initUsers() throws IOException { UserTemplateDatabase u = new
	 * UserTemplateDatabase();// ��������ģ��Ķ��� u.setAccountNumber("woniu1");
	 * u.setName("��һ"); u.setPassword("1"); u.setMoney(1000); userData[0] = u;//
	 * ��u�ĵ�ֵַ���ݸ�userData[0] u = new UserTemplateDatabase();// ����ָ��һƬ�µ��ڴ�
	 * u.setAccountNumber("woniu2"); u.setName("�Ŷ�"); u.setPassword("2");
	 * u.setMoney(1000); userData[1] = u;// ��u�ĵ�ֵַ���ݸ�userData[1] u = new
	 * UserTemplateDatabase();// ����ָ��һƬ�µ��ڴ� u.setAccountNumber("woniu3");
	 * u.setName("����"); u.setPassword("3"); u.setMoney(1000); userData[2] = u;//
	 * ��u�ĵ�ֵַ���ݸ�userData[2] //������д���ļ��� File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw =new BufferedWriter(new
	 * FileWriter(file)); for(int i=0;i<userData.length;i++) {
	 * bw.write(userData[i].getAccountNumber()+":"+userData[i].getName()+":"+
	 * userData[i].getPassword()+":"+userData[i].getMoney()); bw.write("\r\n"); }
	 * bw.flush(); bw.close(); }
	 */
	/*
	 * public void uploadData() throws IOException { //������д���ļ��� File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw =new BufferedWriter(new
	 * FileWriter(file)); for(int i=0;i<userData.length;i++) {
	 * bw.write(userData[i].getAccountNumber()+userData[i].getName()+userData[i].
	 * getPassword()+userData[i].getMoney()); } bw.flush(); bw.close(); }
	 */

	// �����˺�
	public String newAccountNumber() {
		String newAccountNumber = null;
		boolean flag = false;
		for (int i = 0; i < userData.length; i++) {
			// ������ݿ�δ��������Ϊ�յ��Ǹ��±�+1��Ϊ��һ���˺�����
			if (userData[i] == null) {
				int number = i + 1;// ��˳��Ŀǰ�����ŵ����˺����֣���001��ʼ��
				String strnumber = Integer.toString(number);
				newAccountNumber = "woniu" + strnumber;
				flag = true;
				break;
			}
		} // ������ݿ��������������ݿ�ĳ�����Ϊ��һ���˺�����
		if (!flag) {
			int number = userData.length + 1;// ��˳��Ŀǰ�����ŵ����˺����֣���001��ʼ��
			String strnumber = Integer.toString(number);
			newAccountNumber = "woniu" + strnumber;
		}
		/*
		 * �������汾�� ������д���ļ���
		 */
		/*
		 * File file = new File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(file, true)); bw.write("\r\n");
		 * bw.write(newAccountNumber); bw.flush(); bw.close();
		 */
		return newAccountNumber;
	}

	// ����˻�
	public void addUserData(String name, String password) throws IOException {
		boolean flag = true;// ��־���ݿ��Ƿ���
		for (int i = 0; i < userData.length; i++) {

			// ������ݿ⻹δ����������µ��˻���Ϣ

			if (userData[i] == null) {
				UserTemplateDatabase newUser = new UserTemplateDatabase();
				newUser.setAccountNumber(newAccountNumber());
				newUser.setName(name);
				newUser.setPassword(password);
				newUser.setMoney(1000);
				userData[i] = newUser;
				flag = false;
				break;
			}

		}
		// ������ݿ���������̬����
		if (flag) {
			UserTemplateDatabase[] newUserData = new UserTemplateDatabase[userData.length + 1];
			UserTemplateDatabase nUser = new UserTemplateDatabase();
			nUser.setAccountNumber(newAccountNumber());
			nUser.setName(name);
			nUser.setPassword(password);
			nUser.setMoney(1000);
			newUserData[newUserData.length - 1] = nUser;

			for (int i = 0; i < userData.length; i++) {
				newUserData[i] = userData[i];
			}
			userData = newUserData;

		}
		/*
		 * �������汾�� ������д���ļ���
		 * 
		 */

		/*
		 * File file = new File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(file, true)); bw.write(":" + name + ":" +
		 * password + ":" + 1000); bw.flush(); bw.close();
		 */

	}
}
