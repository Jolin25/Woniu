package com.woniuxy.multithreading.basic;

public class MutiTest {
	public static void main(String[] args) {
		//1.�½�------�����߳������
		MultithreadingDemo multiD = new MultithreadingDemo();
		Thread multiDT = new Thread(multiD);
		//2.����-------�ɸ��̵߳Ķ������start()�������������߳�
		multiDT.start();//һ����ȡCPU����Դ���ͻ��Զ�ִ��run()����
	}
}
