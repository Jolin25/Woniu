package com.woniu.tank.bullet;

import com.woniu.tank.extra.Blood;
import com.woniu.tank.extra.GameOver;
import com.woniu.tank.map.Npc;
import com.woniu.tank.map.TankMap;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.Music;
import com.woniu.tank.util.ThreadPoolUtil;

/**
 * ���ʰ�飺Ϊʲô�ӵ�Ҫ������һ�����أ������Է���map��� �ӵ��ࣺͳһ����player���ӵ���npc���ӵ� 1.���ԣ�λ�����꣺int x,int y
 * ����int dir ���ͣ�int type 2.��Ϊ��move(),boom()
 * ��Player���в�����Bulletʵ����������bulletes�������Ժ󣬴�GamePanel���е�bulletes���ϻ�õ�ǰ����
 * �ӵ�ʵ�����Դ˲��Ͻ����ƶ���Ϊ�ͱ�ը��Ϊ�����ã��Ӷ�ΪGamePanel���repaint�����ṩ���ĵ㡣
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Bullet implements Runnable {
	private int x;// ������
	private int y;// ������
	private int dir;// ����
	private int type;// ���ͣ�0Ϊ�ҷ��ӵ� 1Ϊ�ط�̹��
	private boolean isAlive = true;// ��־�ӵ��Ƿ���
	/*
	 * ���췽��
	 */

	public Bullet(int x, int y, int dir, int type) {

		this.x = x;
		this.y = y;
		this.dir = dir;
		this.type = type;
		// new Thread(this).start();// �����߳�
		// �Ѹ�������ӵ��̳߳���
		ThreadPoolUtil.bulletPool.execute(this);
	}

	/*
	 * run����
	 */
	@Override
	public  void run() {
		while (isAlive) {
			try {
				Thread.sleep(100);// �����ߵĻ��������Ȼ������CPU�ж�����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.move();
			this.boom(TankMap.randomMap);
		}
	}
	/*
	 * �ƶ���Ϊ����������
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
		// �ж��ӵ��Ƿ��Ѿ�Խ��
		if (x < 0 || y < 0 || x > TankMap.first[0].length - 1 || y > TankMap.first.length - 1) {
			isAlive = false;

		}
	}

	/*
	 * ���ɱ�ըЧ�������������Ч������
	 */
	public void creatBulletBoom() {
		BulletBoom bulletBoom = new BulletBoom(x, y);
		GamePanel.bulletBooms.add(bulletBoom);
	}

	/*
	 * ���ɳ�Ѫʵ�����������Ѫ����
	 */
	public void creatBlood() {
		Blood blood = new Blood();
		blood.times = 5;
		GamePanel.bloods.add(blood);
	}

	/*
	 * ��ը��Ϊ���ѵ�ͼ���鴫�������жϵ�ǰλ����ʲô
	 */
	public void boom(Integer randomMap[][]) {
		if (y < randomMap.length && x < randomMap[0].length && y >= 0 && x >= 0) {
			int nowLocation = randomMap[y][x].intValue();// ��ʾ��ǰλ�õ�ֵ
			if (nowLocation == 1) {// ľ��
				if (this.type == 0)
					new Music("music/boom.wav").play();
				randomMap[y][x] = 0;
				isAlive = false;
				creatBulletBoom();
			}
			if (nowLocation == 2) {// ����
				if (this.type == 0)
					new Music("music/boom.wav").play();
				isAlive = false;
			}
			if (nowLocation == 6) {// ����

				GamePanel.gameOver = true;
				randomMap[y][x] = 0;
				creatBulletBoom();
			}
			// �����ҷ�̹��
			if (this.type == 1 && GamePanel.player.getX() == x && GamePanel.player.getY() == y) {

				creatBulletBoom();
				GamePanel.gameOverEffect = new GameOver();
				GamePanel.gameOver = true;
			}
			// ���ез�̹��
			for (int i = 0; i < GamePanel.npcs.size(); i++) {
				Npc npc = GamePanel.npcs.get(i);
				if (this.type == 0 && npc.getX() == x && npc.getY() == y) {
					new Music("music/shoot2.wav").play();
					npc.setIsAlive(false);
					this.isAlive = false;// �ӵ���
					creatBulletBoom();
					creatBlood();
					GamePanel.killNpcNumber++;
					if(GamePanel.killNpcNumber==6) {//�����ɱ�����е��ˣ�������Ϸ״̬
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
