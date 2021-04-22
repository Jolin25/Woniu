package com.woniuxy.multithreading.basic;

public class YieldDemo implements Runnable{

	@Override
	public void run() {
		int sum=0;
		long start = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			
			sum += i;
			
			if(i==1) {
				Thread.yield();//把自己这个线程礼让一段时间，释放CPU资源
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("runtime:"+(end-start)+"ms");
	}

}
