//数组的实质是一个对象
package com.woniuxy.array.basic;

import java.util.Arrays;
import java.util.Scanner;

/*一维数组*/
	public class Array {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		/* array1  未赋值*/
		String[] array1 = new String[10];
		int[] array11 = new int[10];
		//int i = 0;
		/* foreach里的元素变量i不需要申明,i实际上代表的是array1[],i可以换成狗
		 * jdk1.5以后可以使用
		 */
		for(String i:array1) {
			System.out.print(i + "\t");
			
		}
		System.out.println();
		/*默认值为声明数组的数组类型的默认值*/
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
		/*数组的替换
		 * */
		int[]a= {1,2,3};
		int[]b=new int [3];
		b = a;//将a的地址赋值给b，即此时b也指向a所指向的堆里的对象
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
	/*数组的动态扩展 把array2扩展成array3*/
		System.out.println(array2.length);
		int []array3 = new int[array2.length+3];//设置增加后的数组长度
		System.out.println(array3.length);
		//把array2的值全部赋给array3
		for(int k = 0;k<array2.length;k++) {
			array3[k]=array2[k];
		}
		array2 = array3;//把array3的地址赋值给array2
		System.out.println(array2.length);
		System.out.println(array3.length);
		sc.close();
	}
}
