package com.woniuxy.regex.basic;
/*
 * �绰��ƥ��
 */
public class TelRegEx {
	public static void main(String[] args) {
		TelRegEx telReg = new TelRegEx();
		boolean i = telReg.isTel("13345678901");
		System.out.println(i);
	}
	public boolean isTel(String tel) {
		//�������
		String telRegEx = "[1](3|5|7|8|9)[0-9]{9}";//1[35789][0-9]{9},1[35789]\\d{9}Ҳ����
		//����ƥ��
		boolean i = tel.matches(telRegEx);
		
		return i;
	}
}
