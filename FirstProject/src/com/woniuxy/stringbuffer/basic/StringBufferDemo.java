package com.woniuxy.stringbuffer.basic;

public class StringBufferDemo {
	public static void main(String[] args) {
		demo();
		stringBuffer();
		System.out.println("--------");
		 demo2();
	}
	public static void  demo() {
		String s1 = "abc";
		String s2 =s1; 
		s1 +="def";
		System.out.println(s2);
	}
	public static void stringBuffer() {
		//����StringBuffer���󣬲���ʼ��
		StringBuffer s1 = new StringBuffer("abc");
		StringBuffer s2 = s1;
		
		s1.append("def");
		System.out.println(s2);
	}
	public static void demo2() {
	StringBuffer s1 = new StringBuffer();
	s1.append("12sdf");
	s1.delete(0, 2);
	System.out.println(s1);
	/*
	 * ÿ���ַ�������������һ����������
	 * ֻҪ�ַ������������������ַ����еĳ���û�г�����������
	 * ����������µ��ڲ����������顣����ڲ��������������������Զ�����
	 */
	StringBuffer s2 = new StringBuffer(1);
	s2.append(false).append(s1);
	System.out.println(s2);
	
	
	StringBuffer s3 = new StringBuffer();
	s3.append(s1, 0, 3);
	char[] c = new char[3];
	s3.append(c);
	c[0] = 'a';
	c[1] = 'b';
	c[2] ='c';
	s3.append(c, 0,3);
	System.out.println(s3);
	
	}
	
	
}
