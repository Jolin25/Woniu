package com.woniuxy.cyclic.basic;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// ѭ�����
		int suma = 0;
		for (int i = 100; i <= 500; i++) {
			suma += i;
		}
		System.out.println(suma);
		System.out.println("----------------------");
		// �ж��ַ�
		Scanner sc = new Scanner(System.in);// ��������
		System.out.println("�������ַ�");
		char something = sc.next().charAt(0);
		int ascii = (int) something;// ���ַ���ascii��
		//Ҳ����if(something>='0'&&something<='9')
		if (ascii >= 48 && ascii <= 57) {
			System.out.println("���ַ���һ������");
		} else if (ascii >= 65 && ascii <= 90) {
			System.out.println("���ַ���һ����д��ĸ");
		}//Ҳ����else if(something>='z'&&something<='a') 
		else if (ascii >= 97 && ascii <= 122) {
			System.out.println("���ַ���һ��Сд��ĸ");
		} else {
			System.out.println("���ַ���һ������");
		}
		System.out.println("asciiֵΪ��" + ascii);
		System.out.println("----------------------");
		// ˮ�ɻ���
		int hundredPlace;// ��λ
		int decade;// ʮλ
		int theUnit;// ��λ
		int sum1;// ���η����
		for (int i = 100; i <= 999; i++) {

			hundredPlace = i / 100;
			decade = i % 100 / 10;
			theUnit = i % 100 % 10;
			sum1 = hundredPlace * hundredPlace * hundredPlace + decade * decade * decade + theUnit * theUnit * theUnit;
			if (sum1 == i) {
				System.out.print("ˮ�ɻ����У�"+i + " "+"\n");
			}
		}
		System.out.println("----------------------");
		System.out.println("");
		// ͳ���ַ�
		int numberN=0;
		int bigN=0;
		int smallN=0;
		int specilN=0;
		System.out.println("������һ���ַ�����");
		String str = sc.next();
		//char firstChar = str.charAt(0);//��ȡstr�ĵ�1λ�ַ���firstchar
		/*stri.charAt(i)��ȡ��i+1���ַ�*/
		for(int i = 0;i<str.length();i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				numberN += 1;
				
			} else if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				bigN += 1;
				
			} else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				smallN += 1;
				
			} else {
				specilN += 1;
				
			}
		}
		System.out.println("����ַ������У�"+numberN+"�����֣�"+bigN+"����д��ĸ��"+smallN+"��Сд��ĸ��"+specilN+"���������");
		System.out.println("----------------------");
		System.out.println("");
		//�������
		int r ;
		int b ;
		int w;
		int sum=0 ;
		for(r=0;r<=5;r++) {
			for(b=0;b<=7;b++) {
				for(w=0;w<=9;w++) {
					if(r+b+w==12) {
						sum +=1;
					}
				}
			}
		}
		System.out.println("���ܵ���ɫ�����"+sum+"��");
		sc.close();
	}
	
}
