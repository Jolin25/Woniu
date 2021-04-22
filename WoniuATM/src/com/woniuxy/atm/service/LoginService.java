package com.woniuxy.atm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.LoginDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * 登陆------业务逻辑
 */
public class LoginService {
	public boolean LoginS() throws FileNotFoundException, IOException  {
		// 输入用户名密码
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		// 进入dao ，判断用户名是否存在于数据库中，是否与密码匹配
		LoginDao log = new LoginDao();
		UserDatabase.nowUserAccount =log.loginDA(name);//把账户号放入nowUserAccount中
		String i = log.loginDP(name);// 将传回的对应密码放在i中
		if (i != null) {
			if (i.equals(password)) {
				System.out.println("登陆成功！");
				UserDatabase.nowUserName = name;//赋目前登陆用户名
				UserDatabase.nowBalance = new BalanceService().getBalance(UserDatabase.nowUserName);
				UserDatabase.nowPass = password;
				UserDatabase.saveNowUser();//保存当前登录用户到本地文件中
				
				return true;
			} else {
			//	System.out.println("密码输入错误");
				try {
					throw new LoginException("密码输入错误");
				} catch (LoginException e) {
			
					System.out.println(e.getMessage());
				}
				return false;
			}
		}else {
		//	System.out.println("用户名输入错误");
			
			try {
				throw new LoginException("用户名输入错误");
			} catch (LoginException e) {
				
				System.out.println(e.getMessage());
				
			}
			return false;
		}
		
	}
}
