package com.woniu.library.dao;

import java.io.Serializable;
import java.util.Date;

/*
 * ��ˮ��Ϣ--���ݷ��ʲ�
 */
public class WaterInf implements Serializable {
	private String  waterID;//��ˮ���
	private String  bookID;//�鼮���
	private String  bookName;//�鼮����
	private String  bookType;//�鼮��Ϣ
	private Date dateReturn  ;//�黹�鼮ʱ��
	private Date dateBorrow;//����鼮ʱ��
	private String  userName;// ����������
	
	//������
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
