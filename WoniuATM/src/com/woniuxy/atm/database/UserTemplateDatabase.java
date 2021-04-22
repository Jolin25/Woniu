package com.woniuxy.atm.database;

import java.io.Serializable;

/*
 * 详细版用户数据库-----包含余额----->只是用来作为用户（user）的对象的模板而已
 * （其实是个失血模型啦，唔。。具体理解就是上一句）
 */
public class UserTemplateDatabase implements Serializable {
	private String accountNumber;//账号
	private String name;//用户名
	private String password;//密码
	private int money;//余额
// 设置getter和setter
	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	//构造方法

	public UserTemplateDatabase(String accountNumber, String name, String password, int money) {
		
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	
	public UserTemplateDatabase() {
		
	}

	@Override
	public String toString() {
		return "UserTemplateDatabase [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", money=" + money + "]";
	}
	

}
