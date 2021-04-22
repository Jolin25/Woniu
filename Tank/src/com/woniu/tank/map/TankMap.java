package com.woniu.tank.map;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ̹�˵�ͼ
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class TankMap {
	// ��ʱfirst���鼰first�ļ����������ͼ
	public static Integer[][] first = new Integer[21][31];
	// second������������ĵ�ͼ�����浵������
	public static Integer[][] second = new Integer[21][31];

	// ��ʱrandomMap���鼰randomMap�ļ����������ͼ��������ʱ�ǵ�һ�������������Ͷ�ȡ�ļ��ġ�����
	public static Integer[][] randomMap = new Integer[21][31];
	//��ͼ�ļ���
	static ArrayList<Integer[]> map ;
	static {
		try {
			getfirst();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getsecond();
		try {
			getMap(new File("TankMap/randomMap.txt"));// ��ȡ��һ�ε�ͼ
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * �������ͼд���ļ�
	 */
	public static void upload(Integer[][]map) throws IOException {
		File file = new File("TankMap/randomMap.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				bw.write(map[i][j].toString());
				bw.write(" ");
			}
			bw.write("\r\n");
			bw.flush();
		}
		bw.close();
	}

	/*
	 * ��ȡ��ͼ�ļ���first���ֶ���ͼ�Ĺ���
	 */
	public static void getfirst() throws IOException {
		ArrayList<Integer[]> map = new ArrayList<Integer[]>();
		File file = new File("TankMap/first.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		int lineNumber = 0;
		while (str != null) {
			String[] strs = str.split(" ");
			Integer[] line = new Integer[31];
			for (int i = 0; i < strs.length; i++) {
				line[i] = Integer.valueOf(strs[i]);
			}
			map.add(lineNumber++, line);
			str = br.readLine();
		}
		first = map.toArray(new Integer[21][31]);
	}

	/*
	 * ֱ������һ�������ͼ����
	 */
	public static void getsecond() {
		for (int i = 0; i < second.length; i++) {
			for (int j = 0; j < second[i].length; j++) {
				int randomNumber = (int) (Math.random() * 100);// 0-99
				if (randomNumber < 20) {// ľ����ּ���20%
					second[i][j] = 1;
				} else if (randomNumber < 25) {// �ֿ���ּ���5%
					second[i][j] = 2;
				} else if (randomNumber < 35) {// �ݳ��ֵļ���10%
					second[i][j] = 3;
				} else if (randomNumber < 40) {// ˮ���ּ��ʷֱ�Ϊ2.5%
					if (Math.random() < 0.5) {
						second[i][j] = 4;
					} else {
						second[i][j] = 5;
					}
				}else {
					second[i][j] = 0;//�����ǿհ�
				}

			}
		}
		// ����������λ�ã�������Χ��һȦľ��
		for (int i = second[0].length / 2 - 1; i < second[0].length / 2 + 2; i++) {
			second[second.length - 2][i] = 1;
		}
		second[second.length - 1][second[0].length / 2] = 6;
		second[second.length - 1][second[0].length / 2 - 1] = 1;
		second[second.length - 1][second[0].length / 2 + 1] = 1;
		randomMap = second;// �����ɵ������ͼ��ֵ��randomMap������

	}

	/*
	 * ��ָ���ļ��ж�ȡ��ͼ���飬�ȷ���ArrayList�����У��ٷ���randomMap������
	 */
	public static void getMap(File file) throws IOException {
		map = new ArrayList<Integer[]>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		int lineNumber = 0;
		while (str != null) {
			String[] strs = str.split(" ");
			Integer[] line = new Integer[31];//ÿһ�з�����һ��һά������
			for (int i = 0; i < strs.length; i++) {
				line[i] = Integer.valueOf(strs[i]);
			}
			map.add(lineNumber++, line);
			str = br.readLine();
		}
		randomMap = map.toArray(new Integer[21][31]);
	}

}
