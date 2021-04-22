package com.woniuxy.java.basic;

public class Learn040903 {
	public static void main(String[]args) {
		int i = 0;
		int a = i;
		System.out.println("a的值："+a);
		a = a + 2;
		System.out.println("a的值："+a);
		a = 0;
		a+=2;
		System.out.println("a的值："+a);
		int a1=1;
		int b1=2;
		int c1=a1;
		 a1=b1;
		 b1=c1;
		 long lon = 1L;
		 short s = 1;
		 byte b = 1;
		 double d = 0.365D;
		 float f = 0.12F;
		 char c = 'a';
		 boolean boo = true;
		 lon = i;
		 long ong = 1;
		 d = f;
		 double d2= 0.37F;
		 System.out.println(lon);
		 System.out.println(ong);
		 i = (int)lon;
		 f =(float)d;
		 System.out.println(d);
		 System.out.println(f);
	}
}
