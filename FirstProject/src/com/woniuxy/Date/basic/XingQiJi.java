package com.woniuxy.Date.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * 	��������һ�������յõ����������ڼ���
 * 	��ø�������������������
 */
public class XingQiJi {
	public static void main(String[] args) throws ParseException {
		xingQi();
		dayToDay();
	}

	public static void xingQi() throws ParseException {
		System.out.println("������һ�����ڣ�");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Date date = sdf.parse(str);// ��String����ת��ΪDate����
		
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);// ʹ�ø�����Date�������ô�Calendar��ʱ��
		
		int i = ca.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(i);
		Date date1 = ca.getTime();//��Calendar��ת��ΪDate��
		String str1 = sdf.format(date1);//��Date��ת����String��
		System.out.println(date1);
		System.out.println(str1);

	}
	public static void dayToDay() throws ParseException {
		System.out.println("������һ�����ڣ�");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		System.out.println("��������һ�����ڣ�");
		String str2 = sc.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(str1);
		Date date2 = sdf.parse(str2);
		long time = date1.getTime()-date2.getTime();
		long day = time/1000/60/60/24;
		System.out.println(day);
		
		
	}
}
