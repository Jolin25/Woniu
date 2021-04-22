package com.woniu.tank.map;

import java.awt.event.KeyEvent;
import java.util.Calendar;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.extra.PauseBuff;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.ThreadPoolUtil;

/**
 * 敌方坦克
 * 
 * @author 小虫子的小日常
 *
 */
public class Npc extends Tank implements Runnable {
	public boolean isAlive = true;
	public boolean underGrass = false;
	public boolean isPauseed = false;// 标志是否被暂停
	public boolean isDrawStar = false;////标志是否已经绘制了出生效果：星星
	public int StarStep=0;//为了绘制星星设计的表示绘制到了第几张图
	public int StarTimes =8;//限制星星绘画时间
	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	int[] change = new int[4];// 改变方向几率
	/*
	 * 构造方法
	 */

	public Npc(int x, int y, int dir) {
		super(x, y, dir);
		// new Thread(this).start();
		// 把该任务添加到线程池中
		ThreadPoolUtil.npcPool.execute(this);

	}

	/*
	 * run方法
	 */
	@Override
	public void run() {
		while (this.isAlive()) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!this.isPauseed) {// 如果玩家没有吃到暂停buff，则运行
				this.move();
				this.attack();

			} else {
				pauseBuffOver();
			}
		}
	}

	/*
	 * 消除pauseBuff效果
	 */
	public void pauseBuffOver() {

		int nowTime = Calendar.getInstance().get(Calendar.SECOND);

		if (nowTime - PauseBuff.buffOn >= 5) {// 如果暂停时间超过5秒则消除该效果
			for (int i = 0; i < GamePanel.npcs.size(); i++) {
				Npc npc = GamePanel.npcs.get(i);
				npc.isPauseed = false;// 改变敌方坦克的暂停标志

			}
		}
	}

	/*
	 * 攻击行为:每次移动都有20%的几率发射子弹
	 */
	@Override
	public void attack() {
		if (Math.random() < 0.2) {
			Bullet bullet = new Bullet(getX(), getY(), getDir(), 1);// 1表示敌方坦克
			GamePanel.bullets.add(bullet);
		}
	}
	/*
	 * 状态：已弃用 生成穿草实例，并且添加进穿草集合
	 */

	/*
	 * public void creatThroughGrass(int x, int y, int dir) {
	 * 
	 * ThroughGrass throughGrass = new ThroughGrass(x, y, dir);
	 * GamePanel.throughGrasses.add(throughGrass);
	 * 
	 * }
	 */
	/*
	 * 移动行为优化版(只是把原来混在一起的判断条件什么的，抽成了方法)
	 */
	public void move() {
		// 单方向每走一次增加百分之5的几率改变方向或有0.1的几率改变行走方向或者当前方向不能走了则换方向前进
		if (Math.random() * 100 < change[this.getDir()] * 5 || Math.random() < 0.1
				|| (this.getY() <= 0 || this.getX() <= 0 || this.getX() >= GamePanel.gameMap[0].length - 1
						|| this.getY() >= GamePanel.gameMap.length - 1)) {
			int x = this.getX();
			int y = this.getY();
			int dir = this.getDir();
			// 随机移动
			int randomNumber = (int) (Math.random() * 4);
			switch (randomNumber) {
			case 0:// 向上
				if (canMove(randomNumber)) {
					y--;
				}
				dir = 0;
				break;
			case 2:// 向下
				if (canMove(randomNumber)) {
					y++;
				}
				dir = 2;
				break;
			case 3:// 向左
				if (canMove(randomNumber)) {
					x--;
				}
				dir = 3;
				break;
			case 1:// 向右
				if (canMove(randomNumber)) {
					x++;
				}
				dir = 1;
				break;

			default:
				break;
			}
			this.setX(x);
			this.setY(y);
			this.setDir(dir);
			// 判断是否穿草
			if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
				this.underGrass = true;
			} else {
				this.underGrass = false;
			}
		} else {// 否则继续原路径
			int x = this.getX();
			int y = this.getY();
			int dir = this.getDir();

			switch (dir) {
			case 0:// 上
				if (canMove(dir)) {
					y--;
				}
				dir = 0;
				break;

			case 1:// 右
			case KeyEvent.VK_RIGHT:// 向右
				if (canMove(dir)) {
					x++;
				}
				dir = 1;
				break;

			case 2:// 下
				if (canMove(dir)) {
					y++;
				}
				dir = 2;
				break;

			case 3:// 左
				if (canMove(dir)) {
					x--;
				}
				dir = 3;
				break;
			default:
				break;
			}
			// 状态：已弃用 处理穿草效果，改变大草的生死状态
			/*
			 * if (GamePanel.throughGrasses.size() != 0) {
			 * 
			 * ThroughGrass nowThroughGrass = GamePanel.throughGrasses.get(0); if
			 * (nowThroughGrass.getX() != this.getX() || nowThroughGrass.getY() !=
			 * this.getY()) {
			 * 
			 * nowThroughGrass.setAlive(false);
			 * 
			 * } }
			 */

			this.setX(x);
			this.setY(y);

			if (canMove(dir)) {
				change[dir]++;
			}
			// 判断是否穿草
			if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
				this.underGrass = true;
			} else {
				this.underGrass = false;
			}
		}

	}

	/*
	 * 移动行为：备注：脑残党忽然用了集合和数组混杂着去表示。。
	 */
	/*
	 * @Override public void move() { // 已经连续走10次了或有0.1的几率改变行走方向或者当前方向不能走了则换方向前进 if
	 * (Math.random() * 100 < change[this.getDir()] * 10 || Math.random() < 0.1 ||
	 * (this.getY() <= 0 || this.getX() <= 0 || this.getX() >=
	 * TankMap.first[0].length - 1 || this.getY() >= TankMap.first.length - 1)) { //
	 * 随机移动 int randomNumber = (int) (Math.random() * 4); switch (randomNumber) {
	 * case 0:// 向上
	 * 
	 * if (this.getY() != 0) {
	 * 
	 * Integer upLocation = TankMap.map.get(this.getY() - 1)[this.getX()];
	 * 
	 * // System.out.println("up:" + upLocation.intValue());
	 * 
	 * if (upLocation.intValue() == 0 || upLocation.intValue() == 3) {
	 * this.setY(this.getY() - 1); this.setDir(0); } else { this.setDir(0); }
	 * 
	 * } break; case 1:// 向右 if (this.getX() < TankMap.first[0].length - 1) {
	 * 
	 * Integer rightLocation = TankMap.map.get(this.getY())[this.getX() + 1];
	 * 
	 * // System.out.println("right:" + rightLocation.intValue());
	 * 
	 * if (rightLocation.intValue() == 0 || rightLocation.intValue() == 3) {
	 * this.setX(this.getX() + 1); this.setDir(1); } else { this.setDir(1); }
	 * 
	 * } break; case 2:// 向下 if (this.getY() != TankMap.first.length - 1) {
	 * 
	 * Integer downLocation = TankMap.map.get(this.getY() + 1)[this.getX()];
	 * 
	 * // System.out.println("down:" + downLocation.intValue());
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * this.setY(this.getY() + 1); this.setDir(2); } else { this.setDir(2); } }
	 * 
	 * break; case 3:// 向左 if (this.getX() != 0) {
	 * 
	 * Integer leftLocation = TankMap.map.get(this.getY())[this.getX() - 1];
	 * 
	 * // System.out.println("left:" + leftLocation.intValue());
	 * 
	 * if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * this.setX(this.getX() - 1); this.setDir(3); } else { this.setDir(3); } }
	 * break; default: break; } } else {// 否则继续原路径 switch (this.getDir()) { case
	 * 0:// 上 Integer upLocation = TankMap.map.get(this.getY() - 1)[this.getX()]; if
	 * (upLocation.intValue() == 0 || upLocation.intValue() == 3) {
	 * 
	 * this.setY(this.getY() - 1); this.change[this.getDir()] += 1;// 强制换方向几率增加 }
	 * 
	 * break; case 1:// 右 Integer rightLocation =
	 * TankMap.map.get(this.getY())[this.getX() + 1]; if (rightLocation.intValue()
	 * == 0 || rightLocation.intValue() == 3) {
	 * 
	 * this.setX(this.getX() + 1); this.change[this.getDir()] += 1;// 强制换方向几率增加 }
	 * break;
	 * 
	 * case 2:// 下 Integer downLocation = TankMap.map.get(this.getY() +
	 * 1)[this.getX()];
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * 
	 * this.setY(this.getY() + 1); this.change[this.getDir()] += 1;// 强制换方向几率增加 }
	 * break;
	 * 
	 * case 3:// 左 Integer leftLocation = TankMap.map.get(this.getY())[this.getX() -
	 * 1]; if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * 
	 * this.setX(this.getX() - 1); this.change[this.getDir()] += 1;// 强制换方向几率增加 }
	 * break; default: break; }
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	 * 判断下一步是否可以移动(判断了边界和障碍物)
	 */
	public boolean canMove(int dir) {
		Integer[][] gameMap = GamePanel.gameMap;
		boolean canMove = false;
		int x = this.getX();// 获取当前位置的横纵坐标
		int y = this.getY();
		Tank player = GamePanel.player;//获取我方坦克
		switch (dir) {
		case 0:// 向上

			if (y > 0) {
				int upLocation = gameMap[y - 1][x].intValue();
				if (upLocation == 0 || upLocation == 3) {
					canMove = true;
//					if (upLocation == 3) {// 把下一步的位置传给穿草方法，生成穿草实例
//						creatThroughGrass(x, --y, 0);
//					}
				}
				
					if (y - 1 == player.getY() && x == player.getX()) {// 如果下一步是我方坦克，则不能移动
						canMove = false;
					}
				
			}
			break;

		case 2:// 向下
			if (y < gameMap.length - 1) {
				int downLocation = gameMap[y + 1][x].intValue();
				if (downLocation == 0 || downLocation == 3)
					canMove = true;
//				if (downLocation == 3) {// 把下一步的位置传给穿草方法，生成穿草实例
//					creatThroughGrass(x, ++y, 0);
//				}
				if (y +1 == player.getY() && x == player.getX()) {// 如果下一步是我方坦克，则不能移动
					canMove = false;
				}
			}
			break;
		case 3:// 向左
			if (x > 0) {
				int leftLocation = gameMap[y][x - 1].intValue();
				if (leftLocation == 0 || leftLocation == 3)
					canMove = true;
//				if (leftLocation == 3) {// 把下一步的位置传给穿草方法，生成穿草实例
//					creatThroughGrass(--x, y, 0);
//				}
				if (y  == player.getY() && x-1 == player.getX()) {// 如果下一步是我方坦克，则不能移动
					canMove = false;
				}
			}
			break;
		case 1:// 向右
			if (x < gameMap[0].length - 1) {
				int rightLocation = gameMap[y][x + 1].intValue();
				if (rightLocation == 0 || rightLocation == 3)
					canMove = true;
//				if (rightLocation == 3) {// 把下一步的位置传给穿草方法，生成穿草实例
//					creatThroughGrass(++x, --y, 0);
//				}
				if (y == player.getY() && x+1 == player.getX()) {// 如果下一步是我方坦克，则不能移动
					canMove = false;
				}
			}
			break;
		default:
			break;
		}
		return canMove;
	}

}
