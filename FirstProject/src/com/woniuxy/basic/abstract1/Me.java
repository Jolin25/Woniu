package com.woniuxy.basic.abstract1;
//java�в��ܶ�̳�,���Կ����ýӿ����ֲ�
public class Me implements Mother , Father,Talk{
	public static void main(String[] args) {
		Me me = new Me();
		me.jump();
		//me.drink();���ܵ��ýӿ�����Զ��巽��
		me.talk();
	}
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jumping....");
	}
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("talking....");
	}
	
}
