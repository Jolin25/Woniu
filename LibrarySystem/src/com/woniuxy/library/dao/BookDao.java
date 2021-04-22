package com.woniuxy.library.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.woniuxy.library.dao.po.Book;
import com.woniuxy.library.database.Database;
import com.woniuxy.library.service.WaterInformationService;

/**
 * ���ݽ����㣺�ݶ�����������鼮�йص����ݽ���
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class BookDao {
	/*
	 * չʾ���е��鼮
	 */
	public List<Book> showAllBook() {
		return Database.books;

	}

	/*
	 * ����
	 */
	public boolean rentBook(String chooseId) throws FileNotFoundException, IOException {
		for (int i = 0; i < Database.books.size(); i++) {
			Book book = Database.books.get(i);

			if (chooseId.equals(book.getId())) {// �ҵ�ָ���鼮
				// �ж��Ƿ��Ѿ������
				if (book.isOut() == false) {
					Database.nowBook = book;// �ѵ�ǰԪ�ظ�ֵ����ǰ������鼮
					book.setOut(true);// �ı��Ԫ�صĽ���״̬
					Database.updateBookTxt();// �����鼮��Ϣ
					return true;
				} else {
					System.out.println("�鼮�ѱ������û�����");
				}
			} 
		}
		return false;

	}

	/*
	 * ����
	 */
	public boolean returnBookD(String bookId) throws FileNotFoundException, IOException {
		
		for (int i = 0; i < Database.books.size(); i++) {
			Book book = Database.books.get(i);
			// �ҵ��鼮�󣬸ı��鼮����״̬
			if (book.getId().equals(bookId)) {
				
				book.setOut(false);
				Database.updateBookTxt();// �����鼮��Ϣ
				return true;
			}
		}
		return false;

	}

	/*
	 * ��ѯָ���鼮
	 */
	public Book findD(String name) {
		Book book = null;
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			// �ҵ��鼮�󣬸ı��鼮����״̬
			if (b.getName().equals(name)) {
				book = b;
				return book;
			}
		}
		return book;
	}
	/*
	 * ��ѯ�����鼮
	 */
	public List<Book> lookBookD() {
		
		return Database.books;
		
	}
	/*
	 * �����鼮
	 */
	public boolean addBookD(String name,String id,String type,int number) throws FileNotFoundException, IOException {
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.getName().equals(name)) {
				System.out.println("���鼮�Ѵ���");
				return false;
			}
		}
		Book book = new Book(id, name, type, number, false);
		Database.books.add(book);
		//��������
		Database.updateBookTxt();
		return true;
	}
	/*
	 * �޸��鼮��Ϣ
	 */
	public boolean modifyBookD(String id,String name,String type,int number,boolean isOut) throws FileNotFoundException, IOException {
		Book book = new Book(id, name, type, number, isOut);
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.equals(book)) {
				System.out.println("�鼮��Ϣ��ͬ");
				return false;
			}
			if(b.equals(Database.nowBook)) {//�뵱ǰ�鼮��ͬ�����޸ĸ�Ԫ��
				Database.books.set(i, book);
			}
		}
		//��������
		Database.updateBookTxt();
		return true;
	}
	/*
	 * ɾ��ָ���鼮
	 */
	public boolean deleteBookD(String name) throws FileNotFoundException, IOException {
		
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.getName().equals(name)) {
				Database.books.remove(b);
				//��������
				Database.updateBookTxt();
				return true;
			}
		}
		return false;
		
	}
}
