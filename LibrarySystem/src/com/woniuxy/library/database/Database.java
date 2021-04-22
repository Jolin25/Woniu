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
 * ���ݿ�
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Database {
	public static User nowUser;// ��ǰ��½�û�
	public static Book nowBook;// ��ǰ������鼮
	// �ڴ��������鼮��Ϣ
	public static List<Book> books = new ArrayList<Book>();
	// �ڴ��������û���Ϣ
	public static List<User> users = new ArrayList<User>();
	// �ڴ���������ˮ��Ϣ
	public static List<WaterInformation> waterInfomations = new ArrayList<WaterInformation>();
	/*
	 * ����ʱ������Ϣ
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
	 * �����û���Ϣ�����ⲿ�ļ���ȡ���ڴ���
	 */
	public static void loadUser() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\user.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		users = (List<User>) ois.readObject();
		ois.close();
	}

	/*
	 * �����鼮��Ϣ
	 */
	public static void loadBook() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\book.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		books = (List<Book>) ois.readObject();
		ois.close();
	}

	/*
	 * ������ˮ��Ϣ
	 */
	public static void loadWaterInformation() throws ClassNotFoundException, IOException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\waterInformation.txt");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		waterInfomations = (List<WaterInformation>) ois.readObject();
		ois.close();
	}

	/*
	 * �����û���Ϣ
	 */
	public static void updateUserTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(users);
		oos.flush();
		oos.close();
	}

	/*
	 * �����鼮��Ϣ
	 */
	public static void updateBookTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\book.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}

	/*
	 * ������ˮ��Ϣ
	 */
	public static void updateWaterInformationTxt() throws FileNotFoundException, IOException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\waterInformation.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(waterInfomations);
		oos.flush();
		oos.close();
	}

	/*
	 * ��ʼ��ԭʼ����user.txt��һ������Ա�û���һ����ͨ�û�(ֻ���ʼ���ù�һ�أ�ȥ��ʼ���ļ���Ϣ)
	 */
	public static void initUser() throws FileNotFoundException, IOException {
		User user = new User("admin", "admin1", 0);// ����Ա
		User user1 = new User("zhang3", "zhang3", 1);// ��ͨ�û�
		users.add(user1);
		users.add(user);
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\user.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(users);
		oos.flush();
		oos.close();
	}

	/*
	 * ��ʼ��ԭʼ����book.txt(ֻ���ʼ���ù�һ�أ�ȥ��ʼ���ļ���Ϣ)
	 */
	public static void initBook() throws FileNotFoundException, IOException {
		Book book = new Book("001", "δ����ʷ", "������", 4, false);
		Book book1 = new Book("002", "ʱ���ʷ", "������", 4, false);
		Book book2 = new Book("003", "�����ʷ", "������", 4, false);
		books.add(book);
		books.add(book1);
		books.add(book2);
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ\\ͼ��ݹ���ϵͳ��ok��\\database\\book.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}

}
