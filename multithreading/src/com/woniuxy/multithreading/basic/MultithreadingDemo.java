package com.woniuxy.multithreading.basic;

public class MultithreadingDemo implements Runnable{
	//��дrun����
	@Override
	public void run() {
		//�������
		for(int i = 0;i<10;i++) {
			//��ȡ�߳����Ʒ�ʽһ��Thread.currentThread().getName()
			System.out.println("�߳����ƣ�"+Thread.currentThread().getName());
			//System.out.println(i);
			//��������
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
