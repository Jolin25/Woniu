package com.woniuxy.basic.abstract1;
/*
 * 1������һ���˵���(���������֣����䡣дһ����������Ը��� ��ֵ�ķ���showInfo())��
 * ����һ��ѧ����(�������Ա�)��ѧ���� �����ࡣ
Ҫ��
1����������Ը�ֵ�ù��췽����ʵ�֣�
2������ ������Ҳ�ù��췽������ֵ��
3������������д�����showInfo() ������
4������ѧ����Ķ��󣬵���ѧ������ʾ��Ϣ�ķ�����
 */
public class TestPersonStudent {
	public static void main(String[] args) {
		Student st = new Student("��һ", 17, '��');
		st.showInfo();
	}
}
