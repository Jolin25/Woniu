package com.woniuxy.atm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.LoginDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * ��½------ҵ���߼�
 */
public class LoginService {
	public boolean LoginS() throws FileNotFoundException, IOException  {
		// �����û�������
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		// ����dao ���ж��û����Ƿ���������ݿ��У��Ƿ�������ƥ��
		LoginDao log = new LoginDao();
		UserDatabase.nowUserAccount =log.loginDA(name);//���˻��ŷ���nowUserAccount��
		String i = log.loginDP(name);// �����صĶ�Ӧ�������i��
		if (i != null) {
			if (i.equals(password)) {
				System.out.println("��½�ɹ���");
				UserDatabase.nowUserName = name;//��Ŀǰ��½�û���
				UserDatabase.nowBalance = new BalanceService().getBalance(UserDatabase.nowUserName);
				UserDatabase.nowPass = password;
				UserDatabase.saveNowUser();//���浱ǰ��¼�û��������ļ���
				
				return true;
			} else {
			//	System.out.println("�����������");
				try {
					throw new LoginException("�����������");
				} catch (LoginException e) {
			
					System.out.println(e.getMessage());
				}
				return false;
			}
		}else {
		//	System.out.println("�û����������");
			
			try {
				throw new LoginException("�û����������");
			} catch (LoginException e) {
				
				System.out.println(e.getMessage());
				
			}
			return false;
		}
		
	}
}
