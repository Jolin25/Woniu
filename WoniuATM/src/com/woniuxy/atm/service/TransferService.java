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
		System.out.println("������Ҫת����˻�����");
		String targetName = sc.next();
	
		//���Ҫת����˻������Լ������˳�
		if(targetName.equals(nowUserName)) {
			System.out.println("�������Լ�ת�ˣ�");
			return false;
		}
		System.out.println("������Ҫת�Ľ�");
		int money = sc.nextInt();
		boolean transfer = transferD.transfer(nowUserName, targetName, money);
		if(transfer) {
			UserDatabase.nowChangeMoney = money;//��Ŀǰ��½�˻�Ҫת�Ľ��
			new UserDatabase().upload();//���±����ļ����ݿ�
		}
		
		return transfer;
		
	}
}
