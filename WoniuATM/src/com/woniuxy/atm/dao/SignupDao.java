package com.woniuxy.atm.dao;

import java.io.IOException;

import com.woniuxy.atm.database.UserDatabase;
import com.woniuxy.atm.database.UserTemplateDatabase;

/*
 * ע��----���ݷ��ʶ���
 */
public class SignupDao {
	public boolean signup(String name, String password) throws IOException {
		// �����Ƿ��û����Ѵ���
		boolean flag = true;// ��־�Ƿ��û����Ѵ���
		for (UserTemplateDatabase u : UserDatabase.userData) {
			if (u != null) {
				if (u.getName().equals(name)) {
					System.out.println("�û����Ѵ���");
					flag = false;//��־�û����Ѵ���
					return false;
				}
			}
		}
		//����û��������ڣ���������ݿ⣬�����µ��˻�
		if(flag) {
			UserDatabase userD = new UserDatabase();
			userD.addUserData(name, password);
		}
		return true;
	}
}
