package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * ��ѯ���-----���ݷ��ʶ���
 */
public class BalanceDao {
	public int getBalance(String name) {
		int balance = 0;
		UserDatabase user = new UserDatabase();
		//��ѯuserdata[]�е��˻������Ϣ
		for(int i = 0;i<user.userData.length;i++) {
			if(user.userData[i].getName().equals(name)) {
				return user.userData[i].getMoney();
			}
		}
		return balance;
	}
}
