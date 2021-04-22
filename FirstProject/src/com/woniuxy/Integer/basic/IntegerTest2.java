package com.woniuxy.Integer.basic;

import com.woniuxy.java.basic.Char;

/*
 * 声明两个字符串，其中的内容是两个整数，分别打印输出两个数之和与两个数之积；
 * Integer i1 = 127;i2 = 127; i3 = 128; 
 * i4 = 128;请分别打印并分析 i1==i2  i3==i4 的结果；
 */
public class IntegerTest2 {
	public static void main(String[] args) {
		String str = "100";
		String str1 = "25";
		int in = Integer.valueOf(str);
		int in1 = Integer.valueOf(str1);
		int sum = in + in1;
		int product = in*in1;
		System.out.println(sum + " "+product);
		
		Integer i1 = 127;
		Integer i2 = 127;
		Integer i3 = -128;
		Integer i4 = -128;
		System.out.println(i1 == i2);
		System.out.println(i3 == i4);
		
		
		double d1 = i1.doubleValue();
		System.out.println(d1);
		
		String str2 = "30";
		int i5 = Integer.valueOf(str2);
		System.out.println(i5);
		
		
		int i6 = 90;
		String str3 = Integer.toString(i6);
		System.out.println(str3);
		
		
		String str4 = "100";
		int i7 = Integer.parseInt(str4);
		System.out.println(i7);
		
		int l = Integer.MAX_VALUE;
		System.out.println(l);
		
		Character c = Character.valueOf('w');
		System.out.println(c);
		
		Boolean b = Boolean.valueOf(false);
		Byte by = Byte.valueOf( (byte) 2);
		Double dou = Double.valueOf(100);
		}
	
	
}
