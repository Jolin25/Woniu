package com.woniuxy.string.basic;

import java.util.Arrays;

/*
 * 电信流水账单
 */
public class TelecomAccount {
	public static void main(String[] args) {
		String origin = "[2018][04][03][13][15][36]-[2018][04][03][21][15][46] {18182113587}(1)|}";
		/*
		 * 拆分通话开始时间和结束时间
		 */
		//获取两个通话时间的字符串
		String timeSub = origin.substring(0, origin.lastIndexOf("]")+1);
		//System.out.println(timeSub);
		String[]times = timeSub.split("-");
		String startTime = times[0];
		String endTime = times[1];
		//更改格式
		startTime = startTime.substring(1, startTime.length()-1);//因为后面用split的时候，第一个和最后一个位置不进行判断
		endTime = endTime.substring(1, endTime.length()-1);
		String[] startTimeSplit = startTime.split("\\]\\[");
		String[] endTimeSplit = endTime.split("\\]\\[");
		//System.out.println(Arrays.toString(startTimeSplit));
		startTime = startTime.format("%s-%s-%s %s:%s:%s",startTimeSplit[0],startTimeSplit[1],startTimeSplit[2],
				startTimeSplit[3],startTimeSplit[4],startTimeSplit[5]);
		//System.out.println(startTime);
		endTime = endTime.format("%s-%s-%s %s:%s:%s", endTimeSplit[0],endTimeSplit[1],endTimeSplit[2],
				endTimeSplit[3],endTimeSplit[4],endTimeSplit[5]);
		/*
		 * 拆分电话号
		 */
		String phone = origin.substring(origin.indexOf("{")+1, origin.indexOf("}"));
		//System.out.println(phone);
		/*
		 * 拆分呼叫方式
		 */
		String callType = origin.substring(origin.indexOf("(")+1, origin.indexOf(")"));
		//System.out.println(callType);
		//转化为Integer类型
		Integer typeInt = Integer.valueOf(callType);
		callType = typeInt == 1?"主叫":"被叫";
		//System.out.println(callType);
		/*
		 * 输出
		 */
		System.out.println("通话开始时间："+startTime+"\n"+"通话结束时间："+endTime+"\n"+
		 "联系电话："+phone+"\n"+"呼叫方式："+callType+"\n");
		
	}

}
