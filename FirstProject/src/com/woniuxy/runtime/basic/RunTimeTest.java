package com.woniuxy.runtime.basic;

public class RunTimeTest {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.maxMemory());
		System.out.println(rt.freeMemory());
		rt.gc();
		System.out.println(rt.freeMemory());
		System.out.println(rt.freeMemory());
		System.out.println(rt.freeMemory());
	}
	
}
