package com.woniuxy.library.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.library.dao.UserDao;

/**
 * 处理与用户有关的逻辑业务
 * 
 * @author 小虫子的小日常
 *
 */
public class UserService {
	/*
	 * 新增用户
	 */
	public void addUserS() throws FileNotFoundException, IOException {
		System.out.println("请输入用户名：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("请输入用户密码：");
		String password = sc.next();
		UserDao ud = new UserDao();
		boolean addUserD = ud.addUserD(name, password);
		if(addUserD) {
			System.out.println("添加成功");
			
		}else {
			System.out.println("添加失败");
		}
		
		
		
	}
}
