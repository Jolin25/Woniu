package com.woniuxy.multithreading.basic;

public class MutiTest {
	public static void main(String[] args) {
		//1.新建------创建线程类对象
		MultithreadingDemo multiD = new MultithreadingDemo();
		Thread multiDT = new Thread(multiD);
		//2.就绪-------由该线程的对象调用start()方法用来开启线程
		multiDT.start();//一旦获取CPU的资源，就会自动执行run()方法
	}
}
