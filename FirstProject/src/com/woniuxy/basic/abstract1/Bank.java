package com.woniuxy.basic.abstract1;
/*
 * 6������������ƽӿڣ����ʵ���ࣺ
    1�����б�׼������Ǯ��ȡǮ��
    2����������ִ�����б�׼��
    3��������׼�����š����ţ�
    4���й�����ִ�����б�׼��������׼��
 */
public interface Bank {
	//double balance = 0;//���
	double getBalance();
	double saveMoney(double increment);
	double drawMoney(double decrement);
}
