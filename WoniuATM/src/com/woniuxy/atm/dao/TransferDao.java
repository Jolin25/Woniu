package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * 转账-----数据对象
 */
public class TransferDao {
	boolean flag = false;
	boolean flagTargetName = false;
	public boolean transfer(String nowUserName, String targetName, int money) {
		for (int i = 0; i < UserDatabase.userData.length; i++) {
			//找到当前用户
			if (nowUserName.equals(UserDatabase.userData[i].getName())) {
				//判断当前用户余额是否充足
				if (UserDatabase.userData[i].getMoney() >= money) {
					//找到目标账户
					for (int j = 0; j < UserDatabase.userData.length; j++) {
						if (UserDatabase.userData[j].getName().equals(targetName)) {
							int balanceT = UserDatabase.userData[j].getMoney();
							UserDatabase.userData[j].setMoney(money + balanceT);// 给目标账户转账
							int balance = UserDatabase.userData[i].getMoney();
							UserDatabase.userData[i].setMoney(balance-money);
							flag = true;
							flagTargetName = true;
							break;
						
						}
						
					}
					if(!flagTargetName) {
						System.out.println("要转给的用户不存在");
					}
				} else {
					System.out.println("余额不足，无法转账");
					flag = false;
					
				}
			}

		}
		return flag;
	
	}
}
