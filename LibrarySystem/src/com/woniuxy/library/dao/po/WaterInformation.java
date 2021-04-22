package com.woniuxy.library.dao.po;

import java.io.Serializable;
import java.util.Date;

/**
 * ��ˮ��Ϣ�������� ���ԣ�����ţ�String id�������飩�û��˺ţ�String userName���鼮:�鼮���ƣ�String
 * boolName���鼮��ţ� String bookId���鼮���ࣺString bookType������ʱ�䣺Date out������ʱ�䣺Date in
 */
public class WaterInformation implements Serializable {
	//����
	private String id;
	private String userName;
	private String boolName;
	private String bookId;
	private String bookType;
	private Date out;
	private Date in;
	/*
	 * ������
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
		return "[��ˮid��" + id + ", �����ˣ�" + userName + ", �鼮���ƣ�" + boolName + ", �鼮Id��" + bookId
				+ ", �鼮���ͣ�" + bookType + ", ���ʱ�䣺" + out + ", ����ʱ�䣺" + in + "]";
	}
	
	
	
	
}
