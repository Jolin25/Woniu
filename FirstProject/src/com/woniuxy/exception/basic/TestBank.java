package com.woniuxy.exception.basic;
/*
 * 银行取款测试类
 */
public class TestBank {
	public static void main(String[] args) throws NagativeFoundsException {
		Bank b = new Bank(100);
		b.withDraw(-1); 
		b.withDraw(150);
		
	}  

}
