package www.woniuxy.function.basic;
/*
 * ��������Ϸһ����A��һ����Ա����v��һ����ֵ100��
 * ����һ�����A��ĳ�Ա����v���в¡������������ʾ����С������ʾС�ˡ�
 * ��������ʾ�²�ɹ�
 */

import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("������²�ֵ��");
		Scanner sc = new Scanner(System.in);
		int guess = sc.nextInt();
		a.compare(guess);
		sc.close();
	}
}