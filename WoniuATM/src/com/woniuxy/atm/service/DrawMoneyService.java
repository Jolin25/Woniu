package com.woniuxy.atm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import com.woniuxy.atm.dao.DrawMoneyDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * 取钱----逻辑
 */
public class DrawMoneyService {
	public boolean drawMoney(String name) throws IOException {
		System.out.println("请输入要取的金额：");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		DrawMoneyDao drawD = new DrawMoneyDao();
		boolean draw = drawD.drawMoney(name, money);
		if(draw) {
			UserDatabase.nowChangeMoney = money;//赋当前登陆账户取出的钱
			new UserDatabase().upload();//跟新本地文件数据库
		}
		
		
		return draw;
	}

}
