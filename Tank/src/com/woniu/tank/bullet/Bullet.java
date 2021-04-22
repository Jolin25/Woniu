package com.woniu.tank.bullet;

import com.woniu.tank.extra.Blood;
import com.woniu.tank.extra.GameOver;
import com.woniu.tank.map.Npc;
import com.woniu.tank.map.TankMap;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.Music;
import com.woniu.tank.util.ThreadPoolUtil;

/**
 * 疑问版块：为什么子弹要单独建一个包呢？不可以放在map包里？ 子弹类：统一管理player的子弹和npc的子弹 1.属性：位置坐标：int x,int y
 * 方向：int dir 类型：int type 2.行为：move(),boom()
 * 当Player类中产生了Bullet实例并保存在bulletes集合中以后，从GamePanel类中的bulletes集合获得当前各个
 * 子弹实例，以此不断进行移动行为和爆炸行为的设置，从而为GamePanel类的repaint方法提供更改点。
 * 
 * @author 小虫子的小日常
 *
 */
public class Bullet implements Runnable {
	private int x;// 横坐标
	private int y;// 纵坐标
	private int dir;// 方向
	private int type;// 类型：0为我方子弹 1为地方坦克
	private boolean isAlive = true;// 标志子弹是否健在
	/*
	 * 构造方法
	 */

	public Bullet(int x, int y, int dir, int type) {

		this.x = x;
		this.y = y;
		this.dir = dir;
		this.type = type;
		// new Thread(this).start();// 开启线程
		// 把该任务添加到线程池中
		ThreadPoolUtil.bulletPool.execute(this);
	}

	/*
	 * run方法
	 */
	@Override
	public  void run() {
		while (isAlive) {
			try {
				Thread.sleep(100);// 不休眠的话。。风扇会告诉你CPU有多辛苦
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.move();
			this.boom(TankMap.randomMap);
		}
	}
	/*
	 * 移动行为：上右下左
	 */

	public void move() {
		switch (dir) {
		case 0:
			y--;
			break;
		case 1:
			x++;
			break;
		case 2:
			y++;
			break;
		case 3:
			x--;
			break;
		default:
			break;

		}
		// 判断子弹是否已经越界
		if (x < 0 || y < 0 || x > TankMap.first[0].length - 1 || y > TankMap.first.length - 1) {
			isAlive = false;

		}
	}

	/*
	 * 生成爆炸效果并添加至爆照效果集合
	 */
	public void creatBulletBoom() {
		BulletBoom bulletBoom = new BulletBoom(x, y);
		GamePanel.bulletBooms.add(bulletBoom);
	}

	/*
	 * 生成出血实例并添加至出血集合
	 */
	public void creatBlood() {
		Blood blood = new Blood();
		blood.times = 5;
		GamePanel.bloods.add(blood);
	}

	/*
	 * 爆炸行为：把地图数组传进来，判断当前位置是什么
	 */
	public void boom(Integer randomMap[][]) {
		if (y < randomMap.length && x < randomMap[0].length && y >= 0 && x >= 0) {
			int nowLocation = randomMap[y][x].intValue();// 表示当前位置的值
			if (nowLocation == 1) {// 木块
				if (this.type == 0)
					new Music("music/boom.wav").play();
				randomMap[y][x] = 0;
				isAlive = false;
				creatBulletBoom();
			}
			if (nowLocation == 2) {// 铁块
				if (this.type == 0)
					new Music("music/boom.wav").play();
				isAlive = false;
			}
			if (nowLocation == 6) {// 老王

				GamePanel.gameOver = true;
				randomMap[y][x] = 0;
				creatBulletBoom();
			}
			// 打中我方坦克
			if (this.type == 1 && GamePanel.player.getX() == x && GamePanel.player.getY() == y) {

				creatBulletBoom();
				GamePanel.gameOverEffect = new GameOver();
				GamePanel.gameOver = true;
			}
			// 打中敌方坦克
			for (int i = 0; i < GamePanel.npcs.size(); i++) {
				Npc npc = GamePanel.npcs.get(i);
				if (this.type == 0 && npc.getX() == x && npc.getY() == y) {
					new Music("music/shoot2.wav").play();
					npc.setIsAlive(false);
					this.isAlive = false;// 子弹的
					creatBulletBoom();
					creatBlood();
					GamePanel.killNpcNumber++;
					if(GamePanel.killNpcNumber==6) {//如果击杀完所有敌人，跟改游戏状态
						GamePanel.isWin=true;
					}
				}
			}

		}
	}

	/*
	 * setter,getter
	 */
	public boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}
