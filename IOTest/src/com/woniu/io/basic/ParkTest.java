package com.woniu.io.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


/*
 * 2、停车场有进场和出场的功能
1)进场时：采用键盘录入的方式，录入汽车的品牌、颜色、车牌号。把品牌、颜色、车牌号，
			以及进场时间写入car.txt文件中。
2)出场时：键盘录入车牌号，去文件中查找该车的进场时间，并计算停车时间。
3)30分钟内免费，过后每小时3元，超过一小时安一小时计算。
分析：
	1.public void in (){}
		car.txt（创建）:String brand;String color;String licensePlateNumber;Date inTime
	  	ObjectOutputStream{
	  		sc.next
	  	}
	  	Car[] c （car类实现serializable）
	2.public void out(String licensePlateNumber){}
		在Car[]中找，找到后把对应元素的InTime输出，Date outTime - InTime  精确到分
	3.计算。。
 */

public class ParkTest {
	// 创建文件夹
	public static void creatCartxt() {
		File file = new File("carData.txt");
		try {
			file.createNewFile();// 创建carData.txt文件夹
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 录入进场数据
	public static void intoThePark() throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		// 用对象输出流把车的信息输入到carData.txt
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("carData.txt"), true));// 创建对象输出流
			// 构建单个汽车对象
			System.out.println("请输入汽车的品牌：");
			String brand = sc.next();
			System.out.println("请输入汽车的颜色：");
			String color = sc.next();
			System.out.println("请输入汽车的车牌号：");
			String licensePlateNumber = sc.next();
			System.out.println("请输入汽车的进场时间：");
			Date date = new Date();
			String str = sc.next();
			// String str = "2019-04-30 00:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			Date inTime = sdf.parse(str);// 转换成Date的形式
			Car[] car = new Car[100];// 创建汽车类对象数组
			boolean flag = false;// 标志车是否可以停入
			int number = 0;// 标志存的数组下标
			for (int i = 0; i < car.length; i++) {
				if (car[i] == null) {// 如果还有空位则停入
					Car c = new Car();

					c.brand = brand;
					c.color = color;
					c.licensePlateNumber = licensePlateNumber;
					c.inTime = inTime;
					car[i] = c;
					flag = true;
					number = i;
					System.out.println("停车成功");
					break;
				}
				if (i == car.length - 1 && car[i] != null) {// 如果没有空位，则提示
					System.out.println("停车位已满");
					flag = false;
				}
			}
			// car[number + 1] = null;
			// 把汽车对象的信息写到carData.txt
			oos.writeObject(car[number]);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			oos.close();// 关闭输出流
		}

	}

	// 汽车出场
	public static void out(String licensePlateNumber) {
		File file = new File("carData.txt");
		ObjectInputStream ois = null;
		Date inTime = null;
		long time = 0;// 时间差
		Date outTime = new Date();// 以系统时间为出场时间

		try {
			ois = new ObjectInputStream(new FileInputStream(file));// 创建对象输入流
			boolean hasCar = false;//用于标记是否有要查找的车
			Car[] car = (Car[]) ois.readObject();// 将读入对象转化为Car[]类型
			// car[]的实际使用长度
			int count = 0;
			for (int i = 0; i < car.length; i++) {
				if (car[i] != null) {
					count++;
				} else {
					break;
				}
			}
			System.out.println(Arrays.toString(car));
			System.out.println(count);
			for (int i = 0; i <count; i++) {// 找相同的车牌号
				
					if (car[i].licensePlateNumber.equals(licensePlateNumber)) {
						inTime = car[i].inTime;// 找到进入时间
						System.out.println("已找到进入信息");
						System.out.println("进场时间为：" + inTime);
						hasCar = true;
						break;
				} 
			}
			if (!hasCar) {//如果找不到车
				System.out.println("查无此车");
			}
			if (hasCar) {//找到以后，计算价格
				time = (outTime.getTime() - inTime.getTime()) / 1000 / 60;// 时间差化为分钟
				// 计算价格
				if (time <= 30) {
					System.out.println("停车时间为：" + time + "分钟，免费停车");
				} else {
					if (time % 60 == 0) {
						System.out.println("停车时间为：" + time + "分钟，停车费为：" + (time / 60) * 3 + "元");
					} else {
						System.out.println("停车时间为：" + time + "分钟，停车费为：" + (time / 60 + 1) * 3 + "元");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();// 关闭对象输入流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException, ParseException {
		ParkTest pk = new ParkTest();
		pk.creatCartxt();
		pk.intoThePark();
		System.out.println("准备出停车场，请输入您的车牌号：");
		Scanner sc = new Scanner(System.in);
		String licensePlateNumber = sc.next();
		pk.out(licensePlateNumber);
	}
}
