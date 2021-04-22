package com.woniuxy.multithreading.basic;

public class YieldDemo implements Runnable{

	@Override
	public void run() {
		int sum=0;
		long start = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			
			sum += i;
			
			if(i==1) {
				Thread.yield();//���Լ�����߳�����һ��ʱ�䣬�ͷ�CPU��Դ
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("runtime:"+(end-start)+"ms");
	}

}
