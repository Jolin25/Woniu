package com.woniuxy.library.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.library.dao.UserDao;

/**
 * �������û��йص��߼�ҵ��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class UserService {
	/*
	 * �����û�
	 */
	public void addUserS() throws FileNotFoundException, IOException {
		System.out.println("�������û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("�������û����룺");
		String password = sc.next();
		UserDao ud = new UserDao();
		boolean addUserD = ud.addUserD(name, password);
		if(addUserD) {
			System.out.println("��ӳɹ�");
			
		}else {
			System.out.println("���ʧ��");
		}
		
		
		
	}
}
