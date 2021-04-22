package com.woniu.library.service;

import java.util.Scanner;

import com.woniu.library.dao.LoginDao;
import com.woniu.library.dao.User;
import com.woniu.library.database.Database;

//登陆逻辑
public class LoginService {

	public Boolean loginS() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String userName = sc.next();
		System.out.println("请输入密码：");
		String userPass = sc.next();
		LoginDao l = new LoginDao();
		User u  = l.loginD(userName);
		if (userPass.equals(u.getUserPass())) {
			Database.nowUser = u;//修改数据库中的当前登录对象
			return true;
		}
		return false;

	}

}
