package com.woniuxy.basic.abstract1;
/*
 * 5�����ýӿ���������д��������������ɼӼ��˳����㡣 
��1������һ���ӿ�Compute����һ������int computer(int n,  int m)�� 
��2������ĸ���ֱ�ʵ�ִ˽ӿڣ���ɼӼ��˳����㡣 
��3�����һ����UseCompute�����к��з�����public void  useCom(Compute com, int one, int two)���˷����ܹ��ô��� �����Ķ������computer����������㣬���������Ľ���� 
��4�����һ������Test������UseCompute�еķ���useCom����� �Ӽ��˳�����

 */
public class TestComputer {
	public static void main(String[] args) {
		Plus p = new Plus();
		Subtract s = new Subtract();
		Multiply m = new Multiply();
		Divide d = new Divide();
		//
		UseComputer uc = new UseComputer();
		//
		uc.useCom(p, 1, 2);//u.useCom(new Plus(),1,2);�ɴ���Plus p = new Plus();+uc.useCom(p, 1, 2);
		uc.useCom(d, 1, 2);
		uc.useCom(s, 1, 2);
		uc.useCom(m, 1, 2);
	}
}
