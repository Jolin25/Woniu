package www.woniuxy.function.basic;

import java.util.Random;
import java.util.Scanner;

public class FunctionTest {
	public static void main(String[] args) {

		// �η�����

		System.out.println(power());
		// �������
	//	combination();
		// �žų˷���
	//	nineNine();
		//
	//	guess();
		//
	//	guessFive();
		//
	//	recognition() ;
	}

	// �η�����
	public static double power() {
		Scanner sc = new Scanner(System.in);
		double result = 1;
		System.out.print("�����������\n");
		double x = sc.nextDouble();
		System.out.print("������ָ����\n");
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

	// �������
	public static void combination() {
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 50; j++) {
				for (int k = 0; k <= 20; k++) {
					if ((i * 1 + j * 2 + k * 5 == 100) && (i + j + k == 50)) {
						System.out.print("һ��" + i + "ö������" + j + "ö�����" + k + "ö\n");
					}
				}
			}
		}
	}

	// �žų˷���
	public static void nineNine() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "  ");
			}
			System.out.println();
		}
	}

	// �۸�²²�
	public static void guess() {
		Random ran = new Random();
		int price = (int) (Math.random() * 200);
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		// System.out.print(price);
		while (!flag) {
			System.out.print("������²�ֵ��");
			int guessPrice = sc.nextInt();
			if (guessPrice > price) {
				System.out.print("����");
			} else if (guessPrice < price) {
				System.out.print("����");
			} else {
				flag = true;
				System.out.print("�¶���\n");
			}
		}
		sc.close();
	}

	// �۸�²²�������
	public static void guessFive() {
		Random ran = new Random();
		int price = (int) (Math.random() * 200);
		boolean flag = false;
		int times = 0;
		Scanner sc = new Scanner(System.in);
		// System.out.print(price);
		while (!flag && times <5) {
			System.out.print("������²�ֵ��");
			int guessPrice = sc.nextInt();
			if (guessPrice > price) {
				System.out.print("����");
			} else if (guessPrice < price) {
				System.out.print("����");
			} else {
				flag = true;
				System.out.print("�¶���\n");
			}
			times++;
		}
		if (times >= 5) {
			System.out.print("��ʱ������\n");
		}
		sc.close();
	}
	//�ַ����ж�
		public static void recognition() {
			Scanner sc = new Scanner(System.in);
			System.out.print("�������ַ�����\n");
			String str = sc.next();	
			int count = 0;
			for(int i = 0;i<str.length();i++) {
				char c = str.charAt(i);
				if(c>'0'&&c<'9') {
					if(i==str.length()-1) {
						System.out.print("����Ч����");
						break;
					}
				}else if(c =='.'){
					if(i==0||i==str.length()-1) {
						System.out.print("������Ч����");
						break;
					}
					count++;
					if(count>1) {
						System.out.print("������Ч����");
						break;
					}
				}
				else {
					System.out.print("������Ч����");
					break;
				}
					}
			sc.close();
		}

}

