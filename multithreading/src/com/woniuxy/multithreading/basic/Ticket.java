package com.woniuxy.multithreading.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//��Ʊ
public class Ticket {

	int ticketNumber = 30;//Ʊʣ�������
	Lock lock = new ReentrantLock();//����������
	public boolean buy(int number) {
		//synchronized (this) {
			lock.lock();//����
			if(ticketNumber>0) {
				ticketNumber--;
				System.out.println(Thread.currentThread().getName()+"������"+number+"��Ʊ����ʣ��"+ticketNumber+"��");
				lock.unlock();//����
				return true;
			}else {
				System.out.println("��Ʊ����");
				lock.unlock();//����
				return false;
			}
	//	}
		
		
		
	}
	
}
