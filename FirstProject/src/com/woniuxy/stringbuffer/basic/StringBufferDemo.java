package com.woniuxy.stringbuffer.basic;

public class StringBufferDemo {
	public static void main(String[] args) {
		demo();
		stringBuffer();
		System.out.println("--------");
		 demo2();
	}
	public static void  demo() {
		String s1 = "abc";
		String s2 =s1; 
		s1 +="def";
		System.out.println(s2);
	}
	public static void stringBuffer() {
		//创建StringBuffer对象，并初始化
		StringBuffer s1 = new StringBuffer("abc");
		StringBuffer s2 = s1;
		
		s1.append("def");
		System.out.println(s2);
	}
	public static void demo2() {
	StringBuffer s1 = new StringBuffer();
	s1.append("12sdf");
	s1.delete(0, 2);
	System.out.println(s1);
	/*
	 * 每个字符串缓冲区都有一定的容量。
	 * 只要字符串缓冲区所包含的字符序列的长度没有超出此容量，
	 * 就无需分配新的内部缓冲区数组。如果内部缓冲区溢出，则此容量自动增大。
	 */
	StringBuffer s2 = new StringBuffer(1);
	s2.append(false).append(s1);
	System.out.println(s2);
	
	
	StringBuffer s3 = new StringBuffer();
	s3.append(s1, 0, 3);
	char[] c = new char[3];
	s3.append(c);
	c[0] = 'a';
	c[1] = 'b';
	c[2] ='c';
	s3.append(c, 0,3);
	System.out.println(s3);
	
	}
	
	
}
