package com.woniuxy.string.basic;

import java.util.Arrays;

/*
 * ������ˮ�˵�
 */
public class TelecomAccount {
	public static void main(String[] args) {
		String origin = "[2018][04][03][13][15][36]-[2018][04][03][21][15][46] {18182113587}(1)|}";
		/*
		 * ���ͨ����ʼʱ��ͽ���ʱ��
		 */
		//��ȡ����ͨ��ʱ����ַ���
		String timeSub = origin.substring(0, origin.lastIndexOf("]")+1);
		//System.out.println(timeSub);
		String[]times = timeSub.split("-");
		String startTime = times[0];
		String endTime = times[1];
		//���ĸ�ʽ
		startTime = startTime.substring(1, startTime.length()-1);//��Ϊ������split��ʱ�򣬵�һ�������һ��λ�ò������ж�
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
		 * ��ֵ绰��
		 */
		String phone = origin.substring(origin.indexOf("{")+1, origin.indexOf("}"));
		//System.out.println(phone);
		/*
		 * ��ֺ��з�ʽ
		 */
		String callType = origin.substring(origin.indexOf("(")+1, origin.indexOf(")"));
		//System.out.println(callType);
		//ת��ΪInteger����
		Integer typeInt = Integer.valueOf(callType);
		callType = typeInt == 1?"����":"����";
		//System.out.println(callType);
		/*
		 * ���
		 */
		System.out.println("ͨ����ʼʱ�䣺"+startTime+"\n"+"ͨ������ʱ�䣺"+endTime+"\n"+
		 "��ϵ�绰��"+phone+"\n"+"���з�ʽ��"+callType+"\n");
		
	}

}
