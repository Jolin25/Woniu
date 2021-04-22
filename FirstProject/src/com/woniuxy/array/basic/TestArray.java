package com.woniuxy.array.basic;

public class TestArray {
	public static void main(String[]args) {
		/*int [] arr1 = new int [2];
		arr1 = {1,1};//错误，因为创建数组并赋值，必须在一条语句中实现
		*/
		int []arr2 = new int[2];
		for(int i = 0;i<arr2.length;i++) {
			arr2[i]=i;
		}//为什么对了。。
	}
}
