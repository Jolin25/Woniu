package com.woniuxy.simpledf.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * ʹ�����ڸ�ʽ����ʵ����
 */

public class SimpleDateFormatTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E ");
		//System.out.println(sdf.format(new Date()));
		
		/*
		 * �ַ���������֮���ת��
		 */
//		//���ַ�����ת��������
//		String str = "2019-04-24";//������SimpleDateFormat�����ĸ�ʽд
//		Date date = sdf.parse(str);
//		System.out.println(date);
//		//��������ת�����ַ�����
//		String str1 = sdf.format(date);
//		System.out.println(str1);
//		
		
		/*
		 * 1�����������������������죻
		 */
//		System.out.println("������������գ�");
//		Scanner sc = new Scanner(System.in);
//		String birthday = sc.next();
//		Date birthdayD = sdf.parse(birthday);//ת��ΪDate
//		long myDate = birthdayD.getTime();//��19700101��birthdayD�ĺ�����
//		long nowDate = new Date().getTime();//��19700101�����ڵĺ�����
//		long day = (nowDate - myDate)/1000/60/60/24;//������
//		System.out.println(day);
		/*
		 * 2��ʹ����������㵱ǰ���ڵ�ǰ50������һ��,�����ڼ�
		 */
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -50);//��ǰ�ƶ�50��
		Date date1 = cal.getTime();
		String str2 = sdf.format(date1);
		System.out.println(str2);
		System.out.println();
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH)+1;//��ΪĬ�ϴ�0��ʼ��һ��
//		int datec = cal.get(Calendar.DATE);
//		int hour = cal.get(Calendar.HOUR);
//		int minute = cal.get(Calendar.MINUTE);
//		int second = cal.get(Calendar.SECOND);
//		int d = cal.get(Calendar.DAY_OF_WEEK)-1;
	//	System.out.println(year+"��"+month+"��"+datec+"��"+hour+"ʱ"+minute+"��"+second+"��");
	//	System.out.println("������"+d);
		
		
	}
}
