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
 * 2��ͣ�����н����ͳ����Ĺ���
1)����ʱ�����ü���¼��ķ�ʽ��¼��������Ʒ�ơ���ɫ�����ƺš���Ʒ�ơ���ɫ�����ƺţ�
			�Լ�����ʱ��д��car.txt�ļ��С�
2)����ʱ������¼�복�ƺţ�ȥ�ļ��в��Ҹó��Ľ���ʱ�䣬������ͣ��ʱ�䡣
3)30��������ѣ�����ÿСʱ3Ԫ������һСʱ��һСʱ���㡣
������
	1.public void in (){}
		car.txt��������:String brand;String color;String licensePlateNumber;Date inTime
	  	ObjectOutputStream{
	  		sc.next
	  	}
	  	Car[] c ��car��ʵ��serializable��
	2.public void out(String licensePlateNumber){}
		��Car[]���ң��ҵ���Ѷ�ӦԪ�ص�InTime�����Date outTime - InTime  ��ȷ����
	3.���㡣��
 */

public class ParkTest {
	// �����ļ���
	public static void creatCartxt() {
		File file = new File("carData.txt");
		try {
			file.createNewFile();// ����carData.txt�ļ���
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ¼���������
	public static void intoThePark() throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		// �ö���������ѳ�����Ϣ���뵽carData.txt
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("carData.txt"), true));// �������������
			// ����������������
			System.out.println("������������Ʒ�ƣ�");
			String brand = sc.next();
			System.out.println("��������������ɫ��");
			String color = sc.next();
			System.out.println("�����������ĳ��ƺţ�");
			String licensePlateNumber = sc.next();
			System.out.println("�����������Ľ���ʱ�䣺");
			Date date = new Date();
			String str = sc.next();
			// String str = "2019-04-30 00:00:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
			Date inTime = sdf.parse(str);// ת����Date����ʽ
			Car[] car = new Car[100];// �����������������
			boolean flag = false;// ��־���Ƿ����ͣ��
			int number = 0;// ��־��������±�
			for (int i = 0; i < car.length; i++) {
				if (car[i] == null) {// ������п�λ��ͣ��
					Car c = new Car();

					c.brand = brand;
					c.color = color;
					c.licensePlateNumber = licensePlateNumber;
					c.inTime = inTime;
					car[i] = c;
					flag = true;
					number = i;
					System.out.println("ͣ���ɹ�");
					break;
				}
				if (i == car.length - 1 && car[i] != null) {// ���û�п�λ������ʾ
					System.out.println("ͣ��λ����");
					flag = false;
				}
			}
			// car[number + 1] = null;
			// �������������Ϣд��carData.txt
			oos.writeObject(car[number]);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			oos.close();// �ر������
		}

	}

	// ��������
	public static void out(String licensePlateNumber) {
		File file = new File("carData.txt");
		ObjectInputStream ois = null;
		Date inTime = null;
		long time = 0;// ʱ���
		Date outTime = new Date();// ��ϵͳʱ��Ϊ����ʱ��

		try {
			ois = new ObjectInputStream(new FileInputStream(file));// ��������������
			boolean hasCar = false;//���ڱ���Ƿ���Ҫ���ҵĳ�
			Car[] car = (Car[]) ois.readObject();// ���������ת��ΪCar[]����
			// car[]��ʵ��ʹ�ó���
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
			for (int i = 0; i <count; i++) {// ����ͬ�ĳ��ƺ�
				
					if (car[i].licensePlateNumber.equals(licensePlateNumber)) {
						inTime = car[i].inTime;// �ҵ�����ʱ��
						System.out.println("���ҵ�������Ϣ");
						System.out.println("����ʱ��Ϊ��" + inTime);
						hasCar = true;
						break;
				} 
			}
			if (!hasCar) {//����Ҳ�����
				System.out.println("���޴˳�");
			}
			if (hasCar) {//�ҵ��Ժ󣬼���۸�
				time = (outTime.getTime() - inTime.getTime()) / 1000 / 60;// ʱ��Ϊ����
				// ����۸�
				if (time <= 30) {
					System.out.println("ͣ��ʱ��Ϊ��" + time + "���ӣ����ͣ��");
				} else {
					if (time % 60 == 0) {
						System.out.println("ͣ��ʱ��Ϊ��" + time + "���ӣ�ͣ����Ϊ��" + (time / 60) * 3 + "Ԫ");
					} else {
						System.out.println("ͣ��ʱ��Ϊ��" + time + "���ӣ�ͣ����Ϊ��" + (time / 60 + 1) * 3 + "Ԫ");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();// �رն���������
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException, ParseException {
		ParkTest pk = new ParkTest();
		pk.creatCartxt();
		pk.intoThePark();
		System.out.println("׼����ͣ���������������ĳ��ƺţ�");
		Scanner sc = new Scanner(System.in);
		String licensePlateNumber = sc.next();
		pk.out(licensePlateNumber);
	}
}
