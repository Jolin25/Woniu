//�����⣺���л���
package com.woniuxy.java.basic;

import java.util.Scanner;

public class TextSuper {
	public static void main(String[]args) {
		System.out.println("���������ѽ�");//������
		Scanner sc = new Scanner(System.in);
		double money = sc.nextDouble();
		String thing = "nothing";
		System.out.println("�Ƿ�μ��Żݻ������\n"+
				"1:��50Ԫ����2Ԫ�������¿���һƿ\n"+
				"2:��100Ԫ����3Ԫ����500ml����һƿ\n"+
				"3����100Ԫ����10Ԫ�����幫�����\n"+
				"4����200Ԫ����10Ԫ����һ���ղ������˹�"+
				"5����200Ԫ����20Ԫ�ɻ���ŷ����ˬ��ˮһƿ\n"+
				"0��������\n");
		System.out.println("��ѡ��");//ѡ�񻻹���Ʒ
		int choose = sc.nextInt();
		if((money<50&&choose!=0)||
			(money<100&&(choose==2||choose==3))||
			(money<200)&&(choose==4||choose==5)) {
			System.out.println("�������");
			choose = 0;
		}/*�����ܽ��ͻ�����Ʒ*/
		switch(choose){
			case 1:
				money += 2;
				thing = "���¿���һƿ";
				break;
			case 2:
				money += 3;
				thing = "500ml����һƿ";
				break;
			case 3:
				money += 10;
				thing = "�幫�����";
				break;
			case 4:
				money += 10;
				thing = "һ���ղ������˹�";
				break;
			case 5:
				money += 20;
				thing = "����ˬ��ˮһƿ";
				break;
			case 0:
				thing = "nothing";
					break;
			
		}
		System.out.println("���������ܽ�"+money+"�ɹ�������"+thing);
		sc.close();
}
}
