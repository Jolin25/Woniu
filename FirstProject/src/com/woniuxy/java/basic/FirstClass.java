package com.woniuxy.java.basic;
import java.util.Scanner;//1.����
public class FirstClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//2.����Scanner�Ķ��󣨹̶���ʽ��
		System.out.println("�������������");
		String name = sc.next();//3.ʹ��Scanner�Ķ���ȥ����Scanner�����ṩ�ķ���
		System.out.println("�������������");
		String age = sc.nextLine();
		System.out.println("��������ļ���");
		String place = sc.next();
		System.out.println("����:" + name +" ����:" + age +" ���磺"+ place);
		sc.close();//4.�ر�Scanner
	}

}
