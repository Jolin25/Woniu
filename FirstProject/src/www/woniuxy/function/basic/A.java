package www.woniuxy.function.basic;

/*
 * 猜数字游戏一个类A有一个成员变量v有一个初值100。
 * 定义一个类对A类的成员变量v进行猜。如果大了则提示大了小了则提示小了。
 * 等于则提示猜测成功
 */
public class A {
	int v = 100;
	public void compare(int guess) {
		if (guess == v) {
			System.out.print("输入正确");
		} else if (guess < v) {
			System.out.println("小了");
		} else {
			System.out.println("大了");
		}
	}
}
