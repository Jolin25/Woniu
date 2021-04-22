package com.woniuxy.multithreading.basic;

public class World {
	public static void main(String[] args) {
		
		Card card = new Card();
		Me me = new Me(card,300);
		Bf bf = new Bf(card,100);
		new Thread(bf).start();
		new Thread(me).start();
	
		
	}
}
