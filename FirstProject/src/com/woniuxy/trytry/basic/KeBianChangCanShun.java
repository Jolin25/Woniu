package com.woniuxy.trytry.basic;

public class KeBianChangCanShun {
	public void k(int...a) {
		a[0] = 1;
		a[1]= 2;
		//�ɱ䳤������ʵ�����ǵ�������Ϊ���鴦��
		fs();
	}
	public void fs() {
		System.out.println("�Ǿ�̬����");
	}
	public static void s() {
		System.out.println("��̬����");
		
	}
	public static void main(String[] args) {
		s();
		KeBianChangCanShun ke = new KeBianChangCanShun();
		KeBianChangCanShun.s();
		ke.s();
		
	}
	
}
