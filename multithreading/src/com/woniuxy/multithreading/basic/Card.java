package com.woniuxy.multithreading.basic;

//���п�
public class Card {
	private int balance = 1000;
	int money;
	

	

	// ֧������
	public  boolean pay(int money) {
		//�������ⲿ����Դ��������ͬ�����У���ͬ����Ҳ��Ϊ�ٽ���
		synchronized (this) {//this ������ø÷������Ǹ������card����
			if (balance >= money) {
				balance -= money;
				System.out.println("������" + money + "Ԫ����ʣ��" + balance + "Ԫ");
				return true;
			} else {
				System.out.println("����");
				return false;
			}
		}
		
	}
}
