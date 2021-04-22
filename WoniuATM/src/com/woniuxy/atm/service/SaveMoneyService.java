package com.woniuxy.atm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.SaveMoneyDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * 取钱---逻辑
 */
public class SaveMoneyService {
	public boolean saveMoney(String name) throws FileNotFoundException, IOException {
		System.out.println("请输入要存入的金额:");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		SaveMoneyDao saveD = new SaveMoneyDao();
		boolean save =saveD.saveMoney(name, money);
		if(save) {
			UserDatabase.nowChangeMoney = money;//赋目前登陆账户存入的金额
			new UserDatabase().upload();//跟新本地文件数据库
		}
		return save;
	}
}
