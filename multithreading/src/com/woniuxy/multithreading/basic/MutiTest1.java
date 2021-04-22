package com.woniuxy.multithreading.basic;

public class MutiTest1 {
	public static void main(String[] args) {
		//创建线程对象
		MultithreadingDemo m = new MultithreadingDemo();
		MultithreadingDemo1 m1 = new MultithreadingDemo1("就不告诉你");
		//把实现Runnable接口的这个线程类的对象包装到Thread中----->转成Thread对象
		Thread tm = new Thread(m);
		Thread tm1 = new Thread(m1);
		tm.setPriority(10);
		//就绪
		tm.start();
		tm1.start();
	}
}
