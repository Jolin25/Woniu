package com.woniuxy.array.basic;

public class MutidensionalArray2 {
	public static void main(String[]args) {
		String [][] arr1 = new String[2][];
		arr1[0]=new String[2];
		arr1[1]=new String[2];//�ֱ�Ϊÿһά����ռ�
		arr1[0][0] = "one";
		System.out.println(arr1[0][0]);
	}
}
