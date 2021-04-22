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
 * ���ݿ�
 */
public class Database {
	// �ڳ���ʼʱ���ͽ��ⲿ�ļ���������
	// �ڴ������е��鼮��Ϣ
	public static List<Book> books = new ArrayList<>();
	// �ڴ������е��û���Ϣ
	public static List<User> users = new ArrayList<>();
	// �ڴ������е���ˮ��Ϣ
	public static List<WaterInf> waterInf = new ArrayList<>();
	//���õ�ǰ�ĵ�½�û�
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

	// ����ʱ����User
	public static void loadUser() throws IOException, ClassNotFoundException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ ������\\���ݿ���Ϣ\\users.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.users = (List<User>) oi.readObject();
		oi.close();
		in.close();
	}

	// ����ʱ����book
	public static void loadBook() throws IOException, ClassNotFoundException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ ������\\���ݿ���Ϣ\\books.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.books = (List<Book>) oi.readObject();
		oi.close();
		in.close();
	}

	// ����ʱ����waterInf
	public static void loadWaterInf() throws IOException, ClassNotFoundException {
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ ������\\���ݿ���Ϣ\\waterInfs.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(in);
		Database.waterInf = (List<WaterInf>) oi.readObject();
		oi.close();
		in.close();
	}

	// ��ʼ��ԭʼ����:users:һ����ͨ�û���һ������Ա�û�
	public static void initUsers() throws IOException {
		User u = new User("admin", "admin", 1);// ����Ա�û�
		User u1 = new User("one", "one1", 0);// ��ͨ�û�
		users.add(u);
		users.add(u1);
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ ������\\���ݿ���Ϣ\\users.txt");
		OutputStream o = new FileOutputStream(file);
		ObjectOutputStream ob = new ObjectOutputStream(o);
		ob.writeObject(users);
		ob.flush();
		ob.close();
		o.close();
	}

	// ��ʼ��ԭʼ�鼮
	public static void initBooks() throws IOException {
		Book b1 = new Book("001", "�����ŵ�����", "��Ϣ������", false);
		books.add(b1);
		File file = new File("D:\\�ĵ���\\��ţ\\��Ŀ\\ͼ��ݹ���ϵͳ ������\\���ݿ���Ϣ\\books.txt");
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
