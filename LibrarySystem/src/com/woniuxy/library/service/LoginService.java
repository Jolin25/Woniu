package com.woniuxy.library.service;

import java.util.Scanner;

import com.woniuxy.library.dao.LoginDao;
import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * ��½�߼�����
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class LoginService {
	public boolean loginS() {
		System.out.println("�������û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		//�������ݽ����㣬�����û������Ҷ���
		LoginDao ld = new LoginDao();
		User user = ld.loginD(name);
		if(user!=null) {//������ز�Ϊ��
			if(user.getPassword().equals(password)) {//�Ա�����
				Database.nowUser = user;//�ѵ�ǰ�û���ֵΪ�ö���
				return true;
			}
		}else {//�������ΪĬ�ϵĿ�
			System.out.println("�û���������");
		}
		return false;
	}
}
