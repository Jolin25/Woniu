package com.woniuxy.library.dao;

import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * 登陆数据交互层
 * 
 * @author 小虫子的小日常
 *
 */
public class LoginDao {
	public User loginD(String name) {
		User user = null;
		for(User u:Database.users) {
			if(name.equals(u.getName())) {//如果找到用户名
				user = u;//返回该对象
			}
		}
		return user;
	}
}
