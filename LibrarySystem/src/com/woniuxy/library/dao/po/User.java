package com.woniuxy.library.dao.po;

import java.io.Serializable;

/**
 * 用户类：数据类 属性：账号：String name；密码：String password；权限：int limit（0为管理员，1为普通用户）
 * 
 * @author 小虫子的小日常
 *
 */
public class User implements Serializable{
	//属性
	private String name;
	private String password;
	private int limit;
	/*
	 * 构造器
	 */
	public User(String name, String password, int limit) {
		this.name = name;
		this.password = password;
		this.limit = limit;
	}
	/*
	 * getter、setter
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
