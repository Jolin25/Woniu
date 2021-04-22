package com.woniu.io.basic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 2、停车场有进场和出场的功能
1)进场时：采用键盘录入的方式，录入汽车的品牌、颜色、车牌号。把品牌、颜色、车牌号，
			以及进场时间写入car.txt文件中。
2)出场时：键盘录入车牌号，去文件中查找该车的进场时间，并计算停车时间。
3)30分钟内免费，过后每小时3元，超过一小时安一小时计算。
分析：
	1.public void in (){}
		car.txt（创建）:String brand;String color;String licensePlateNumber;Date inTime
	  	ObjectOutputStream
	  	Car[] c （car类实现serializable）
	2.public void out(String licensePlateNumber){}
		在Car[]中找，找到后把对应元素的InTime输出，Date outTime - InTime  精确到分
	3.计算。。
 */
public class Car implements Serializable {
	String brand;
	String color;
	String licensePlateNumber;
	Date inTime;
	
	
	
	
}
