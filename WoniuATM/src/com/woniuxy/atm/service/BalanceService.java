package com.woniuxy.atm.service;

import com.woniuxy.atm.dao.BalanceDao;

/*
 * 查询余额-----业务逻辑
 */
public class BalanceService {
	public int getBalance(String name) {
		int balance = 0;
		BalanceDao balanceD = new BalanceDao();
	    balance = balanceD.getBalance(name);//进入Dao，获取余额
		return balance;
	}
}
