package com.woniu.tank.ui;

/**
 * 画布类
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.bullet.BulletBoom;
import com.woniu.tank.extra.Blood;
import com.woniu.tank.extra.Buff;
import com.woniu.tank.extra.GameOver;
import com.woniu.tank.extra.PauseBuff;
import com.woniu.tank.map.Npc;
import com.woniu.tank.map.Player;
import com.woniu.tank.map.TankMap;
import com.woniu.tank.map.ThroughGrass;
import com.woniu.tank.util.ImageUtil;
import com.woniu.tank.util.Music;

//因为要不断的重新绘制地图，所以把该类做成线程，不断调用repaint方法
public class GamePanel extends JPanel implements Runnable {
	public static Integer[][] gameMap;// 当前地图
	public static Player player = null;// 只有一个玩家
	public static int untilnowNumber = 0;// 单局累计产生坦克的数量
	public static int killNpcNumber = 0;// 单局累计击杀敌方坦克的数量
	public static boolean aaakill = false;// 标志自定义大招是否开启
	public static boolean isWin = false;// 标志是否已经胜利
	int step = 0;// 用于设置坦克、水动的效果图
	public static Vector<Bullet> bullets = new Vector<Bullet>();// 子弹集合
	public static Vector<Npc> npcs = new Vector<Npc>();// 敌方坦克集合
	public static Vector<BulletBoom> bulletBooms = new Vector<BulletBoom>();// 子弹爆炸效果集合
	public static Vector<Buff> buffs = new Vector<Buff>();// buff集合
	public static Vector<Blood> bloods = new Vector<Blood>();// blood集合
	public static GameOver gameOverEffect = null;// 游戏结束效果
	// 遗弃的穿草集合
	// public static Vector<ThroughGrass> throughGrasses = new
	// Vector<ThroughGrass>();// 穿草效果集合

	public static boolean gameOver = false;// 标志游戏是否结束

	/**
	 * 构造方法：进行默认设置
	 */
	public GamePanel() {
		this.setSize(992, 672 + 29);// 画布的尺寸

		new Music("music/BGM.wav").play();// 播放开始音乐
		/*
		 * 创建一个我方坦克实例，设置出生位置为老王左边两位,以左上角的坐标作为x,y
		 */
		// 注意xy坐标和二维数组的行列是相反的哈

		player = new Player((TankMap.first[0].length / 2 - 2), (TankMap.first.length - 1), 0);

		/*
		 * 键盘事件监听
		 */
		// 是当前画布成为事件的焦点，类似鼠标确定选项框的作用，用于确定对哪个画布进行操作
		this.setFocusable(true);
		// 重写键盘监听方法
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				/*
				 * 当监听事件发生时，要执行的代码
				 */
				// e 保存了事件的相关信息
				player.move(e);// 我方坦克移动
			}
		});

		// 默认设置
		this.setBackground(Color.BLACK);// 设置背景颜色
		// 开启线程,在构造方法中构造，方便创建即开启
		new Thread(this).start();

	}

	/**
	 * 绘制画布（利用了画笔g（Graphics图像）） JPanel对象创建时，会调用一次绘制方法（paintComponent）
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// 注意，下面这个调用父类的绘制方法必须要保留
		super.paintComponent(g);
		// 把绘制地图的方法放在这里调用
		drawMap(g);
		drawPlayer(g);
		drawNpc(g);
		drawBullet(g);
		drawBulletBoom(g);
		// drawThroughGrass(g); 已弃用
		drawBuff(g);
		drawBlood(g);
		drawGameOver(g);
		drawAaaKill(g);
		drawWin(g);
	}

	/**
	 * 创建buff实例
	 */
	public void creatBuff() {
		if (buffs.size() < 1) {
			int type = (int) (Math.random() * 1) + 1;
			// buff的随机位置
			int x = (int) (Math.random() * gameMap[0].length);
			int y = (int) (Math.random() * gameMap.length);
			if (gameMap[y][x] == 0) {// 如果该随机位置上没有东西，则进创建
				switch (type) {
				case 1:// 产生pauseBuff
					Buff buff = new PauseBuff(x, y, "pauseBuff");
					buffs.add(buff);// 添加至集合
					break;
				default:
					break;

				}
			}
		}
	}

	/**
	 * 创建敌方坦克实例
	 */
	public static void createNpc() {
		/*
		 * 创建敌方坦克实例(像素为28*28)
		 */
		int npcBirth[] = { 0, TankMap.first[0].length / 2, TankMap.first[0].length - 1 };
		int limitNumber = 3;// 瞬间允许最大敌方坦克数量
		int maxNumber = 6;// 单局游戏总共可生成的坦克数量
		// 随机生成坦克
		while (npcs.size() < limitNumber && untilnowNumber < maxNumber) {
			Npc npc = new Npc(npcBirth[(int) (Math.random() * npcBirth.length)], 0, 2);
			npcs.add(npc);
			untilnowNumber++;
		}
	}

	/**
	 * 绘制地图
	 */
	public void drawMap(Graphics g) {
		gameMap = TankMap.randomMap;// 要绘制的地图数组
		// 利用画笔g来完成画布的绘制
		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[i].length; j++) {
				switch (gameMap[i][j].intValue()) {
				case 1:
					// 把源图片的某个区域画到画布的某个区域上
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 0, 0, 32, 32, this);
					break;
				case 2:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32, 0, 64, 32, this);
					break;
				case 3:// 草
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 64, 0, 96, 32, this);
					break;
				case 4:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * (3 + step), 0,
							32 * (4 + step), 32, this);
					break;
				case 5:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * (4 - step), 0,
							32 * (5 - step), 32, this);
					break;
				case 6:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * 5, 0, 32 * 6, 32,
							this);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * 绘制我方坦克:因为会不断的调用repaint方法来改变绘制的图案，故传入绘图的参数不能用固定的
	 * 
	 * @param g
	 */
	public void drawPlayer(Graphics g) {
		/*
		 * 32位像素移动
		 */
		if (player.underGrass) {// 如果是草，那么渲染草。可以直接这么放大图片的显示效果，不用单独搞一张更大的图片
			g.drawImage(ImageUtil.mapImage, player.getX() * 32 - 8, player.getY() * 32 - 8, player.getX() * 32 + 32 + 8,
					player.getY() * 32 + 32 + 8, 64, 0, 96, 32, this);
		} else if (!player.isDrawStar) {// 如果没有绘制星星，那么绘制星星
			g.drawImage(ImageUtil.starImage, player.getX() * 32, player.getY() * 32, player.getX() * 32 + 32,
					player.getY() * 32 + 32, (0 + player.StarStep) * 32, 0, (0 + player.StarStep) * 32 + 32, 32, this);
			player.StarStep++;
			player.StarTimes--;
			if (player.StarStep == 4) {// 星星只有四张图
				player.StarStep = 0;
			}
			if (player.StarTimes == 0) {
				player.isDrawStar = true;// 代表已经绘制了星星
			}
		} else {// 如果不是草则渲染坦克

			g.drawImage(ImageUtil.playerImage, player.getX() * 32, player.getY() * 32, player.getX() * 32 + 32,
					player.getY() * 32 + 32, (0 + step) * 32, player.getDir() * 32, (0 + step) * 32 + 32,
					player.getDir() * 32 + 32, this);
		}
		/*
		 * 4位像素移动：x y 坐标全部放大8倍
		 */

//		g.drawImage(ImageUtil.playerImage, player.getX() * 4, player.getY() * 4, player.getX() * 4 + 32,
//				player.getY() * 4 + 32, (0 + step) * 32, player.getDir() * 32, (0 + step) * 32 + 32,
//				player.getDir() * 32 + 32, this);

	}

	/**
	 * 绘制敌方坦克
	 */
	public void drawNpc(Graphics g) {
		createNpc();// 生成新的敌方坦克

		// 遍历集合
		for (int i = 0; i < GamePanel.npcs.size(); i++) {

			Npc npc = GamePanel.npcs.get(i);
			if (npc.underGrass) {// 如果在穿草，则绘制草
				g.drawImage(ImageUtil.mapImage, npc.getX() * 32 - 8, npc.getY() * 32 - 8, npc.getX() * 32 + 32 + 8,
						npc.getY() * 32 + 32 + 8, 64, 0, 96, 32, this);
			} else if (!npc.isDrawStar) {// 如果没有绘制星星，那么绘制星星
				g.drawImage(ImageUtil.starImage, npc.getX() * 32, npc.getY() * 32, npc.getX() * 32 + 32,
						npc.getY() * 32 + 32, (0 + npc.StarStep) * 32, 0, (0 + npc.StarStep) * 32 + 32, 32, this);
				npc.StarStep++;
				npc.StarTimes--;
				if (npc.StarStep == 4) {// 星星只有四张图
					npc.StarStep = 0;
				}
				if (npc.StarTimes == 0) {
					npc.isDrawStar = true;// 代表已经绘制了星星
				}
			} else {// 否则绘制坦克
				g.drawImage(ImageUtil.npcImage, npc.getX() * 32, npc.getY() * 32, npc.getX() * 32 + 32,
						npc.getY() * 32 + 32, step * 28, npc.getDir() * 28, (step + 1) * 28, npc.getDir() * 28 + 28,
						this);
			}
			// 如果敌方坦克不存在了，则从集合中删除
			if (!npc.isAlive()) {
				npcs.remove(npc);
			}
		}
	}

	/**
	 * 绘制子弹
	 */
	public void drawBullet(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			// 如果子弹不存活了，则从集合中删除该元素
			if (!bullet.getIsAlive()) {
				bullets.remove(bullet);
			}
			g.drawImage(ImageUtil.bulletImage, bullet.getX() * 32, bullet.getY() * 32, bullet.getX() * 32 + 32,
					bullet.getY() * 32 + 32, 0, 0, 28, 28, this);

		}
	}

	/**
	 * 绘制子弹爆炸效果
	 */
	int j = 0;// 用于表示该绘制爆照效果的哪一部分图

	public void drawBulletBoom(Graphics g) {
		for (int i = 0; i < bulletBooms.size(); i++) {
			BulletBoom bulletBoom = bulletBooms.get(i);

			if (j < 8) {// 总共8个部分
				g.drawImage(ImageUtil.boomImage, bulletBoom.getX() * 32, bulletBoom.getY() * 32,
						bulletBoom.getX() * 32 + 32, bulletBoom.getY() * 32 + 32, (0 + j) * 32, 0, (0 + j) * 32 + 32,
						32, this);
				j++;// 绘制了当前部分后，标志该绘制下一部分

			}
			if (j == 8) {
				bulletBoom.setAlive(false);// 其实目前来看不需要isAlive，不过。。作为统一
				j = 0;
			}
			if (!bulletBoom.isAlive())
				bulletBooms.remove(bulletBoom);
		}
	}

	/*
	 * 状态：已弃用 更改至坦克渲染处 绘制穿草效果:先绘制坦克，再绘制大草
	 */

	/*
	 * public void drawThroughGrass(Graphics g) { for (int i = 0; i <
	 * throughGrasses.size(); i++) { ThroughGrass throughGrass =
	 * throughGrasses.get(i); g.drawImage(ImageUtil.playerImage, throughGrass.getX()
	 * * 32, throughGrass.getY() * 32, throughGrass.getX() * 32 + 32,
	 * throughGrass.getY() * 32 + 32, (0 + step) * 32, throughGrass.getDir() * 32,
	 * (0 + step) * 32 + 32, throughGrass.getDir() * 32 + 32, this);
	 * g.drawImage(ImageUtil.throughGrassImage, throughGrass.getX() * 32 - 6,
	 * throughGrass.getY() * 32 - 6, throughGrass.getX() * 32 + 32 + 6,
	 * throughGrass.getY() * 32 + 32 + 6, 0, 0, 38, 38, this);
	 * 
	 * if (!throughGrass.isAlive()) {
	 * 
	 * throughGrasses.remove(throughGrass);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	/**
	 * 绘制buff
	 * 
	 * @param g
	 */
	public void drawBuff(Graphics g) {
		creatBuff();
		for (int i = 0; i < buffs.size(); i++) {
			Buff buff = buffs.get(0);
			if (buff.isAlive()) {// 当buff存活时才进行绘画
				String type = buff.getType();
				int x = buff.getX();
				int y = buff.getY();
				// 选择对应的buff进行渲染
				switch (type) {
				case "pauseBuff":
					g.drawImage(ImageUtil.buffImage, x * 32, y * 32, x * 32 + 32, y * 32 + 32, 32, 0, 32 + 32, 32,
							this);

					break;
				default:
					break;
				}
			}
			// 如果buff死亡，则移出集合
			if (!buff.isAlive()) {
				buffs.remove(buff);
			}
		}
	}

	/**
	 * 绘制出血效果
	 */
	public void drawBlood(Graphics g) {
		for (int i = 0; i < bloods.size(); i++) {
			Blood blood = bloods.get(i);
			if (blood.times > 0) {
				g.drawImage(ImageUtil.bloodImage, 0, 0, 992, 672, 0, 0, 500, 500, this);
				blood.times--;
			}
			if (blood.times <= 0) {
				bloods.remove(blood);
			}
		}

	}

	/**
	 * 绘制游戏结束效果图
	 */
	public void drawGameOver(Graphics g) {
		if (gameOverEffect != null) {
			g.drawImage(ImageUtil.gameOverImage, 0, 0, 992, 672, 0, 0, 256, 160, this);
			gameOverEffect = null;
		}
	}

	/**
	 * 绘制大招效果图
	 */
	int killStep = 0;

	public void drawAaaKill(Graphics g) {
		if (aaakill) {

			if (killStep == 0)
				g.drawImage(ImageUtil.aaaKillImage01, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 1)
				g.drawImage(ImageUtil.aaaKillImage02, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 2)
				g.drawImage(ImageUtil.aaaKillImage03, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 3)
				g.drawImage(ImageUtil.aaaKillImage04, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 4)
				g.drawImage(ImageUtil.aaaKillImage05, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 5)
				g.drawImage(ImageUtil.aaaKillImage06, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 6)
				g.drawImage(ImageUtil.aaaKillImage07, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 7)
				g.drawImage(ImageUtil.aaaKillImage08, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 8)
				g.drawImage(ImageUtil.aaaKillImage09, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 9)
				g.drawImage(ImageUtil.aaaKillImage10, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 10)
				g.drawImage(ImageUtil.aaaKillImage11, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 11)
				g.drawImage(ImageUtil.aaaKillImage12, 0, 0, 992, 672, 0, 0, 414, 328, this);
			killStep++;
		}
		if (killStep == 12) {
			killStep = 0;
			aaakill = false;
		}
	}

	/**
	 * 绘制胜利
	 */
	public void drawWin(Graphics g) {
		if (isWin) {
			g.drawImage(ImageUtil.wimImage, 0, 0, 992, 672, 0, 0, 256, 256, this);
			gameOver = true;// 游戏结束
		}
	}

	/**
	 * run方法
	 */
	@Override
	public void run() {
		// 不断调用repaint方法进行该画布的绘制
		while (!gameOver) {
			// 每100毫秒刷新一次
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			step++;
			if (step > 1) {// 当等于2的时候，就轮了一遍0和1了
				step = 0;
			}

			// 对该画布重新进行绘制
			this.repaint();

		}
		if (!isWin) {
			new Music("music/GAMEOVER.wav").play();
		}
	}
}
