package com.woniuxy.atm.service;

import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.SignupDao;

/*
 * 注册账户----业务逻辑
 */
public class SignUpService {
	/*
	 * 注册账户
	 */
	public boolean signUp() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入新的用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		SignupDao signD = new SignupDao();
		boolean i =signD.signup(name, password);//进入signupdao部分
		//注册成功返回true，失败返回false
		return i;
		
	}
	
}
