package com.woniuxy.basic.day04;

public class For3 {
	public static void main(String[]args) {
		for(int i = 0;i<10;i++) {
			if(i==2) {
				continue;
			}else {
				System.out.print(i+1 + " ");
			}
		}
		System.out.println();
		for(int i=0;i<4;i++) {
			System.out.print("*");
		}
		
		System.out.println();
		for(int i = 0;i<2;i++) {			
			for(int j=0;j<4;j++) {
				System.out.print("*");
			}
			System.out.println();
			}
		}
	}

