package com.woniuxy.polymorphism.basic;
/*
 * 内部类
 */
public class Neibunei {
	int a = 1;
	public void a() {
		
	}
	public Neibunei() {
		System.out.println("Neibunei构造器");
	}
	//内部类
	public class N1{
		int a = 2 ;
		public N1(){
			System.out.println("N1构造器");
		}
		
		void a() {
			
		}
		
		
	}
	public static void main(String[] args) {
		Neibunei n = new Neibunei();
		N1 n1 = n.new N1();
		System.out.println(n1.a);
	}
}
class N2{
	public N2() {
		
	}
}
