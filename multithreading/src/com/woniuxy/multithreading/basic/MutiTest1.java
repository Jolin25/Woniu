package com.woniuxy.multithreading.basic;

public class MutiTest1 {
	public static void main(String[] args) {
		//�����̶߳���
		MultithreadingDemo m = new MultithreadingDemo();
		MultithreadingDemo1 m1 = new MultithreadingDemo1("�Ͳ�������");
		//��ʵ��Runnable�ӿڵ�����߳���Ķ����װ��Thread��----->ת��Thread����
		Thread tm = new Thread(m);
		Thread tm1 = new Thread(m1);
		tm.setPriority(10);
		//����
		tm.start();
		tm1.start();
	}
}
