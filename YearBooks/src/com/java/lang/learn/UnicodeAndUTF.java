package com.java.lang.learn;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class UnicodeAndUTF {
	public static void main(String[] args) throws UnsupportedEncodingException {
		UnicodeAndUTF uu = new UnicodeAndUTF();
		uu.two();
		
	}

	public void one() {
		char ch = '\u5639';
		Character.UnicodeBlock cu = Character.UnicodeBlock.of(ch);
		System.out.println(cu);
	}

	public void two() throws UnsupportedEncodingException {
		String str = "abc\u5639\u563b";
		byte[] utf8 = str.getBytes("UTF-8");// charset£º±àÂë
		System.out.println(Arrays.toString(utf8));

	}
}
