package com.woniuxy.regex.basic;
/*
 * QQ��ƥ��
 */
public class QQRegEx {
	public static void main(String[] args) {
		QQRegEx qqReg = new QQRegEx();//�����������
		boolean i = qqReg.isQQ("234567");//����ƥ�亯��
		System.out.println(i);
	}
	public boolean isQQ(String qq) {
		String regExQQ = "[1-9][0-9]{4,9}";//�������
		boolean i = qq.matches(regExQQ);//������ַ�������String�����matches�������������ƥ��
		return i;
	}
}
