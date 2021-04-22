package com.woniuxy.Date.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) throws ParseException {
		//useDate();
		useCalendar();
	}
	// 对Date的使用
	public static void useDate() throws ParseException {
		// 计算目前系统时间距离19700101有多少天
		Date date1 = new Date();
		long date2 = date1.getTime();
		long day1 = date2 / 1000 / 60 / 60 / 24;
		System.out.println(day1 + "天");
		// 把字符串date3按照sdf声明时的格式解析后，转成日期类输出
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date3 = "2014-09-09";
		Date date4 = sdf.parse(date3);//String类转为Date类
		System.out.println(date4);
		System.out.println(date4.after(date1));// 判断date4是否在系统时间之后
		System.out.println(date4.before(date1));// 判断date4是否在系统时间之前
	}
	//Calendar的使用
	public static void useCalendar() {
//		Calendar ca = Calendar.getInstance();
//		ca.add(Calendar.DAY_OF_WEEK, 2);//系统目前的星期几加2
//		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK)-1;//获取上一步得到的星期数
//		System.out.println(dayOfWeek);
//		
//		Calendar ca2 = Calendar.getInstance();
//		Date date1 = ca2.getTime();//通过Calendar对象来获取时间
//		System.out.println(date1);
		
		Calendar ca3 = Calendar.getInstance();
		ca3.set(Calendar.DATE, 1);
		System.out.println(ca3.get(Calendar.DATE));
		
	}	
}
