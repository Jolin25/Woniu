//�����ʵ����һ������
package com.woniuxy.array.basic;

import java.util.Arrays;
import java.util.Scanner;

/*һά����*/
	public class Array {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		/* array1  δ��ֵ*/
		String[] array1 = new String[10];
		int[] array11 = new int[10];
		//int i = 0;
		/* foreach���Ԫ�ر���i����Ҫ����,iʵ���ϴ������array1[],i���Ի��ɹ�
		 * jdk1.5�Ժ����ʹ��
		 */
		for(String i:array1) {
			System.out.print(i + "\t");
			
		}
		System.out.println();
		/*Ĭ��ֵΪ����������������͵�Ĭ��ֵ*/
		for(int i:array11) {
			System.out.print(i + "\t");
			
		}
		System.out.println(Arrays.toString(array11));
		System.out.println();
		System.out.println("-----------------");
		/*array2 for each 
		 * array.length*/
		int [] array2 = new int[10];
		for(int j=0;j<10;j++) {
			array2[j]=j;
		}
		for(int i:array2) {
			System.out.print(i);
			
		}
		System.out.println();
		System.out.println(array2.length);
		System.out.println("-----------------");
		/*������滻
		 * */
		int[]a= {1,2,3};
		int[]b=new int [3];
		b = a;//��a�ĵ�ַ��ֵ��b������ʱbҲָ��a��ָ��Ķ���Ķ���
		for(int i:b) {
			System.out.print(i);
			
		}
		System.out.println();
		System.out.println("-----------------");
		a[0]=9;
		for(int i:a) {
			System.out.print(i);
			
		}
		System.out.println();
		System.out.println("-----------------");
		for(int i:b) {
			System.out.print(i);
			
		}
		System.out.println();
		System.out.println("-----------------");
	/*����Ķ�̬��չ ��array2��չ��array3*/
		System.out.println(array2.length);
		int []array3 = new int[array2.length+3];//�������Ӻ�����鳤��
		System.out.println(array3.length);
		//��array2��ֵȫ������array3
		for(int k = 0;k<array2.length;k++) {
			array3[k]=array2[k];
		}
		array2 = array3;//��array3�ĵ�ַ��ֵ��array2
		System.out.println(array2.length);
		System.out.println(array3.length);
		sc.close();
	}
}
