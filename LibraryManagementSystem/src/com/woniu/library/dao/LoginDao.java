package com.woniu.library.dao;

import com.woniu.library.database.Database;

public class LoginDao {
//½»»¥Êý¾Ý¿â
	public User loginD(String userName) {
		for (User u : Database.users) {
			if (userName.equals(u.getUserName())) {
				return u;
			}
		}
		return null;
	}

}
