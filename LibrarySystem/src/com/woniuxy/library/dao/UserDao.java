package com.woniuxy.library.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * 处理与用户有关的数据交互
 * @author 小虫子的小日常
 *
 */
public class UserDao {
/*
 * 新增用户
 */
	public boolean addUserD(String name,String password) throws FileNotFoundException, IOException {
		for(int i =0;i<Database.users.size();i++) {
			User u =  Database.users.get(i);
			if(u.getName().equals(name)) {
				System.out.println("用户名已存在");
				return false;
			}
		}
		User user = new User(name, password, 1);
		Database.users.add(user);//添加至集合
		//跟新用户信息
		Database.updateUserTxt();
		return true;
	}
}
