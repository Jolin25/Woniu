package com.woniuxy.library.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * �������û��йص����ݽ���
 * @author С���ӵ�С�ճ�
 *
 */
public class UserDao {
/*
 * �����û�
 */
	public boolean addUserD(String name,String password) throws FileNotFoundException, IOException {
		for(int i =0;i<Database.users.size();i++) {
			User u =  Database.users.get(i);
			if(u.getName().equals(name)) {
				System.out.println("�û����Ѵ���");
				return false;
			}
		}
		User user = new User(name, password, 1);
		Database.users.add(user);//���������
		//�����û���Ϣ
		Database.updateUserTxt();
		return true;
	}
}
