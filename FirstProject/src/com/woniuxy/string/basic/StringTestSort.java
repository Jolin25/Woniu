package com.woniuxy.string.basic;

import java.util.Scanner;

/*
 * 2、	接受用户输入的若干个字符串，并按字典次序排列输出这些字符串；

 */
public class StringTestSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[5];
		for(int i = 0;i<str.length;i++) {
			System.out.println("请输入字符串：");
			str[i] = sc.next();
		}
		for(int i = 0;i<str.length-1;i++) {
			for(int j = 0;j<str.length -1-i;j++) {
				if(str[j].compareTo(str[j+1])>0) {
					String t = str[j];
					str[j]=str[j+1];
					str[j+1]=t;
				}
			}
		}
		for(String i:str) {
			System.out.print(i+" ");
		}
			
			
		
	}
}
