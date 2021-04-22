package com.woniuxy.exception.basic;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println(Exception1(1, 2));
		System.out.println("========");
		System.out.println(Exception1(1, 0));

	}

	public static int Exception1(int i, int j) {
		try {
			System.out.println("tryÓï¾ä¿é");
			i = i / j;

			return 1;
		} catch (Exception e) {
			System.out.println("catchÓï¾ä¿é");
			// return 2;
		} finally {
			System.out.println("finallyÓï¾ä¿é");
			return 3;
		}

	}

	public static void Exception2() {

	}
}
