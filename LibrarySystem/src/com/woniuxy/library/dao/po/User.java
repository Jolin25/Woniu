package com.woniuxy.library.dao.po;

import java.io.Serializable;

/**
 * �û��ࣺ������ ���ԣ��˺ţ�String name�����룺String password��Ȩ�ޣ�int limit��0Ϊ����Ա��1Ϊ��ͨ�û���
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class User implements Serializable{
	//����
	private String name;
	private String password;
	private int limit;
	/*
	 * ������
	 */
	public User(String name, String password, int limit) {
		this.name = name;
		this.password = password;
		this.limit = limit;
	}
	/*
	 * getter��setter
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
