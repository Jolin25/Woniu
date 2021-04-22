//第六题：电话号
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextCall {
	public static void main(String[]args) {
		//输入电话快捷号
		System.out.println("请输入要拨打的快捷号：");
		Scanner sc = new Scanner(System.in);
		int call = sc.nextInt();
		//判断输入的数据与谁匹配
		switch(call) {
		case 1:
			System.out.println("拨打爸爸的号");
			break;
		case 2:
			System.out.println("拨打妈妈的号");
			break;
		case 3:
			System.out.println("拨打爷爷的号");
			break;
		case 4:
			System.out.println("拨打奶奶的号");
			break;
			default:
				System.out.println("输入错误");
				break;
		}
		sc.close();
		}
}
