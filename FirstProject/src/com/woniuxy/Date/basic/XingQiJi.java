package com.woniuxy.Date.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * 	给出任意一个年月日得到该天是星期几；
 * 	获得给定两个日期相差的天数
 */
public class XingQiJi {
	public static void main(String[] args) throws ParseException {
		xingQi();
		dayToDay();
	}

	public static void xingQi() throws ParseException {
		System.out.println("请输入一个日期：");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Date date = sdf.parse(str);// 把String类型转换为Date类型
		
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);// 使用给定的Date对象设置此Calendar的时间
		
		int i = ca.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(i);
		Date date1 = ca.getTime();//把Calendar类转换为Date类
		String str1 = sdf.format(date1);//把Date类转换成String类
		System.out.println(date1);
		System.out.println(str1);

	}
	public static void dayToDay() throws ParseException {
		System.out.println("请输入一个日期：");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		System.out.println("请再输入一个日期：");
		String str2 = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(str1);
		Date date2 = sdf.parse(str2);
		long time = date1.getTime()-date2.getTime();
		long day = time/1000/60/60/24;
		System.out.println(day);
		
		
	}
}
