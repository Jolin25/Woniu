package com.woniuxy.atm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import com.woniuxy.atm.dao.DrawMoneyDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * ȡǮ----�߼�
 */
public class DrawMoneyService {
	public boolean drawMoney(String name) throws IOException {
		System.out.println("������Ҫȡ�Ľ�");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		DrawMoneyDao drawD = new DrawMoneyDao();
		boolean draw = drawD.drawMoney(name, money);
		if(draw) {
			UserDatabase.nowChangeMoney = money;//����ǰ��½�˻�ȡ����Ǯ
			new UserDatabase().upload();//���±����ļ����ݿ�
		}
		
		
		return draw;
	}

}
