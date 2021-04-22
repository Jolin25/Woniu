package com.woniuxy.multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		JoinDemo j = new JoinDemo();
		YieldDemo y = new YieldDemo();// ����Runnableʵ�����ʵ��
		ExecutorService executor = Executors.newFixedThreadPool(10);// �����̶���Ŀ�̵߳��̳߳�
		//����Runnable����
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "    i��ֵ��" + i);
			}
		};
		
			executor.submit(target);//���̳߳����ύһ���߳�
			//executor.execute(j);//��һ��Runnable���󽻸����̳߳أ��̳߳���ᾡ��ִ�иö����Ӧ������
			//executor.execute(y);
		
		executor.shutdown();// �̳߳ز��ٽ����µ����񣬵��Ὣ��ǰ�������ύ������ִ�����
	}
}
