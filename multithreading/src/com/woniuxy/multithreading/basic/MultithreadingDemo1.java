package com.woniuxy.multithreading.basic;

public class MultithreadingDemo1 implements Runnable {
	//�������Ʒ�ʽ�������췽��
	String name;
	public MultithreadingDemo1(String name) {
		this.name = name;
	}
	//��дrun����
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�߳����ƣ�"+this.name+"    �������ƣ�"+Thread.currentThread().getName());
			//System.out.println("B");
			//��������
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
