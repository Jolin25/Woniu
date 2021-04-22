package com.woniuxy.multithreading.basic;

public class JoinTest {
	public static void main(String[] args) {
		JoinDemo j = new JoinDemo();
		Thread jt = new Thread(j);
		
		for (int i = 0; i < 20; i++) {
			if (i == 10) {
				try {
					System.out.println("join is coming!");
					jt.start();
					jt.join();//强行进去

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("main:" + i);
			}
		}
	}
}
