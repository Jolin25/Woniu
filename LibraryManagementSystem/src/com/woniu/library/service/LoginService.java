package com.woniu.library.service;

import java.util.Scanner;

import com.woniu.library.dao.LoginDao;
import com.woniu.library.dao.User;
import com.woniu.library.database.Database;

//��½�߼�
public class LoginService {

	public Boolean loginS() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String userName = sc.next();
		System.out.println("���������룺");
		String userPass = sc.next();
		LoginDao l = new LoginDao();
		User u  = l.loginD(userName);
		if (userPass.equals(u.getUserPass())) {
			Database.nowUser = u;//�޸����ݿ��еĵ�ǰ��¼����
			return true;
		}
		return false;

	}

}
