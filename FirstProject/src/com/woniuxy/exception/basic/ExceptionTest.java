package com.woniuxy.exception.basic;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println(Exception1(1, 2));
		System.out.println("========");
		System.out.println(Exception1(1, 0));

	}

	public static int Exception1(int i, int j) {
		try {
			System.out.println("try����");
			i = i / j;

			return 1;
		} catch (Exception e) {
			System.out.println("catch����");
			// return 2;
		} finally {
			System.out.println("finally����");
			return 3;
		}

	}

	public static void Exception2() {

	}
}
