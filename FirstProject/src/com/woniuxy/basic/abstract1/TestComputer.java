package com.woniuxy.basic.abstract1;
/*
 * 5、利用接口做参数，写个计算器，能完成加减乘除运算。 
（1）定义一个接口Compute含有一个方法int computer(int n,  int m)。 
（2）设计四个类分别实现此接口，完成加减乘除运算。 
（3）设计一个类UseCompute，类中含有方法：public void  useCom(Compute com, int one, int two)，此方法能够用传递 过来的对象调用computer方法完成运算，并输出运算的结果。 
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成 加减乘除运算

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
		uc.useCom(p, 1, 2);//u.useCom(new Plus(),1,2);可代替Plus p = new Plus();+uc.useCom(p, 1, 2);
		uc.useCom(d, 1, 2);
		uc.useCom(s, 1, 2);
		uc.useCom(m, 1, 2);
	}
}
