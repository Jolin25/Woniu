package com.woniuxy.calendar.basic;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		/*
		 * ����Calendar����------��ΪCalendar���ǳ����࣬
		 *  ����Ҫ����������������������� ���ص���Calendar����������
		 */
		Calendar cal = Calendar.getInstance();// ��̬ ������ ������ = �������
		/*
		 * java.util.GregorianCalendar [time=1556081986423,areFieldsSet=true,
		 * areAllFieldsSet=true,lenient=true,
		 * zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",
		 * offset=28800000,dstSavings=0,useDaylight=false,
		 * transitions=19,lastRule=null],firstDayOfWeek=1,
		 * minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,
		 * MONTH=3,WEEK_OF_YEAR=17,WEEK_OF_MONTH=4,DAY_OF_MONTH=24,
		 * DAY_OF_YEAR=114,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=4,
		 * AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=59,SECOND=46,
		 * MILLISECOND=423,ZONE_OFFSET=28800000,DST_OFFSET=0] �������д����ӡ�����Ľ��
		 * ˵����Calendar����д��toString���� ��Ϊ��ʵ�Ĳ��ǵ�ַ�������к��������
		 * 
		 */
		// System.out.println(cal);
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONDAY) + 1;// ��ΪĬ�ϴ�0��ʼ��һ��
		int date = cal.get(cal.DATE);
		int hour = cal.get(cal.HOUR_OF_DAY);
		int minute = cal.get(cal.MINUTE);
		int second = cal.get(cal.SECOND);
		System.out.println(year + "��" + month + "��" + date + "��" + hour + "ʱ" + minute + "��" + second + "��");
	
	}
}
