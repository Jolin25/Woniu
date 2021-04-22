package com.woniuxy.library.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.woniuxy.library.dao.po.Book;
import com.woniuxy.library.database.Database;
import com.woniuxy.library.service.WaterInformationService;

/**
 * 数据交互层：暂定用来处理和书籍有关的数据交互
 * 
 * @author 小虫子的小日常
 *
 */
public class BookDao {
	/*
	 * 展示所有的书籍
	 */
	public List<Book> showAllBook() {
		return Database.books;

	}

	/*
	 * 租书
	 */
	public boolean rentBook(String chooseId) throws FileNotFoundException, IOException {
		for (int i = 0; i < Database.books.size(); i++) {
			Book book = Database.books.get(i);

			if (chooseId.equals(book.getId())) {// 找到指定书籍
				// 判断是否已经被借出
				if (book.isOut() == false) {
					Database.nowBook = book;// 把当前元素赋值给当前被借的书籍
					book.setOut(true);// 改变该元素的借阅状态
					Database.updateBookTxt();// 跟新书籍信息
					return true;
				} else {
					System.out.println("书籍已被其他用户借阅");
				}
			} 
		}
		return false;

	}

	/*
	 * 还书
	 */
	public boolean returnBookD(String bookId) throws FileNotFoundException, IOException {
		
		for (int i = 0; i < Database.books.size(); i++) {
			Book book = Database.books.get(i);
			// 找到书籍后，改变书籍借阅状态
			if (book.getId().equals(bookId)) {
				
				book.setOut(false);
				Database.updateBookTxt();// 跟新书籍信息
				return true;
			}
		}
		return false;

	}

	/*
	 * 查询指定书籍
	 */
	public Book findD(String name) {
		Book book = null;
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			// 找到书籍后，改变书籍借阅状态
			if (b.getName().equals(name)) {
				book = b;
				return book;
			}
		}
		return book;
	}
	/*
	 * 查询所有书籍
	 */
	public List<Book> lookBookD() {
		
		return Database.books;
		
	}
	/*
	 * 新增书籍
	 */
	public boolean addBookD(String name,String id,String type,int number) throws FileNotFoundException, IOException {
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.getName().equals(name)) {
				System.out.println("该书籍已存在");
				return false;
			}
		}
		Book book = new Book(id, name, type, number, false);
		Database.books.add(book);
		//跟新数据
		Database.updateBookTxt();
		return true;
	}
	/*
	 * 修改书籍信息
	 */
	public boolean modifyBookD(String id,String name,String type,int number,boolean isOut) throws FileNotFoundException, IOException {
		Book book = new Book(id, name, type, number, isOut);
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.equals(book)) {
				System.out.println("书籍信息相同");
				return false;
			}
			if(b.equals(Database.nowBook)) {//与当前书籍相同，则修改该元素
				Database.books.set(i, book);
			}
		}
		//跟新数据
		Database.updateBookTxt();
		return true;
	}
	/*
	 * 删除指定书籍
	 */
	public boolean deleteBookD(String name) throws FileNotFoundException, IOException {
		
		for (int i = 0; i < Database.books.size(); i++) {
			Book b = Database.books.get(i);
			if (b.getName().equals(name)) {
				Database.books.remove(b);
				//跟新数据
				Database.updateBookTxt();
				return true;
			}
		}
		return false;
		
	}
}
