package com.woniuxy.calendar.basic;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		/*
		 * 构造Calendar对象------因为Calendar类是抽象类，
		 *  所以要用类调用这个方法来构造对象 返回的是Calendar类的子类对象
		 */
		Calendar cal = Calendar.getInstance();// 多态 父类名 对象名 = 子类对象；
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
		 * MILLISECOND=423,ZONE_OFFSET=28800000,DST_OFFSET=0] 下面这行代码打印出来的结果
		 * 说明了Calendar类重写了toString方法 因为现实的不是地址，而是有含义的内容
		 * 
		 */
		// System.out.println(cal);
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONDAY) + 1;// 因为默认从0开始算一月
		int date = cal.get(cal.DATE);
		int hour = cal.get(cal.HOUR_OF_DAY);
		int minute = cal.get(cal.MINUTE);
		int second = cal.get(cal.SECOND);
		System.out.println(year + "年" + month + "月" + date + "日" + hour + "时" + minute + "分" + second + "秒");
	
	}
}
