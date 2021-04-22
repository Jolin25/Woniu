package com.woniuxy.Date.basic;
import java.util.Date;
public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();// 目前的系统日期
		System.out.println("目前的系统日期：" + date);
		Date date2 = new Date(123455555);// 从1970年1月一日起，经过了123455555毫秒后的日期
		System.out.println(date2);
		boolean i = date.after(date2);// date是否在date2的日期之后
		System.out.println(i);
		long j = date.getTime();
		System.out.println("毫秒数：" + j);// 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
		date.setTime(1000);
		System.out.println(date);// 因为是东八区，所以是比格林时间快8小时的
	}
}
