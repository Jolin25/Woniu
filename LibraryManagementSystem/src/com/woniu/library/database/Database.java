package com.woniu.library.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.woniu.library.dao.Book;
import com.woniu.library.dao.User;
import com.woniu.library.dao.WaterInf;

/*
 * 数据库
 */
public class Database {
	// 在程序开始时，就将外部文件读进程序
	// 内存中所有的书籍信息
	public static List<Book> books = new ArrayList<>();
	// 内存中所有的用户信息
	public static List<User> users = new ArrayList<>();
	// 内存中所有的流水信息
	public static List<WaterInf> waterInf = new ArrayList<>();
	//设置当前的登陆用户
	public static User nowUser;
	
	
	static {
		try {
			loadUser();
			loadWaterInf();
			loadBook();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	// 启动时加载User
	public static void loadUser() throws IOException, ClassNotFoundException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统 第三周\\数据库信息\\users.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.users = (List<User>) oi.readObject();
		oi.close();
		in.close();
	}

	// 启动时加载book
	public static void loadBook() throws IOException, ClassNotFoundException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统 第三周\\数据库信息\\books.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.books = (List<Book>) oi.readObject();
		oi.close();
		in.close();
	}

	// 启动时加载waterInf
	public static void loadWaterInf() throws IOException, ClassNotFoundException {
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统 第三周\\数据库信息\\waterInfs.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.waterInf = (List<WaterInf>) oi.readObject();
		oi.close();
		in.close();
	}

	// 初始化原始数据:users:一个普通用户，一个管理员用户
	public static void initUsers() throws IOException {
		User u = new User("admin", "admin", 1);// 管理员用户
		User u1 = new User("one", "one1", 0);// 普通用户
		users.add(u);
		users.add(u1);
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统 第三周\\数据库信息\\users.txt");
		OutputStream o = new FileOutputStream(file);
		ObjectOutputStream ob = new ObjectOutputStream(o);
		ob.writeObject(users);
		ob.flush();
		ob.close();
		o.close();
	}

	// 初始化原始书籍
	public static void initBooks() throws IOException {
		Book b1 = new Book("001", "从入门到放弃", "信息技术类", false);
		books.add(b1);
		File file = new File("D:\\文档们\\蜗牛\\项目\\图书馆管理系统 第三周\\数据库信息\\books.txt");
		OutputStream o = new FileOutputStream(file);
		ObjectOutputStream ob = new ObjectOutputStream(o);
		ob.writeObject(books);
		ob.flush();
		ob.close();
		o.close();
	}

	public static void main(String[] args) {

	}
}
