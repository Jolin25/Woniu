package com.woniuxy.basic.abstract1;
/*
 * 6������������ƽӿڣ����ʵ���ࣺ
    1�����б�׼������Ǯ��ȡǮ��
    2����������ִ�����б�׼��
    3��������׼�����š����ţ�
    4���й�����ִ�����б�׼��������׼��
 */
public class ICBC implements Bank,Building {
	double balance = 1000;//���
	double increment;//������
	double decrement;//������
	//������
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
	
	//������
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
