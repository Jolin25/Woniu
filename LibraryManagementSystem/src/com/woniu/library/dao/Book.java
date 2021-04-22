package com.woniu.library.dao;

import java.io.Serializable;

/*
 * Book数据访问层
 */
public class Book implements Serializable{
	private String bookID;//书籍编号，使用String类型，避免主键约束
	private String bookName;//书名
	private String bookType;//书籍种类
	private boolean isBorrowed;//书籍是否已经被借出
	//Book构造器
	public Book(String bookID,String bookName,String bookType,boolean isBorrowed) {
		this.bookID  = bookID;
		this.bookName = bookName;
		this.bookType = bookType;
		this.isBorrowed = isBorrowed;
	}
	
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	
}
