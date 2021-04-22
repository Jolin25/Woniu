package com.woniuxy.atm.database;

import java.io.Serializable;

/*
 * ��ϸ���û����ݿ�-----�������----->ֻ��������Ϊ�û���user���Ķ����ģ�����
 * ����ʵ�Ǹ�ʧѪģ����������������������һ�䣩
 */
public class UserTemplateDatabase implements Serializable {
	private String accountNumber;//�˺�
	private String name;//�û���
	private String password;//����
	private int money;//���
// ����getter��setter
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
	//���췽��

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
