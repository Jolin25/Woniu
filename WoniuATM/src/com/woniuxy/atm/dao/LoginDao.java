package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;
import com.woniuxy.atm.database.UserTemplateDatabase;

/*
 * ��½------���ݷ��ʶ���
 * �ж��û����Ƿ���������ݿ��У��Ƿ�������ƥ��
 */
public class LoginDao {
	public String loginDP(String name) {
		String nowPassword = null;
		// ��UserDatabase���жԱȣ����Ƿ�ƥ��
		for (UserTemplateDatabase u : UserDatabase.userData) {
			// ������ݿ��������ݣ���ô���˻����Ƿ�ƥ��
			if (u != null) {
				// ����˻���ƥ�䣬����ȷ�����븳��nowPassword����LoginService����ƥ���ж�
				if (u.getName().equals(name)) {
					nowPassword = u.getPassword();
				}
			}
		}
		return nowPassword;
	}
	public String loginDA(String name) {
		String account = null;
		// ��UserDatabase���жԱȣ����Ƿ�ƥ��
		for (UserTemplateDatabase u : UserDatabase.userData) {
			// ������ݿ��������ݣ���ô���˻����Ƿ�ƥ��
			if (u != null) {
				// ����˻���ƥ�䣬���˻��ŷ���
				if (u.getName().equals(name)) {
					 account = u.getAccountNumber();
				}
			}
		}
		return account;
	}

}
