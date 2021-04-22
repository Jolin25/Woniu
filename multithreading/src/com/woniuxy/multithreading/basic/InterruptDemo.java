package com.woniuxy.multithreading.basic;

public class InterruptDemo implements Runnable {

	@Override
	public void run() {
		while(true) {
			
			if(Thread.interrupted()) {
				System.out.println("Thread has been interrupted");
				/*Thread.interrupted只有判断作用，返回一个布尔值。
				中断（Thread.interrupt）并不能让该线程彻底的结束或者停止，
				因为线程的结束或停止是取决于在其就绪状态抢到CPU资源，
				如果一个线程被中断后，则会进入就绪状态，
				但是若该线程抢到了CPU资源，则会重新运行
				所以需要人为设置判断后的结束语句
				*/
				return;
			}else {
				System.out.println("keep on...");
			}
		}
	}

}
