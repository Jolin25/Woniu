package com.woniu.tank.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 用于源图片的加载处理
 * 
 * @author 小虫子的小日常
 *
 */
public class ImageUtil {
	/**
	 * 新建多个Image对象
	 */
	public static Image mapImage;
	public static Image playerImage;
	public static Image npcImage;
	public static Image bulletImage;
	public static Image boomImage;
	//public static Image throughGrassImage;
	public static Image buffImage;
	public static Image starImage;
	public static Image bloodImage;
	public static Image gameOverImage;
	public static Image scoreImage;
	public static Image aaaKillImage01;
	public static Image aaaKillImage02;
	public static Image aaaKillImage03;
	public static Image aaaKillImage04;
	public static Image aaaKillImage05;
	public static Image aaaKillImage06;
	public static Image aaaKillImage07;
	public static Image aaaKillImage08;
	public static Image aaaKillImage09;
	public static Image aaaKillImage10;
	public static Image aaaKillImage11;
	public static Image aaaKillImage12;
	public static Image wimImage;
	/**
	 * 利用Image对象把源图片读取到程序中
	 */
	static {
		try {
			mapImage = ImageIO.read(new File("imgs/icon.bmp"));//32*32
			playerImage = ImageIO.read(new File("imgs/player1.bmp"));//32*32
			npcImage = ImageIO.read(new File("imgs/player2.bmp"));//28*28
			bulletImage = ImageIO.read(new File("imgs/boom1.bmp"));//28*28
			boomImage = ImageIO.read(new File("imgs/boom.png"));//32*32
		//	throughGrassImage = ImageIO.read(new File("imgs/throughGrass.bmp"));//38*38
			buffImage = ImageIO.read(new File("imgs/buff.bmp"));//32*32
			starImage = ImageIO.read(new File("imgs/star.bmp"));//32*32
			bloodImage = ImageIO.read(new File("image/blood.png"));//500*500
			gameOverImage = ImageIO.read(new File("imgs/gameover.bmp"));//256*160
			scoreImage  = ImageIO.read(new File("imgs/flymap.jpg"));//532*1566
			aaaKillImage01 = ImageIO.read(new File("Img/Boom03_0.png"));
			aaaKillImage02 = ImageIO.read(new File("Img/Boom03_1.png"));
			aaaKillImage03 = ImageIO.read(new File("Img/Boom03_2.png"));
			aaaKillImage04 = ImageIO.read(new File("Img/Boom03_3.png"));
			aaaKillImage05 = ImageIO.read(new File("Img/Boom03_4.png"));
			aaaKillImage06 = ImageIO.read(new File("Img/Boom03_5.png"));
			aaaKillImage07 = ImageIO.read(new File("Img/Boom03_6.png"));
			aaaKillImage08 = ImageIO.read(new File("Img/Boom03_7.png"));
			aaaKillImage09 = ImageIO.read(new File("Img/Boom03_8.png"));
			aaaKillImage10 = ImageIO.read(new File("Img/Boom03_9.png"));
			aaaKillImage11 = ImageIO.read(new File("Img/Boom03_10.png"));
			aaaKillImage12 = ImageIO.read(new File("Img/Boom03_11.png"));
			wimImage = ImageIO.read(new File("Img/shengli.png"));//256*256
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
