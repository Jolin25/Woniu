package com.woniuxy.multithreading.basic;

//银行卡
public class Card {
	private int balance = 1000;
	int money;
	

	

	// 支付方法
	public  boolean pay(int money) {
		//将下面这部分资源放置在了同步块中，该同步块也称为临界区
		synchronized (this) {//this 代表调用该方法的那个对象的card对象
			if (balance >= money) {
				balance -= money;
				System.out.println("花费了" + money + "元，还剩下" + balance + "元");
				return true;
			} else {
				System.out.println("余额不足");
				return false;
			}
		}
		
	}
}
