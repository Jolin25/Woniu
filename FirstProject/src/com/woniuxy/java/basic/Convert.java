package com.woniuxy.java.basic;

public class Convert {
	public static void main(String[]args) {
		System.out.println((int)(char)(byte)-1);
		
	}
}
//数据转换  char在遇到不是ascii里可以表示别人的数字时，
//会倒着找，于是输出char能表示的最大值