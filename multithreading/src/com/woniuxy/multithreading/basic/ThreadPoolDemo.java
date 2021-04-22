package com.woniuxy.multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		JoinDemo j = new JoinDemo();
		YieldDemo y = new YieldDemo();// 创建Runnable实现类的实例
		ExecutorService executor = Executors.newFixedThreadPool(10);// 创建固定数目线程的线程池
		//创建Runnable对象
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "    i的值：" + i);
			}
		};
		
			executor.submit(target);//向线程池中提交一个线程
			//executor.execute(j);//把一个Runnable对象交给了线程池，线程池则会尽快执行该对象对应的任务
			//executor.execute(y);
		
		executor.shutdown();// 线程池不再接受新的任务，但会将以前所有已提交的任务执行完成
	}
}
