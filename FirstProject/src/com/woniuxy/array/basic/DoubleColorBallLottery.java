package com.woniuxy.array.basic;

import java.util.Random;

public class DoubleColorBallLottery {
	public static void main(String []args) {
		int [] ball = new int[7];//最终双色球
		int [] redball = new int[33];//红球库
		// 为红球库赋值
		for(int i = 0;i<redball.length;i++) {
			redball[i] = i+1;
		}
		// 选取红球
		int length = 0;// 已选的红球数
		Random ran = new Random();//创建random对象
		while(length <= 5) {
			int index = ran.nextInt(33);//选取红球库的下标
				if(redball[index]!=0) {
					ball[length]=redball[index];
					length++;
					redball[index]=0;
					//break;//如果该数没有被选取过，则赋值给ball[],并且改变内容作为判断作用
				}
		}
		ball[6]=ran.nextInt(16) + 1;
		
		// 冒泡升序
		int t = 0;
		for(int i = 0;i<ball.length - 1 -1 ;i++) {
			for(int j = 0; j < ball.length - 1 - 1 - i;j++) {
				if(ball[j]>ball[j+1]) {
					t = ball[j];
					ball[j]=ball[j+1];
					ball[j+1]= t ;
				}
			}
			
		}
		
		System.out.println("双色球为：");
		for(int i:ball) {
			System.out.print(i  + " ");
		}
		
	}
}
