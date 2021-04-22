package com.woniuxy.basic.abstract1;
//java中不能多继承,所以可以用接口来弥补
public class Me implements Mother , Father,Talk{
	public static void main(String[] args) {
		Me me = new Me();
		me.jump();
		//me.drink();不能调用接口里的自定义方法
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
