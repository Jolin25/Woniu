package com.woniu.library.dao;

import java.io.Serializable;
import java.util.Date;

/*
 * 流水信息--数据访问层
 */
public class WaterInf implements Serializable {
	private String  waterID;//流水编号
	private String  bookID;//书籍编号
	private String  bookName;//书籍名称
	private String  bookType;//书籍信息
	private Date dateReturn  ;//归还书籍时间
	private Date dateBorrow;//借出书籍时间
	private String  userName;// 借书人姓名
	
	//构造器
	public WaterInf(String waterID, String bookID, String bookName, String bookType, Date dateReturn, Date dateBorrow,
			String userName) {
		
		this.waterID = waterID;
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookType = bookType;
		this.dateReturn = dateReturn;
		this.dateBorrow = dateBorrow;
		this.userName = userName;
	}
	
	
	
	public String getWaterID() {
		return waterID;
	}
	public void setWaterID(String waterID) {
		this.waterID = waterID;
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
	public Date getDateReturn() {
		return dateReturn;
	}
	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}
	public Date getDateBorrow() {
		return dateBorrow;
	}
	public void setDateBorrow(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
