package com.woniuxy.basic.day04;

public class NineNineMutiple {
	public static void main(String[]args) {
		for(int i =1;i<=9;i++) {
			for(int j =1;j<=i;j++) {
				System.out.print(i+"*"+j+ "="+i*j  + "  ");
			}
			System.out.println();
		}
	}
}