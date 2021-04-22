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
 * 坦克地图
 * 
 * @author 小虫子的小日常
 *
 */
public class TankMap {
	// 暂时first数组及first文件代表给定地图
	public static Integer[][] first = new Integer[21][31];
	// second代表随机出来的地图，不存档的那种
	public static Integer[][] second = new Integer[21][31];

	// 暂时randomMap数组及randomMap文件代表随机地图（唔。。暂时是第一次用随机，后面就读取文件的。。）
	public static Integer[][] randomMap = new Integer[21][31];
	//地图的集合
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
			getMap(new File("TankMap/randomMap.txt"));// 获取上一次地图
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 把随机地图写入文件
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
	 * 读取地图文件（first是手动绘图的哈）
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
	 * 直接生成一个随机地图数组
	 */
	public static void getsecond() {
		for (int i = 0; i < second.length; i++) {
			for (int j = 0; j < second[i].length; j++) {
				int randomNumber = (int) (Math.random() * 100);// 0-99
				if (randomNumber < 20) {// 木块出现几率20%
					second[i][j] = 1;
				} else if (randomNumber < 25) {// 钢块出现几率5%
					second[i][j] = 2;
				} else if (randomNumber < 35) {// 草出现的几率10%
					second[i][j] = 3;
				} else if (randomNumber < 40) {// 水出现几率分别为2.5%
					if (Math.random() < 0.5) {
						second[i][j] = 4;
					} else {
						second[i][j] = 5;
					}
				}else {
					second[i][j] = 0;//其余是空白
				}

			}
		}
		// 设置老王的位置，还有周围的一圈木块
		for (int i = second[0].length / 2 - 1; i < second[0].length / 2 + 2; i++) {
			second[second.length - 2][i] = 1;
		}
		second[second.length - 1][second[0].length / 2] = 6;
		second[second.length - 1][second[0].length / 2 - 1] = 1;
		second[second.length - 1][second[0].length / 2 + 1] = 1;
		randomMap = second;// 让生成的随机地图赋值到randomMap数组上

	}

	/*
	 * 从指定文件中读取地图数组，先放在ArrayList集合中，再放在randomMap数组中
	 */
	public static void getMap(File file) throws IOException {
		map = new ArrayList<Integer[]>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		int lineNumber = 0;
		while (str != null) {
			String[] strs = str.split(" ");
			Integer[] line = new Integer[31];//每一行放在了一个一维数组中
			for (int i = 0; i < strs.length; i++) {
				line[i] = Integer.valueOf(strs[i]);
			}
			map.add(lineNumber++, line);
			str = br.readLine();
		}
		randomMap = map.toArray(new Integer[21][31]);
	}

}
