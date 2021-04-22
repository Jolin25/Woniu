package com.woniuxy.java.basic;

public class Text040904 {
	public static void main(String[] args) {
		long a = 24 * 24 * 60 * 1000 * 1000L;/*记住加L，否则会先默认为int型，值会溢出。
												之后才会自动转化为long*/
		System.out.println(a);/*可以直接写
								System.out.println( 24L * 24 * 60 * 1000 * 1000);*/
	}
}
