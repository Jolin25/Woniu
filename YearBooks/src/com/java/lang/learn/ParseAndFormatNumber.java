package com.java.lang.learn;

public class ParseAndFormatNumber {
	public static void main(String[] args) {
		new ParseAndFormatNumber().t();
	}
	public void t() {
		int i = 1023;
		i = Integer.parseInt("1111111111",2);//���ַ������ն����ƽ���
		System.out.println(i);//1023
		String s = Integer.toString(i, 2);//�����ְ��ն�����תΪString
		System.out.println(s);//1111111111
		i = Integer.parseInt("1023");//���ַ�������ʮ���ƽ���
		s = Integer.toString(i);//1023
		System.out.println(s);//�����ְ���ʮ����תΪ�ַ���
		System.out.println(Character.MAX_RADIX);//36
		int radix = 36;
		i = Integer.parseInt("vv", radix);
		s = Integer.toString(i, radix);
		System.out.println(i);
		System.out.println(s);
	}
}
