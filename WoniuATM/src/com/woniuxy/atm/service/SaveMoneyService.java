package com.woniuxy.atm.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.woniuxy.atm.dao.SaveMoneyDao;
import com.woniuxy.atm.database.UserDatabase;

/*
 * ȡǮ---�߼�
 */
public class SaveMoneyService {
	public boolean saveMoney(String name) throws FileNotFoundException, IOException {
		System.out.println("������Ҫ����Ľ��:");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		SaveMoneyDao saveD = new SaveMoneyDao();
		boolean save =saveD.saveMoney(name, money);
		if(save) {
			UserDatabase.nowChangeMoney = money;//��Ŀǰ��½�˻�����Ľ��
			new UserDatabase().upload();//���±����ļ����ݿ�
		}
		return save;
	}
}
