package www.woniuxy.function.basic;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		/*
		 * �����ε��ܳ������
		 */
//		Rectangle re = new Rectangle(2,3);
////		re.wide = 11;
////		re.tall = 22;
//		re.perimeter();
//		re.area();
		
		/*
		 * Բ���ܳ������
		 */
		System.out.println("������뾶��");
		Scanner sc = new Scanner(System.in);
		double nextDouble = sc.nextDouble();
		if(nextDouble<0) {
			System.out.println("�������\n");
		}else {
		Circle circle = new Circle(nextDouble);
		System.out.print(circle.show());
		}
	}
}