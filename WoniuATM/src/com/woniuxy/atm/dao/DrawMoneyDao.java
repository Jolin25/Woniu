package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * ȡǮ-----����
 */
public class DrawMoneyDao {
	public boolean drawMoney(String name, int money) {
		for (int i = 0; i < UserDatabase.userData.length; i++) {
			if (UserDatabase.userData[i].getName().equals(name)) {
				if (UserDatabase.userData[i].getMoney() >= money) {
					int balance = UserDatabase.userData[i].getMoney();
					UserDatabase.userData[i].setMoney(balance - money);

				} else {
					System.out.println("����");
					return false;
				}
			}
		}
		return true;
	}
}
