package com.woniuxy.library.dao.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 流水信息：数据类 属性：租借编号：String id；（借书）用户账号：String userName；书籍:书籍名称：String
 * boolName；书籍编号： String bookId；书籍种类：String bookType；借书时间：Date out；还书时间：Date in
 */
public class WaterInformation implements Serializable {
	//属性
	private String id;
	private String userName;
	private String boolName;
	private String bookId;
	private String bookType;
	private Date out;
	private Date in;
	/*
	 * 构造器
	 */
	public WaterInformation(String id, String userName, String boolName, String bookId, String bookType, Date out,
			Date in) {
		
		this.id = id;
		this.userName = userName;
		this.boolName = boolName;
		this.bookId = bookId;
		this.bookType = bookType;
		this.out = out;
		this.in = in;
	}
	/*
	 * setter,getter
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBoolName() {
		return boolName;
	}
	public void setBoolName(String boolName) {
		this.boolName = boolName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public Date getOut() {
		return out;
	}
	public void setOut(Date out) {
		this.out = out;
	}
	public Date getIn() {
		return in;
	}
	public void setIn(Date in) {
		this.in = in;
	}
	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "[流水id：" + id + ", 租书人：" + userName + ", 书籍名称：" + boolName + ", 书籍Id：" + bookId
				+ ", 书籍类型：" + bookType + ", 借出时间：" + out + ", 还书时间：" + in + "]";
	}
	
	
	
	
}
