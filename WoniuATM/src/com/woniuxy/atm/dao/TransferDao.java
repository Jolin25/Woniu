package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;

/*
 * ת��-----���ݶ���
 */
public class TransferDao {
	boolean flag = false;
	boolean flagTargetName = false;
	public boolean transfer(String nowUserName, String targetName, int money) {
		for (int i = 0; i < UserDatabase.userData.length; i++) {
			//�ҵ���ǰ�û�
			if (nowUserName.equals(UserDatabase.userData[i].getName())) {
				//�жϵ�ǰ�û�����Ƿ����
				if (UserDatabase.userData[i].getMoney() >= money) {
					//�ҵ�Ŀ���˻�
					for (int j = 0; j < UserDatabase.userData.length; j++) {
						if (UserDatabase.userData[j].getName().equals(targetName)) {
							int balanceT = UserDatabase.userData[j].getMoney();
							UserDatabase.userData[j].setMoney(money + balanceT);// ��Ŀ���˻�ת��
							int balance = UserDatabase.userData[i].getMoney();
							UserDatabase.userData[i].setMoney(balance-money);
							flag = true;
							flagTargetName = true;
							break;
						
						}
						
					}
					if(!flagTargetName) {
						System.out.println("Ҫת�����û�������");
					}
				} else {
					System.out.println("���㣬�޷�ת��");
					flag = false;
					
				}
			}

		}
		return flag;
	
	}
}
