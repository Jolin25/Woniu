package com.woniuxy.stringTokenizer.basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String str = "what nationality are you?";
		String str1 = "what ** nationality%%are\nyou";
		StringTokenizer st = new StringTokenizer(str);
		//StringTokenizer st1 = new StringTokenizer(str1,"*%",false);
		while (st.hasMoreElements()) {
		System.out.print(st.nextToken()+" ");
			System.out.print(st.countTokens()+" ");//用于输出还可以调用的次数
		//	System.out.println(st1.nextToken()+" ");
		}
	}

}
