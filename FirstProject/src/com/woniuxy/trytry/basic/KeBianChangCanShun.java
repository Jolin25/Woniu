package com.woniuxy.trytry.basic;

public class KeBianChangCanShun {
	public void k(int...a) {
		a[0] = 1;
		a[1]= 2;
		//可变长参数，实际上是当做了以为数组处理
		fs();
	}
	public void fs() {
		System.out.println("非静态方法");
	}
	public static void s() {
		System.out.println("静态方法");
		
	}
	public static void main(String[] args) {
		s();
		KeBianChangCanShun ke = new KeBianChangCanShun();
		KeBianChangCanShun.s();
		ke.s();
		
	}
	
}
