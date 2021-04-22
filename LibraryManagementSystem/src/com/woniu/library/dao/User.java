package com.woniu.library.dao;

import java.io.Serializable;

/*
 * 用户数据访问层
 */
public class User implements Serializable {
	private String userName;//用户姓名
	private String userPass;//用户密码
	private int limits ;//用户权限
	//构造器
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
