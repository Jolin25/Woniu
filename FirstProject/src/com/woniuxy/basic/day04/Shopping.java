package com.woniuxy.basic.day04;

import java.util.Scanner;

public class Shopping {
	public static void main(String[] args) {
		String another = "y";// �Ƿ��������
		Scanner sc = new Scanner(System.in);
		int thing;// ���
		int number;// ����
		double price;// ����
		// double money;// ���������ܶ�
		double allMoney = 0;// �ϼ�����
		String Vip;// ��Ա
		double outOfPocket;// ʵ�����
		/*��Ҫ��������ʱ�����㵥�ι������*/
		while (another.equals("y")) {
			System.out.println("*******************************");
			System.out.println("��ѡ�������Ʒ��ţ�\n" + "1.T ��        2.����Ь        3.������");
			System.out.println("*******************************");
			System.out.println("��������Ʒ��ţ�");
			thing = sc.nextInt();
			System.out.println("�����빺��������");
			number = sc.nextInt();
			/*�жϹ������Ʒ�����������е��μ��㣬�����
			��ѡ���Ƿ����*/
			switch (thing) {
			case 1:
				price = 245;
				System.out.println("T������" + price + "   " + "������" + number + "   " + "�ϼ�:��" + price * number);
				allMoney += price * number;
				System.out.println("�Ƿ��������y/n��");
				System.out.println();
				another = sc.next();
				break;
			case 2:
				price = 570;
				System.out.println("����Ь����" + price + "   " + "������" + number + "   " + "�ϼ�:��" + price * number);
				allMoney += price * number;
				System.out.println("�Ƿ��������y/n��");
				System.out.println();
				another = sc.next();
				break;
			case 3:
				price = 460;
				System.out.println("�����ģ���" + price + "   " + "������" + number + "   " + "�ϼ�:��" + price * number);
				allMoney += price * number;
				System.out.println("�Ƿ��������y/n��");
				System.out.println();
				another = sc.next();
				break;
			default:
				System.out.println("�������");
				System.out.println();
				break;
			}

		}/*��������󣬼����ܽ���*/
		System.out.println("�Ƿ��ǻ�Ա��y/n����");
		Vip = sc.next();
		/*��Ա*/
		if (Vip.equals("y")) {
			System.out.println("�ۿۣ�" + allMoney * 0.1);
			System.out.println("Ӧ����" + allMoney * 0.9);
			System.out.println("������ʵ����");
			outOfPocket = sc.nextDouble();
			System.out.println("ʵ����" + outOfPocket);
			if (outOfPocket - allMoney * 0.9 > 0) {
				System.out.println("��Ǯ��" + (outOfPocket - allMoney * 0.9));
			} else {
				System.out.println("�������");
			}
		} 
		/*�ǻ�Ա*/
		else {
			System.out.println("�ۿۣ�0");
			System.out.println("Ӧ����" + allMoney);
			System.out.println("������ʵ����");
			outOfPocket = sc.nextDouble();
			System.out.println("ʵ����" + outOfPocket);
			if (outOfPocket - allMoney > 0) {
				System.out.println("��Ǯ��" + (outOfPocket - allMoney));
			} else {
				System.out.print("�������");
			}
		}
		sc.close();
	}
}
