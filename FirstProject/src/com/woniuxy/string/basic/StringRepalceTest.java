package com.woniuxy.string.basic;
/*
 * 3��	ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��

 */
public class StringRepalceTest {
	public static void main(String[] args) {
		String str = "what nationality are you?";
		String str1 = str.replace(" ", "%20");
		System.out.println(str1);
	}
}
