package com.woniuxy.basic.abstract1;
/*
 * 5�����ýӿ���������д��������������ɼӼ��˳����㡣 
��1������һ���ӿ�Compute����һ������int computer(int n,  int m)�� 
��2������ĸ���ֱ�ʵ�ִ˽ӿڣ���ɼӼ��˳����㡣 
��3�����һ����UseCompute�����к��з�����public void  useCom(Compute com, int one, int two)���˷����ܹ��ô��� �����Ķ������computer����������㣬���������Ľ���� 
��4�����һ������Test������UseCompute�еķ���useCom����� �Ӽ��˳�����

 */
public class Subtract implements Computer {

	@Override
	public int computer(int n, int m) {
		// TODO Auto-generated method stub
		return n-m;
	}

}
