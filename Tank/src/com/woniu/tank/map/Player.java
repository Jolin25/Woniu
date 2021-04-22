package com.woniu.tank.map;

import java.awt.event.KeyEvent;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.extra.Buff;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.Music;

/**
 * Player类：我方坦克
 * 
 * @author 小虫子的小日常
 *
 */
public class Player extends Tank {

	public boolean underGrass = false;// 标志坦克有没有经过草，默认为没有
	public boolean isDrawStar = false;//// 标志是否已经绘制了出生效果：星星
	public int StarStep = 0;// 为了绘制星星设计的表示绘制到了第几张图
	public int StarTimes =8;//限制星星绘画时间
	// 构造方法

	public Player(int x, int y, int dir) {
		super(x, y, dir);
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
	 * 移动行为优化
	 */
	public void move(KeyEvent e) {
		int x = this.getX();
		int y = this.getY();
		int dir = this.getDir();
		int code = e.getKeyCode();// 获取按下键的对应键码
		switch (code) {
		case KeyEvent.VK_UP:// 向上
			if (canMove(code)) {
				y--;
			}
			dir = 0;
			break;
		case KeyEvent.VK_DOWN:// 向下
			if (canMove(code)) {
				y++;
			}
			dir = 2;
			break;
		case KeyEvent.VK_LEFT:// 向左
			if (canMove(code)) {
				x--;
			}
			dir = 3;
			break;
		case KeyEvent.VK_RIGHT:// 向右
			if (canMove(code)) {
				x++;
			}
			dir = 1;
			break;
		case KeyEvent.VK_SPACE:// 按空格，发射子弹
			this.attack();
			break;
		case KeyEvent.VK_A://按A，自定义大招
			aaaKill();
			break;
		default:
			break;
		}
		this.setX(x);
		this.setY(y);
		this.setDir(dir);
		// 移动后，判断有没有进草
		if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
			this.underGrass = true;
		} else {
			this.underGrass = false;
		}
		// 移动后，判断有没有吃到buff
		for (int i = 0; i < GamePanel.buffs.size(); i++) {
			Buff buff = GamePanel.buffs.get(i);
			// 判断有没有吃到buff
			if (buff.getX() == this.getX() && buff.getY() == this.getY()) {
				// 判断吃到的buff是哪一种
				switch (buff.getType()) {
				case "pauseBuff":
					buff.buffEffects();// 调用该buff的特效
					// 这里要放一个吃到buff的音效
					break;
				default:
					break;
				}
				buff.setAlive(false);
			}
		}
		/*
		 * 状态：已弃用 处理穿草效果，改变大草的生死状态
		 */
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
	}
	/*
	 * 自定义大招:歼灭当前所有敌人
	 */
	public void aaaKill() {
		new Music("music/shoot2.wav").play();
		for(int i =0;i<GamePanel.npcs.size();i++) {//歼灭敌人
			Npc npc = GamePanel.npcs.get(i);
			npc.setIsAlive(false);
		}
		for(int i = 0;i<GamePanel.bullets.size();i++) {//歼灭子弹
			Bullet bullet = GamePanel.bullets.get(i);
			bullet.setIsAlive(false);
		}
		GamePanel.aaakill=true;//跟改大招是否开启状态
		GamePanel.killNpcNumber = GamePanel.untilnowNumber;//跟改击杀数目
		
		if(GamePanel.killNpcNumber==6) {//如果击杀完所有敌人，跟改游戏状态
			GamePanel.isWin=true;
		}
	}
	/*
	 * 判断下一步是否可以移动
	 */
	public boolean canMove(int code) {
		Integer[][] gameMap = GamePanel.gameMap;
		boolean canMove = false;
		int x = this.getX();// 获取当前位置的横纵坐标
		int y = this.getY();
		switch (code) {
		case KeyEvent.VK_UP:// 向上

			if (y > 0) {
				int upLocation = gameMap[y - 1][x].intValue();
				if (upLocation == 0 || upLocation == 3) {// 如果下一步是草或者空白则可以移动
					canMove = true;

//					if (upLocation == 3) {// 把下一步的位置传给穿草方法，生成穿草实例
//						creatThroughGrass(x, --y, 0);
//					}

				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y - 1 == npc.getY() && x == npc.getX()) {// 如果下一步是敌方坦克，则不能移动
						canMove = false;
					}
				}

			}
			break;

		case KeyEvent.VK_DOWN:// 向下
			if (y < gameMap.length - 1) {
				int downLocation = gameMap[y + 1][x].intValue();
				if (downLocation == 0 || downLocation == 3)
					canMove = true;
//				if (downLocation == 3) {
//					creatThroughGrass(x, ++y, 2);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y + 1 == npc.getY() && x == npc.getX()) {// 如果下一步是敌方坦克，则不能移动
						canMove = false;
					}
				}
			}

			break;
		case KeyEvent.VK_LEFT:// 向左
			if (x > 0) {
				int leftLocation = gameMap[y][x - 1].intValue();
				if (leftLocation == 0 || leftLocation == 3)
					canMove = true;
//				if (leftLocation == 3) {
//					creatThroughGrass(--x, y, 3);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y  == npc.getY() && x -1== npc.getX()) {// 如果下一步是敌方坦克，则不能移动
						canMove = false;
					}
				}
			}
			break;
		case KeyEvent.VK_RIGHT:// 向右
			if (x < gameMap[0].length - 1) {
				int rightLocation = gameMap[y][x + 1].intValue();
				if (rightLocation == 0 || rightLocation == 3)
					canMove = true;
//				if (rightLocation == 3) {
//					creatThroughGrass(++x, y, 1);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y  == npc.getY() && x+1 == npc.getX()) {// 如果下一步是敌方坦克，则不能移动
						canMove = false;
					}
				}
			}
			break;
		default:
			break;
		}
		return canMove;
	}

	/*
	 * 移动行为
	 */
	/*
	 * public void move(KeyEvent e) { int code = e.getKeyCode();// 获取按下键的对应键码 switch
	 * (code) { case KeyEvent.VK_UP:// 向上 if (this.getY() != 0) {
	 * 
	 * Integer upLocation = TankMap.map.get(this.getY() - 1)[this.getX()];
	 * 
	 * // System.out.println("up:" + upLocation.intValue());
	 * 
	 * if (upLocation.intValue() == 0 || upLocation.intValue() == 3) {
	 * this.setY(this.getY() - 1); this.setDir(0); } else { this.setDir(0); }
	 * 
	 * } break; case KeyEvent.VK_DOWN:// 向下 if (this.getY() != TankMap.first.length
	 * - 1) {
	 * 
	 * Integer downLocation = TankMap.map.get(this.getY() + 1)[this.getX()];
	 * 
	 * // System.out.println("down:" + downLocation.intValue());
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * this.setY(this.getY() + 1); this.setDir(2); } else { this.setDir(2); } }
	 * 
	 * break; case KeyEvent.VK_LEFT:// 向左 if (this.getX() != 0) {
	 * 
	 * Integer leftLocation = TankMap.map.get(this.getY())[this.getX() - 1];
	 * 
	 * // System.out.println("left:" + leftLocation.intValue());
	 * 
	 * if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * this.setX(this.getX() - 1); this.setDir(3); } else { this.setDir(3); } }
	 * break; case KeyEvent.VK_RIGHT:// 向右 if (this.getX() < TankMap.first[0].length
	 * - 1) {
	 * 
	 * Integer rightLocation = TankMap.map.get(this.getY())[this.getX() + 1];
	 * 
	 * // System.out.println("right:" + rightLocation.intValue());
	 * 
	 * if (rightLocation.intValue() == 0 || rightLocation.intValue() == 3) {
	 * this.setX(this.getX() + 1); this.setDir(1); } else { this.setDir(1); }
	 * 
	 * } break; case KeyEvent.VK_SPACE:// 按空格，发射子弹 this.attack(); break; default:
	 * break; } }
	 */
	/*
	 * 攻击行为：当按下空格，即调用attack方法，根据当前我方坦克的位置和方向设置bullet实例的初试属性; 并将当前子弹实例添加到集合中
	 */
	@Override
	public void attack() {
		new Music("music/shoot.wav").play();
		Bullet bullet = new Bullet(this.getX(), this.getY(), this.getDir(), 0);// 0代表我方坦克
		GamePanel.bullets.add(bullet);
	}

	@Override
	public void move() {

	}

}
