package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * 取钱-----数据
 */
public class DrawMoneyDao {
	public boolean drawMoney(String name, int money) {
		for (int i = 0; i < UserDatabase.userData.length; i++) {
			if (UserDatabase.userData[i].getName().equals(name)) {
				if (UserDatabase.userData[i].getMoney() >= money) {
					int balance = UserDatabase.userData[i].getMoney();
					UserDatabase.userData[i].setMoney(balance - money);

				} else {
					System.out.println("余额不足");
					return false;
				}
			}
		}
		return true;
	}
}
