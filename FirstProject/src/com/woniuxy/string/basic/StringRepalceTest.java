package com.woniuxy.string.basic;
/*
 * 3、	实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

 */
public class StringRepalceTest {
	public static void main(String[] args) {
		String str = "what nationality are you?";
		String str1 = str.replace(" ", "%20");
		System.out.println(str1);
	}
}
