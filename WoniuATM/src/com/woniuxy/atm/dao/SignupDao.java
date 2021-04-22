package com.woniuxy.atm.dao;

import java.io.IOException;

import com.woniuxy.atm.database.UserDatabase;
import com.woniuxy.atm.database.UserTemplateDatabase;

/*
 * 注册----数据访问对象
 */
public class SignupDao {
	public boolean signup(String name, String password) throws IOException {
		// 查找是否用户名已存在
		boolean flag = true;// 标志是否用户名已存在
		for (UserTemplateDatabase u : UserDatabase.userData) {
			if (u != null) {
				if (u.getName().equals(name)) {
					System.out.println("用户名已存在");
					flag = false;//标志用户名已存在
					return false;
				}
			}
		}
		//如果用户名不存在，则进入数据库，保存新的账户
		if(flag) {
			UserDatabase userD = new UserDatabase();
			userD.addUserData(name, password);
		}
		return true;
	}
}
