package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * 查询余额-----数据访问对象
 */
public class BalanceDao {
	public int getBalance(String name) {
		int balance = 0;
		UserDatabase user = new UserDatabase();
		//查询userdata[]中的账户余额信息
		for(int i = 0;i<user.userData.length;i++) {
			if(user.userData[i].getName().equals(name)) {
				return user.userData[i].getMoney();
			}
		}
		return balance;
	}
}
