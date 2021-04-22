package com.woniuxy.basic.abstract1;
/*
 * 6、根据如下设计接口，设计实现类：
    1）银行标准（余额，存钱，取钱）
    2）工商银行执行银行标准；
    3）建筑标准（开门、关门）
    4）中国银行执行银行标准、建筑标准；
 */
public class ICBC implements Bank,Building {
	double balance = 1000;//余额
	double increment;//增加量
	double decrement;//减少量
	//构造器
//	public ICBC(double balance,double increment,double decrement) {
//		this.banlance = balance;
//		this.increment = increment;
//		this.decrement =decrement;
//	}
	
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		System.out.println(balance);
		return balance;
	}
	@Override
	public double saveMoney( double increment) {
		// TODO Auto-generated method stub
		balance += increment;
		System.out.println(balance);
		return balance;
	}
	@Override
	public double drawMoney( double decrement) {
		// TODO Auto-generated method stub
		balance -= decrement;
		System.out.println(balance);
		return balance;
	}
//
	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("close the door");
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("open the door");
	}
	
	//主方法
	public static void main(String[] args) {
		ICBC i = new ICBC();
		i.getBalance();
		i.drawMoney(10);
		i.saveMoney(100);
		//
		i.open();
		i.close();
	}
	
}
