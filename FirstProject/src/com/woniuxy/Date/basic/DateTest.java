package com.woniuxy.Date.basic;
import java.util.Date;
public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();// Ŀǰ��ϵͳ����
		System.out.println("Ŀǰ��ϵͳ���ڣ�" + date);
		Date date2 = new Date(123455555);// ��1970��1��һ���𣬾�����123455555����������
		System.out.println(date2);
		boolean i = date.after(date2);// date�Ƿ���date2������֮��
		System.out.println(i);
		long j = date.getTime();
		System.out.println("��������" + j);// ������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�����
		date.setTime(1000);
		System.out.println(date);// ��Ϊ�Ƕ������������Ǳȸ���ʱ���8Сʱ��
	}
}
