package com.woniuxy.atm.service;

import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.SignupDao;

/*
 * ע���˻�----ҵ���߼�
 */
public class SignUpService {
	/*
	 * ע���˻�
	 */
	public boolean signUp() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������µ��û�����");
		String name = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		SignupDao signD = new SignupDao();
		boolean i =signD.signup(name, password);//����signupdao����
		//ע��ɹ�����true��ʧ�ܷ���false
		return i;
		
	}
	
}
