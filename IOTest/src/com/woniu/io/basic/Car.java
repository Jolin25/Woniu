package com.woniu.io.basic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 2��ͣ�����н����ͳ����Ĺ���
1)����ʱ�����ü���¼��ķ�ʽ��¼��������Ʒ�ơ���ɫ�����ƺš���Ʒ�ơ���ɫ�����ƺţ�
			�Լ�����ʱ��д��car.txt�ļ��С�
2)����ʱ������¼�복�ƺţ�ȥ�ļ��в��Ҹó��Ľ���ʱ�䣬������ͣ��ʱ�䡣
3)30��������ѣ�����ÿСʱ3Ԫ������һСʱ��һСʱ���㡣
������
	1.public void in (){}
		car.txt��������:String brand;String color;String licensePlateNumber;Date inTime
	  	ObjectOutputStream
	  	Car[] c ��car��ʵ��serializable��
	2.public void out(String licensePlateNumber){}
		��Car[]���ң��ҵ���Ѷ�ӦԪ�ص�InTime�����Date outTime - InTime  ��ȷ����
	3.���㡣��
 */
public class Car implements Serializable {
	String brand;
	String color;
	String licensePlateNumber;
	Date inTime;
	
	
	
	
}
