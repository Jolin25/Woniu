package com.woniuxy.basic.abstract1;
/*
 * 5、利用接口做参数，写个计算器，能完成加减乘除运算。 
（1）定义一个接口Compute含有一个方法int computer(int n,  int m)。 
（2）设计四个类分别实现此接口，完成加减乘除运算。 
（3）设计一个类UseCompute，类中含有方法：public void  useCom(Compute com, int one, int two)，此方法能够用传递 过来的对象调用computer方法完成运算，并输出运算的结果。 
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成 加减乘除运算

 */
public interface Computer {
	int computer(int n,int m);
}
