package com.woniuxy.regex.basic;
/*
 * QQ号匹配
 */
public class QQRegEx {
	public static void main(String[] args) {
		QQRegEx qqReg = new QQRegEx();//创建本类对象
		boolean i = qqReg.isQQ("234567");//调用匹配函数
		System.out.println(i);
	}
	public boolean isQQ(String qq) {
		String regExQQ = "[1-9][0-9]{4,9}";//定义规则
		boolean i = qq.matches(regExQQ);//传入的字符串调用String类里的matches方法，与规则相匹配
		return i;
	}
}
