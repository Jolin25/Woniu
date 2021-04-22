package com.woniuxy.cyclic.basic;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// 循环求和
		int suma = 0;
		for (int i = 100; i <= 500; i++) {
			suma += i;
		}
		System.out.println(suma);
		System.out.println("----------------------");
		// 判断字符
		Scanner sc = new Scanner(System.in);// 创建对象
		System.out.println("请输入字符");
		char something = sc.next().charAt(0);
		int ascii = (int) something;// 求字符的ascii码
		//也可以if(something>='0'&&something<='9')
		if (ascii >= 48 && ascii <= 57) {
			System.out.println("该字符是一个数字");
		} else if (ascii >= 65 && ascii <= 90) {
			System.out.println("该字符是一个大写字母");
		}//也可以else if(something>='z'&&something<='a') 
		else if (ascii >= 97 && ascii <= 122) {
			System.out.println("该字符是一个小写字母");
		} else {
			System.out.println("该字符是一个符号");
		}
		System.out.println("ascii值为：" + ascii);
		System.out.println("----------------------");
		// 水仙花数
		int hundredPlace;// 百位
		int decade;// 十位
		int theUnit;// 个位
		int sum1;// 三次方结果
		for (int i = 100; i <= 999; i++) {

			hundredPlace = i / 100;
			decade = i % 100 / 10;
			theUnit = i % 100 % 10;
			sum1 = hundredPlace * hundredPlace * hundredPlace + decade * decade * decade + theUnit * theUnit * theUnit;
			if (sum1 == i) {
				System.out.print("水仙花数有："+i + " "+"\n");
			}
		}
		System.out.println("----------------------");
		System.out.println("");
		// 统计字符
		int numberN=0;
		int bigN=0;
		int smallN=0;
		int specilN=0;
		System.out.println("请输入一个字符串：");
		String str = sc.next();
		//char firstChar = str.charAt(0);//读取str的第1位字符给firstchar
		/*stri.charAt(i)读取第i+1个字符*/
		for(int i = 0;i<str.length();i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				numberN += 1;
				
			} else if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				bigN += 1;
				
			} else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				smallN += 1;
				
			} else {
				specilN += 1;
				
			}
		}
		System.out.println("这个字符串中有："+numberN+"个数字，"+bigN+"个大写字母，"+smallN+"个小写字母，"+specilN+"个特殊符号");
		System.out.println("----------------------");
		System.out.println("");
		//组合问题
		int r ;
		int b ;
		int w;
		int sum=0 ;
		for(r=0;r<=5;r++) {
			for(b=0;b<=7;b++) {
				for(w=0;w<=9;w++) {
					if(r+b+w==12) {
						sum +=1;
					}
				}
			}
		}
		System.out.println("可能的颜色组合有"+sum+"种");
		sc.close();
	}
	
}
