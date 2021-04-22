package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * È¡Ç®-----Êý¾Ý
 */
public class SaveMoneyDao {
	public boolean saveMoney(String name ,int money) {
		for (int i = 0; i < UserDatabase.userData.length; i++) {
			if (UserDatabase.userData[i].getName().equals(name)) {

				int balance = UserDatabase.userData[i].getMoney();
				UserDatabase.userData[i].setMoney(balance + money);

			}
		}
		
		return true;
	}
}
