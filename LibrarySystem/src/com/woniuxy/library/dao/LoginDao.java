package com.woniuxy.library.dao;

import com.woniuxy.library.dao.po.User;
import com.woniuxy.library.database.Database;

/**
 * ��½���ݽ�����
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class LoginDao {
	public User loginD(String name) {
		User user = null;
		for(User u:Database.users) {
			if(name.equals(u.getName())) {//����ҵ��û���
				user = u;//���ظö���
			}
		}
		return user;
	}
}
