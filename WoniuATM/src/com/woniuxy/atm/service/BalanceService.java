package com.woniuxy.atm.service;

import com.woniuxy.atm.dao.BalanceDao;

/*
 * ��ѯ���-----ҵ���߼�
 */
public class BalanceService {
	public int getBalance(String name) {
		int balance = 0;
		BalanceDao balanceD = new BalanceDao();
	    balance = balanceD.getBalance(name);//����Dao����ȡ���
		return balance;
	}
}
