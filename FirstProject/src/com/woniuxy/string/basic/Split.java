package com.woniuxy.string.basic;
/*
 * �����¸�ʽ���ַ���name-age-sex-address,����������,�������Ϣ��

 */
public class Split {
	public static void main(String[] args) {
		String str = "ը��-0.7-��-����㳡";
		String[] str1 = str.split("-");
		System.out.println("name:"+str1[0]+" age:"+str1[1]+" sex:"+str1[2]+" address:"+str1[3]);
	}
}
