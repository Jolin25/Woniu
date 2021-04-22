package com.woniuxy.basic.day04;

public class DataType {
	public static void main(String[]args) {
		long micro = 24 *24 * 60 *1000 * 1000L;
		long millis = 24 * 24 * 60 * 1000L;//不加L的话，默认为int，溢出
		System.out.println(micro/millis);
		}
	}