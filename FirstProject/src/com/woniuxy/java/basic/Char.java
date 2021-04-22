//ÊäÈë×Ö·ûchar
package com.woniuxy.java.basic;

import java.util.Scanner;

public class Char {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		char c1;
		c1 = sc.next().charAt(0);
		
		System.out.println(c1);
		sc.close();
	}
}
