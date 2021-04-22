package com.woniuxy.multithreading.basic;

public class InterruptTest {
	public static void main(String[] args) {
		InterruptDemo id = new InterruptDemo();
		 Thread t= new Thread(id);
		 t.start();
		 try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 t.interrupt();//中断，就是暂停一下下，给别人抢的机会
		 System.out.println("interrupted in main");
//		 try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		 while(true) {
//			 System.out.println("main");
//		 }
	}
}
