package com.woniuxy.basic.abstract1;
/*
 * 2、编写一个用于放置常量的Java接口Contsants，具有常量MAX和 MIN;
编写一个测试类ContstantsTest，在main方法中求取 Constants中的两个常量之差；

 */
public class ContstantsTest implements Constants {
	public static void main(String[] args) {
		System.out.println(MAX - MIN);
	}

//	@Override
//	public void subtract() {
//		System.out.println(MAX - MIN);
//		
//	}
}
