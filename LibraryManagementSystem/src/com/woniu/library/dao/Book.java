package com.woniu.library.dao;

import java.io.Serializable;

/*
 * Book���ݷ��ʲ�
 */
public class Book implements Serializable{
	private String bookID;//�鼮��ţ�ʹ��String���ͣ���������Լ��
	private String bookName;//����
	private String bookType;//�鼮����
	private boolean isBorrowed;//�鼮�Ƿ��Ѿ������
	//Book������
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
