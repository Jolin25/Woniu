package com.woniu.library.dao;

import java.io.Serializable;

/*
 * �û����ݷ��ʲ�
 */
public class User implements Serializable {
	private String userName;//�û�����
	private String userPass;//�û�����
	private int limits ;//�û�Ȩ��
	//������
	public User(String userName, String userPass, int limits) {
		this.userName = userName;
		this.userPass = userPass;
		this.limits = limits;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getLimits() {
		return limits;
	}
	public void setLimits(int limits) {
		this.limits = limits;
	}
	
	
}
