package com.woniuxy.java.basic;

public class Text040902 {
	public static void main(String[] args) {
		byte a = 1;
		a += 1;/* += ， 如果 左边的变量是比右边计算后类型还小的数据类型，
					那么+=这些算数运算实际上系统默认的做了一个隐式的强制类型的转换；*/
		System.out.println(a);
		a = 1;
		a = (byte) (a + 1);
		System.out.println(a);
	}
}
