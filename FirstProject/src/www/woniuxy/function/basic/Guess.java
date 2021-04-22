package www.woniuxy.function.basic;
/*
 * 猜数字游戏一个类A有一个成员变量v有一个初值100。
 * 定义一个类对A类的成员变量v进行猜。如果大了则提示大了小了则提示小了。
 * 等于则提示猜测成功
 */

import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("请输入猜测值：");
		Scanner sc = new Scanner(System.in);
		int guess = sc.nextInt();
		a.compare(guess);
		sc.close();
	}
}