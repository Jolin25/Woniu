package com.woniuxy.atm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.TransferDao;
import com.woniuxy.atm.database.UserDatabase;

public class TransferService {
	public boolean transfer(String nowUserName) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in );
		TransferDao transferD = new TransferDao();
		System.out.println("请输入要转入的账户名：");
		String targetName = sc.next();
	
		//如果要转入的账户名是自己，则退出
		if(targetName.equals(nowUserName)) {
			System.out.println("不能向自己转账！");
			return false;
		}
		System.out.println("请输入要转的金额：");
		int money = sc.nextInt();
		boolean transfer = transferD.transfer(nowUserName, targetName, money);
		if(transfer) {
			UserDatabase.nowChangeMoney = money;//赋目前登陆账户要转的金额
			new UserDatabase().upload();//跟新本地文件数据库
		}
		
		return transfer;
		
	}
}
