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
	// ��Date��ʹ��
	public static void useDate() throws ParseException {
		// ����Ŀǰϵͳʱ�����19700101�ж�����
		Date date1 = new Date();
		long date2 = date1.getTime();
		long day1 = date2 / 1000 / 60 / 60 / 24;
		System.out.println(day1 + "��");
		// ���ַ���date3����sdf����ʱ�ĸ�ʽ������ת�����������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date3 = "2014-09-09";
		Date date4 = sdf.parse(date3);//String��תΪDate��
		System.out.println(date4);
		System.out.println(date4.after(date1));// �ж�date4�Ƿ���ϵͳʱ��֮��
		System.out.println(date4.before(date1));// �ж�date4�Ƿ���ϵͳʱ��֮ǰ
	}
	//Calendar��ʹ��
	public static void useCalendar() {
//		Calendar ca = Calendar.getInstance();
//		ca.add(Calendar.DAY_OF_WEEK, 2);//ϵͳĿǰ�����ڼ���2
//		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK)-1;//��ȡ��һ���õ���������
//		System.out.println(dayOfWeek);
//		
//		Calendar ca2 = Calendar.getInstance();
//		Date date1 = ca2.getTime();//ͨ��Calendar��������ȡʱ��
//		System.out.println(date1);
		
		Calendar ca3 = Calendar.getInstance();
		ca3.set(Calendar.DATE, 1);
		System.out.println(ca3.get(Calendar.DATE));
		
	}	
}
