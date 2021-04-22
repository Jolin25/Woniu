package com.woniuxy.library.service;

import java.util.Scanner;

import com.woniuxy.library.dao.LoginDao;
import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * 登陆逻辑部分
 * 
 * @author 小虫子的小日常
 *
 */
public class LoginService {
	public boolean loginS() {
		System.out.println("请输入用户名：");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("请输入密码：");
		String password = sc.next();
		//进入数据交互层，根据用户名查找对象
		LoginDao ld = new LoginDao();
		User user = ld.loginD(name);
		if(user!=null) {//如果返回不为空
			if(user.getPassword().equals(password)) {//对比密码
				Database.nowUser = user;//把当前用户赋值为该对象
				return true;
			}
		}else {//如果返回为默认的空
			System.out.println("用户名不存在");
		}
		return false;
	}
}
