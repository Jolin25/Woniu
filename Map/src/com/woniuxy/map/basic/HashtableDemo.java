package com.woniuxy.map.basic;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 * 编写一个程序，创建一个 Hashtable对象，
 * 用于存储银行储户的 信息(其中储户的主要信息有储户的ID，姓名和余额)。
 * 另外，计算并显示其中某个储户的当前余额。
 */
public class HashtableDemo {
	public static void main(String[] args) {
		Hashtable<Integer, String[]> ht = new Hashtable<Integer, String[]>();
		String[] one = new String[3];
		one[0] = "001";
		one[1] = "张一";
		one[2] = "1000";
		ht.put(0, one);
		one = new String[3];
		one[0] = "002";
		one[1] = "张二";
		one[2] = "2000";
		ht.put(1, one);
		one = new String[3];
		one[0] = "003";
		one[1] = "张三";
		one[2] = "3000";
		ht.put(2, one);
		Set<Integer> set = ht.keySet();// 取出所有元素
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要查找的银行账户：");
		String str = sc.next();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			
		}
	}
}
