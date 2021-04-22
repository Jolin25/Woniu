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
 * 用户信息数据库
 */
public class UserDatabase {
	// 定义用户信息的对象数组
	public static UserTemplateDatabase[] userData = new UserTemplateDatabase[3];// 设为static会有什么影响？
	public static String nowUserName;// 用于保存目前登陆用户的用户名
	public static int nowBalance;// 用于保存目前登陆用户的余额
	public static String nowPass;// 用于保存目前登陆用户的密码
	public static int nowChangeMoney;// 用于保存目前登陆账户进行操作的金额
	public static String nowUserAccount;// 用于储存目前登陆用户的账号
	/*
	 * 将当前登录对象单独保存于一个本地文件中
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
	 * 初始化数据库
	 */
	static {
		UserDatabase ud = new UserDatabase();
		try {
			// ud.addNull();
			ud.loadUsers();// 开始时加载文件数据
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 加载数据前：手动添加null
	 */
	/*
	 * public void addNull() throws FileNotFoundException, IOException { File file =
	 * new File("d:\\TestFile1\\users.txt"); ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(file)); oos.writeObject(null);
	 * oos.flush(); oos.close(); }
	 */
	/*
	 * 加载数据：RandomAccessFile版本
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
			System.out.println("当前余额：" + Integer.valueOf(strs[3]));
			if (Integer.valueOf(strs[3]) < 1000) {// 将余额低于1000的设置为1000
				// System.out.println(str.length());
				System.out.println("当前指针：" + raf.getFilePointer());
				if (raf.getFilePointer() + 29 > 85) {// 判断有没有到最后一行，因为最后一行的后面没有/r/n
					System.out.println("=======");
					// long pointer = raf.getFilePointer();
					// System.out.println("readLine()以后的指针位置："+pointer);
					// raf.seek(pointer - (29));

					u.setMoney(1000);
					long pointer = raf.getFilePointer();
					raf.seek(pointer - 8);
					raf.write("001000".getBytes());// 将余额低于1000的设置为1000,存入文件
					pointer = raf.getFilePointer();
					raf.seek(pointer + 2);
					System.out.println("正常一波操作以后计划到达当前对象的下一行行首：" + raf.getFilePointer());
					System.out.println("=======");
				} else {
					System.out.println("=======");
					// long pointer = raf.getFilePointer();
					// System.out.println("到达最后一行前一波readLine()以后的指针位置："+pointer);
					// raf.seek(pointer - (27));
					System.out.println("计划最后一行行首的位置：" + raf.getFilePointer());
					u.setMoney(1000);
					long pointer = raf.getFilePointer();
					raf.seek(pointer - 6);
					raf.write("001000".getBytes());// 将余额低于1000的设置为1000,存入文件
					// pointer = raf.getFilePointer();
					// raf.seek(pointer);
				}
			} else {
				u.setMoney(Integer.valueOf(strs[3]));
			}
			// 动态扩容
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
	 * 加载数据：对象流版本
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
	 * 加载数据:缓存流版本
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
	 * u.setMoney(Integer.valueOf(strs[3])); // 如果对象数组容量不够，则动态扩容 if (userData.length
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
	 * 保存用户信息：缓存流版本
	 */
	// Test类里无法调用？？
	// 因为Test类的while里面的判断语句是true，故无法相似while循环外面去再写任何语句

	// 把所有的对象数组存到文件中
	/*
	 * public void upload() throws IOException { File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new BufferedWriter(new
	 * FileWriter(file)); for (int i = 0; i < userData.length; i++) { if
	 * (userData[i] != null) { bw.write(userData[i].getAccountNumber() + ":" +
	 * userData[i].getName() + ":" + userData[i].getPassword() + ":" +
	 * userData[i].getMoney()); bw.newLine(); } } bw.flush(); bw.close(); }
	 */
	/*
	 * 保存用户信息：对象流版本
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
	 * 保存数据：RandomAccessFile版本
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
	// 预存数据
	/*
	 * public void initUsers() throws IOException { UserTemplateDatabase u = new
	 * UserTemplateDatabase();// 创建调用模板的对象 u.setAccountNumber("woniu1");
	 * u.setName("张一"); u.setPassword("1"); u.setMoney(1000); userData[0] = u;//
	 * 将u的地址值传递给userData[0] u = new UserTemplateDatabase();// 重新指向一片新的内存
	 * u.setAccountNumber("woniu2"); u.setName("张二"); u.setPassword("2");
	 * u.setMoney(1000); userData[1] = u;// 将u的地址值传递给userData[1] u = new
	 * UserTemplateDatabase();// 重新指向一片新的内存 u.setAccountNumber("woniu3");
	 * u.setName("张三"); u.setPassword("3"); u.setMoney(1000); userData[2] = u;//
	 * 将u的地址值传递给userData[2] //把数据写入文件中 File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw =new BufferedWriter(new
	 * FileWriter(file)); for(int i=0;i<userData.length;i++) {
	 * bw.write(userData[i].getAccountNumber()+":"+userData[i].getName()+":"+
	 * userData[i].getPassword()+":"+userData[i].getMoney()); bw.write("\r\n"); }
	 * bw.flush(); bw.close(); }
	 */
	/*
	 * public void uploadData() throws IOException { //把数据写入文件中 File file = new
	 * File("d:\\TestFile1\\users.txt"); BufferedWriter bw =new BufferedWriter(new
	 * FileWriter(file)); for(int i=0;i<userData.length;i++) {
	 * bw.write(userData[i].getAccountNumber()+userData[i].getName()+userData[i].
	 * getPassword()+userData[i].getMoney()); } bw.flush(); bw.close(); }
	 */

	// 生成账号
	public String newAccountNumber() {
		String newAccountNumber = null;
		boolean flag = false;
		for (int i = 0; i < userData.length; i++) {
			// 如果数据库未满，则用为空的那个下标+1作为下一个账号数字
			if (userData[i] == null) {
				int number = i + 1;// 按顺序目前可以排到的账号数字，从001开始的
				String strnumber = Integer.toString(number);
				newAccountNumber = "woniu" + strnumber;
				flag = true;
				break;
			}
		} // 如果数据库已满，则用数据库的长度作为下一个账号数字
		if (!flag) {
			int number = userData.length + 1;// 按顺序目前可以排到的账号数字，从001开始的
			String strnumber = Integer.toString(number);
			newAccountNumber = "woniu" + strnumber;
		}
		/*
		 * 缓存流版本： 把数据写入文件中
		 */
		/*
		 * File file = new File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(file, true)); bw.write("\r\n");
		 * bw.write(newAccountNumber); bw.flush(); bw.close();
		 */
		return newAccountNumber;
	}

	// 添加账户
	public void addUserData(String name, String password) throws IOException {
		boolean flag = true;// 标志数据库是否满
		for (int i = 0; i < userData.length; i++) {

			// 如果数据库还未满，则添加新的账户信息

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
		// 如果数据库已满，则动态扩容
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
		 * 缓存流版本： 把数据写入文件中
		 * 
		 */

		/*
		 * File file = new File("d:\\TestFile1\\users.txt"); BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(file, true)); bw.write(":" + name + ":" +
		 * password + ":" + 1000); bw.flush(); bw.close();
		 */

	}
}
