package com.woniuxy.basic.day04;

public class Cyclic {
	public static void main(String[] args) {
		/**
		 * for(int i = 0;i < 100 ;i++) { if(i>22) { continue; } System.out.println("��" +
		 * (i+1));
		 * 
		 * 
		 * if(i>48) { break; } }
		 */

		/**
		 * int i = 1; while(i<=100) { i++; System.out.println("��д�����"+i+"��");
		 * //��Ϊi�Ѿ�����1�ˣ��������ֽ����������ж� }
		 */
		int i = 0;
		do {
			System.out.println("��" + (i + 1));
			i++;
		} while (i < 10);

	}
}
