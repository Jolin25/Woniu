package com.woniuxy.basic.day04;

public class Cyclic {
	public static void main(String[] args) {
		/**
		 * for(int i = 0;i < 100 ;i++) { if(i>22) { continue; } System.out.println("抄" +
		 * (i+1));
		 * 
		 * 
		 * if(i>48) { break; } }
		 */

		/**
		 * int i = 1; while(i<=100) { i++; System.out.println("抄写代码第"+i+"次");
		 * //因为i已经加了1了，输出后才又进行了条件判断 }
		 */
		int i = 0;
		do {
			System.out.println("抄" + (i + 1));
			i++;
		} while (i < 10);

	}
}
