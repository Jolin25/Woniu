package com.woniuxy.array.basic;

import java.util.Random;

public class DoubleColorBallLottery {
	public static void main(String []args) {
		int [] ball = new int[7];//����˫ɫ��
		int [] redball = new int[33];//�����
		// Ϊ����⸳ֵ
		for(int i = 0;i<redball.length;i++) {
			redball[i] = i+1;
		}
		// ѡȡ����
		int length = 0;// ��ѡ�ĺ�����
		Random ran = new Random();//����random����
		while(length <= 5) {
			int index = ran.nextInt(33);//ѡȡ�������±�
				if(redball[index]!=0) {
					ball[length]=redball[index];
					length++;
					redball[index]=0;
					//break;//�������û�б�ѡȡ������ֵ��ball[],���Ҹı�������Ϊ�ж�����
				}
		}
		ball[6]=ran.nextInt(16) + 1;
		
		// ð������
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
		
		System.out.println("˫ɫ��Ϊ��");
		for(int i:ball) {
			System.out.print(i  + " ");
		}
		
	}
}
