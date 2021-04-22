package www.woniuxy.function.basic;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		/*
		 * 长方形的周长和面积
		 */
//		Rectangle re = new Rectangle(2,3);
////		re.wide = 11;
////		re.tall = 22;
//		re.perimeter();
//		re.area();
		
		/*
		 * 圆的周长和面积
		 */
		System.out.println("请输入半径：");
		Scanner sc = new Scanner(System.in);
		double nextDouble = sc.nextDouble();
		if(nextDouble<0) {
			System.out.println("输入错误\n");
		}else {
		Circle circle = new Circle(nextDouble);
		System.out.print(circle.show());
		}
	}
}