package com.woniuxy.multithreading.basic;

public class MultithreadingDemo implements Runnable{
	//重写run方法
	@Override
	public void run() {
		//输出内容
		for(int i = 0;i<10;i++) {
			//获取线程名称方式一：Thread.currentThread().getName()
			System.out.println("线程名称："+Thread.currentThread().getName());
			//System.out.println(i);
			//设置休眠
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
