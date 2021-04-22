package com.woniuxy.polymorfhism.test1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Host host = new Host();
		System.out.println("1°¢Œππ∑£¨2°¢Œπ√®£¨«Î—°‘Ò£∫");
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		if(sel == 1) {
			host.feed(new Dog());
		}else {
			host.feed(new Cat());
		}
		sc.close();
		
		
	}
}
