package com.woniuxy.multithreading.basic;

public class Bf implements Runnable{
	private Card card ;
	private int money;
	public Bf(Card card,int money) {
		this.card = card;
		this.money = money;
	}
	@Override
	public void run() {
		
			while(true) {
				boolean p = card.pay(money);
				if(!p) {
					break;//如果余额不足，则退出
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
		
	}
}
