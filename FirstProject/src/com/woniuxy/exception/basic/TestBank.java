package com.woniuxy.exception.basic;
/*
 * ����ȡ�������
 */
public class TestBank {
	public static void main(String[] args) throws NagativeFoundsException {
		Bank b = new Bank(100);
		b.withDraw(-1); 
		b.withDraw(150);
		
	}  

}
