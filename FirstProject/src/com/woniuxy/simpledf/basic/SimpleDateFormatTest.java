package com.woniuxy.simpledf.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * 使用日期格式来现实日历
 */

public class SimpleDateFormatTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E ");
		//System.out.println(sdf.format(new Date()));
		
		/*
		 * 字符串与日期之间的转换
		 */
//		//把字符串类转成日期类
//		String str = "2019-04-24";//必须用SimpleDateFormat声明的格式写
//		Date date = sdf.parse(str);
//		System.out.println(date);
//		//把日期类转换成字符串类
//		String str1 = sdf.format(date);
//		System.out.println(str1);
//		
		
		/*
		 * 1、计算你来到这个世界多少天；
		 */
//		System.out.println("请输入你的生日：");
//		Scanner sc = new Scanner(System.in);
//		String birthday = sc.next();
//		Date birthdayD = sdf.parse(birthday);//转化为Date
//		long myDate = birthdayD.getTime();//自19700101到birthdayD的毫秒数
//		long nowDate = new Date().getTime();//自19700101到现在的毫秒数
//		long day = (nowDate - myDate)/1000/60/60/24;//多少天
//		System.out.println(day);
		/*
		 * 2、使用日期类计算当前日期的前50天是哪一天,是星期几
		 */
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -50);//往前移动50天
		Date date1 = cal.getTime();
		String str2 = sdf.format(date1);
		System.out.println(str2);
		System.out.println();
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH)+1;//因为默认从0开始算一月
//		int datec = cal.get(Calendar.DATE);
//		int hour = cal.get(Calendar.HOUR);
//		int minute = cal.get(Calendar.MINUTE);
//		int second = cal.get(Calendar.SECOND);
//		int d = cal.get(Calendar.DAY_OF_WEEK)-1;
	//	System.out.println(year+"年"+month+"月"+datec+"日"+hour+"时"+minute+"分"+second+"秒");
	//	System.out.println("是星期"+d);
		
		
	}
}
