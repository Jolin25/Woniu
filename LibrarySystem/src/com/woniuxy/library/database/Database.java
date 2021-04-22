package com.woniuxy.library.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.library.dao.po.Book;
import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.dao.po.WaterInformation;

/**
 * 数据库
 * 
 * @author 小虫子的小日常
 *
 */
public class Database {
	public static User nowUser;// 当前登陆用户
	public static Book nowBook;// 当前被借的书籍
	// 内存中所有书籍信息
	public static List<Book> books = new ArrayList<Book>();
	// 内存中所有用户信息
	public static List<User> users = new ArrayList<User>();
	// 内存中所有流水信息
	public static List<WaterInformation> waterInfomations = new ArrayList<WaterInformation>();
	/*
	 * 启动时加载信息
	 */
	static {
		try {
			loadBook();
			loadUser();
			loadWaterInformation();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 加载用户信息：从外部文件读取到内存中
	 */
	public static void loadUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\user.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		users = (List<User>) ois.readObject();
		ois.close();
	}

	/*
	 * 加载书籍信息
	 */
	public static void loadBook() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\book.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		books = (List<Book>) ois.readObject();
		ois.close();
	}

	/*
	 * 加载流水信息
	 */
	public static void loadWaterInformation() throws ClassNotFoundException, IOException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\waterInformation.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		waterInfomations = (List<WaterInformation>) ois.readObject();
		ois.close();
	}

	/*
	 * 跟新用户信息
	 */
	public static void updateUserTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(users);
		oos.flush();
		oos.close();
	}

	/*
	 * 跟新书籍信息
	 */
	public static void updateBookTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\book.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}

	/*
	 * 跟新流水信息
	 */
	public static void updateWaterInformationTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\waterInformation.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(waterInfomations);
		oos.flush();
		oos.close();
	}

	/*
	 * 初始化原始数据user.txt，一个管理员用户，一个普通用户(只有最开始调用过一回，去初始化文件信息)
	 */
	public static void initUser() throws FileNotFoundException, IOException {
		User user = new User("admin", "admin1", 0);// 管理员
		User user1 = new User("zhang3", "zhang3", 1);// 普通用户
		users.add(user1);
		users.add(user);
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(users);
		oos.flush();
		oos.close();
	}

	/*
	 * 初始化原始数据book.txt(只有最开始调用过一回，去初始化文件信息)
	 */
	public static void initBook() throws FileNotFoundException, IOException {
		Book book = new Book("001", "未来简史", "科普类", 4, false);
		Book book1 = new Book("002", "时间简史", "科普类", 4, false);
		Book book2 = new Book("003", "人类简史", "科普类", 4, false);
		books.add(book);
		books.add(book1);
		books.add(book2);
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统\\图书馆管理系统（ok）\\database\\book.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}

}
