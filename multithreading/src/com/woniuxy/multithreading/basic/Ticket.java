package com.woniuxy.multithreading.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//火车票
public class Ticket {

	int ticketNumber = 30;//票剩余多少张
	Lock lock = new ReentrantLock();//创建重入锁
	public boolean buy(int number) {
		//synchronized (this) {
			lock.lock();//上锁
			if(ticketNumber>0) {
				ticketNumber--;
				System.out.println(Thread.currentThread().getName()+"购买了"+number+"张票，还剩余"+ticketNumber+"张");
				lock.unlock();//解锁
				return true;
			}else {
				System.out.println("余票不足");
				lock.unlock();//解锁
				return false;
			}
	//	}
		
		
		
	}
	
}
