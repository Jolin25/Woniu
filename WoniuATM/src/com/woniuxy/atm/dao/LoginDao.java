package com.woniuxy.atm.dao;

import com.woniuxy.atm.database.UserDatabase;
import com.woniuxy.atm.database.UserTemplateDatabase;

/*
 * 登陆------数据访问对象
 * 判断用户名是否存在于数据库中，是否与密码匹配
 */
public class LoginDao {
	public String loginDP(String name) {
		String nowPassword = null;
		// 与UserDatabase进行对比，看是否匹配
		for (UserTemplateDatabase u : UserDatabase.userData) {
			// 如果数据库中有数据，那么看账户名是否匹配
			if (u != null) {
				// 如果账户名匹配，将正确的密码赋给nowPassword传回LoginService进行匹配判断
				if (u.getName().equals(name)) {
					nowPassword = u.getPassword();
				}
			}
		}
		return nowPassword;
	}
	public String loginDA(String name) {
		String account = null;
		// 与UserDatabase进行对比，看是否匹配
		for (UserTemplateDatabase u : UserDatabase.userData) {
			// 如果数据库中有数据，那么看账户名是否匹配
			if (u != null) {
				// 如果账户名匹配，将账户号返回
				if (u.getName().equals(name)) {
					 account = u.getAccountNumber();
				}
			}
		}
		return account;
	}

}
