package com.woniuxy.multithreading.basic;

public class YieldTest {
	public static void main(String[] args) {
		YieldDemo y = new YieldDemo();
		Thread yt = new Thread(y);
		yt.setDaemon(true);//设置为守护线程
		boolean isDaemon = yt.isDaemon();
		System.out.println(isDaemon);
		yt.start();
		for(int i=0;i<1000000000;i++);
		for(int i=0;i<1000000000;i++);
		for(int i=0;i<1000000000;i++);
		for(int i=0;i<1000000000;i++);
	}

}
