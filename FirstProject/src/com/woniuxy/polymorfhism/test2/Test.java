package com.woniuxy.polymorfhism.test2;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Host host = new Host();
		System.out.println("1��ι����2��ιè����ѡ��");
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();

		if (sel == 1) {
			host.feed(new Dog(), new Bone("��ͷ", "��"));
		} else {
			host.feed(new Cat(), new Fish("��", "С"));
		}
		sc.close();

	}
}
