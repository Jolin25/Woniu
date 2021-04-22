package www.woniuxy.function.basic;

import java.util.Random;
import java.util.Scanner;

public class FunctionTest {
	public static void main(String[] args) {

		// 次方计算

		System.out.println(power());
		// 组合问题
	//	combination();
		// 九九乘法表
	//	nineNine();
		//
	//	guess();
		//
	//	guessFive();
		//
	//	recognition() ;
	}

	// 次方计算
	public static double power() {
		Scanner sc = new Scanner(System.in);
		double result = 1;
		System.out.print("请输入底数：\n");
		double x = sc.nextDouble();
		System.out.print("请输入指数：\n");
		double y = sc.nextDouble();
		if (y == 0) {
			result = 1;
		} else if(y<0&&x!=0){
			for (int i = 0; i < -y; i++) {
				result *= x;}
			//System.out.print(result);
			result = 1/result;
		}else{
			for (int i = 0; i < y; i++)
				result *= x;
		}sc.close();
		return result;
	}

	// 组合问题
	public static void combination() {
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 50; j++) {
				for (int k = 0; k <= 20; k++) {
					if ((i * 1 + j * 2 + k * 5 == 100) && (i + j + k == 50)) {
						System.out.print("一分" + i + "枚，两分" + j + "枚，五分" + k + "枚\n");
					}
				}
			}
		}
	}

	// 九九乘法表
	public static void nineNine() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "  ");
			}
			System.out.println();
		}
	}

	// 价格猜猜猜
	public static void guess() {
		Random ran = new Random();
		int price = (int) (Math.random() * 200);
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		// System.out.print(price);
		while (!flag) {
			System.out.print("请输入猜测值：");
			int guessPrice = sc.nextInt();
			if (guessPrice > price) {
				System.out.print("高了");
			} else if (guessPrice < price) {
				System.out.print("低了");
			} else {
				flag = true;
				System.out.print("猜对了\n");
			}
		}
		sc.close();
	}

	// 价格猜猜猜升级版
	public static void guessFive() {
		Random ran = new Random();
		int price = (int) (Math.random() * 200);
		boolean flag = false;
		int times = 0;
		Scanner sc = new Scanner(System.in);
		// System.out.print(price);
		while (!flag && times <5) {
			System.out.print("请输入猜测值：");
			int guessPrice = sc.nextInt();
			if (guessPrice > price) {
				System.out.print("高了");
			} else if (guessPrice < price) {
				System.out.print("低了");
			} else {
				flag = true;
				System.out.print("猜对了\n");
			}
			times++;
		}
		if (times >= 5) {
			System.out.print("超时，输了\n");
		}
		sc.close();
	}
	//字符串判断
		public static void recognition() {
			Scanner sc = new Scanner(System.in);
			System.out.print("请输入字符串：\n");
			String str = sc.next();	
			int count = 0;
			for(int i = 0;i<str.length();i++) {
				char c = str.charAt(i);
				if(c>'0'&&c<'9') {
					if(i==str.length()-1) {
						System.out.print("是有效数字");
						break;
					}
				}else if(c =='.'){
					if(i==0||i==str.length()-1) {
						System.out.print("不是有效数字");
						break;
					}
					count++;
					if(count>1) {
						System.out.print("不是有效数字");
						break;
					}
				}
				else {
					System.out.print("不是有效数字");
					break;
				}
					}
			sc.close();
		}

}

