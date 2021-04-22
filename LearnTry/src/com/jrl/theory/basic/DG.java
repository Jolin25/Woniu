package com.jrl.theory.basic;
/*
 * µİ¹é£ºÇó6µÄµİ¹é
 */
public class DG {
	public static int sum(int i) {
		if(i>1) {
			return i*sum(i-1);
		}else {
			return i;
		}
	}
	public static void main(String[] args) {
		System.out.println(sum(6));
	}
}
