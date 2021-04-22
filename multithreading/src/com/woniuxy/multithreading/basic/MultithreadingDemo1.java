package com.woniuxy.multithreading.basic;

public class MultithreadingDemo1 implements Runnable {
	//设置名称方式二：构造方法
	String name;
	public MultithreadingDemo1(String name) {
		this.name = name;
	}
	//重写run方法
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程名称："+this.name+"    本身名称："+Thread.currentThread().getName());
			//System.out.println("B");
			//设置休眠
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
