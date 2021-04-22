package com.woniu.tank.map;

import java.awt.event.KeyEvent;
import java.util.Calendar;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.extra.PauseBuff;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.ThreadPoolUtil;

/**
 * �з�̹��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Npc extends Tank implements Runnable {
	public boolean isAlive = true;
	public boolean underGrass = false;
	public boolean isPauseed = false;// ��־�Ƿ���ͣ
	public boolean isDrawStar = false;////��־�Ƿ��Ѿ������˳���Ч��������
	public int StarStep=0;//Ϊ�˻���������Ƶı�ʾ���Ƶ��˵ڼ���ͼ
	public int StarTimes =8;//�������ǻ滭ʱ��
	public boolean isAlive() {
		return isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	int[] change = new int[4];// �ı䷽����
	/*
	 * ���췽��
	 */

	public Npc(int x, int y, int dir) {
		super(x, y, dir);
		// new Thread(this).start();
		// �Ѹ��������ӵ��̳߳���
		ThreadPoolUtil.npcPool.execute(this);

	}

	/*
	 * run����
	 */
	@Override
	public void run() {
		while (this.isAlive()) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!this.isPauseed) {// ������û�гԵ���ͣbuff��������
				this.move();
				this.attack();

			} else {
				pauseBuffOver();
			}
		}
	}

	/*
	 * ����pauseBuffЧ��
	 */
	public void pauseBuffOver() {

		int nowTime = Calendar.getInstance().get(Calendar.SECOND);

		if (nowTime - PauseBuff.buffOn >= 5) {// �����ͣʱ�䳬��5����������Ч��
			for (int i = 0; i < GamePanel.npcs.size(); i++) {
				Npc npc = GamePanel.npcs.get(i);
				npc.isPauseed = false;// �ı�з�̹�˵���ͣ��־

			}
		}
	}

	/*
	 * ������Ϊ:ÿ���ƶ�����20%�ļ��ʷ����ӵ�
	 */
	@Override
	public void attack() {
		if (Math.random() < 0.2) {
			Bullet bullet = new Bullet(getX(), getY(), getDir(), 1);// 1��ʾ�з�̹��
			GamePanel.bullets.add(bullet);
		}
	}
	/*
	 * ״̬�������� ���ɴ���ʵ�����������ӽ����ݼ���
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
	 * �ƶ���Ϊ�Ż���(ֻ�ǰ�ԭ������һ����ж�����ʲô�ģ�����˷���)
	 */
	public void move() {
		// ������ÿ��һ�����Ӱٷ�֮5�ļ��ʸı䷽�����0.1�ļ��ʸı����߷�����ߵ�ǰ�����������򻻷���ǰ��
		if (Math.random() * 100 < change[this.getDir()] * 5 || Math.random() < 0.1
				|| (this.getY() <= 0 || this.getX() <= 0 || this.getX() >= GamePanel.gameMap[0].length - 1
						|| this.getY() >= GamePanel.gameMap.length - 1)) {
			int x = this.getX();
			int y = this.getY();
			int dir = this.getDir();
			// ����ƶ�
			int randomNumber = (int) (Math.random() * 4);
			switch (randomNumber) {
			case 0:// ����
				if (canMove(randomNumber)) {
					y--;
				}
				dir = 0;
				break;
			case 2:// ����
				if (canMove(randomNumber)) {
					y++;
				}
				dir = 2;
				break;
			case 3:// ����
				if (canMove(randomNumber)) {
					x--;
				}
				dir = 3;
				break;
			case 1:// ����
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
			// �ж��Ƿ񴩲�
			if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
				this.underGrass = true;
			} else {
				this.underGrass = false;
			}
		} else {// �������ԭ·��
			int x = this.getX();
			int y = this.getY();
			int dir = this.getDir();

			switch (dir) {
			case 0:// ��
				if (canMove(dir)) {
					y--;
				}
				dir = 0;
				break;

			case 1:// ��
			case KeyEvent.VK_RIGHT:// ����
				if (canMove(dir)) {
					x++;
				}
				dir = 1;
				break;

			case 2:// ��
				if (canMove(dir)) {
					y++;
				}
				dir = 2;
				break;

			case 3:// ��
				if (canMove(dir)) {
					x--;
				}
				dir = 3;
				break;
			default:
				break;
			}
			// ״̬�������� ��������Ч�����ı��ݵ�����״̬
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
			// �ж��Ƿ񴩲�
			if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
				this.underGrass = true;
			} else {
				this.underGrass = false;
			}
		}

	}

	/*
	 * �ƶ���Ϊ����ע���Բе���Ȼ���˼��Ϻ����������ȥ��ʾ����
	 */
	/*
	 * @Override public void move() { // �Ѿ�������10���˻���0.1�ļ��ʸı����߷�����ߵ�ǰ�����������򻻷���ǰ�� if
	 * (Math.random() * 100 < change[this.getDir()] * 10 || Math.random() < 0.1 ||
	 * (this.getY() <= 0 || this.getX() <= 0 || this.getX() >=
	 * TankMap.first[0].length - 1 || this.getY() >= TankMap.first.length - 1)) { //
	 * ����ƶ� int randomNumber = (int) (Math.random() * 4); switch (randomNumber) {
	 * case 0:// ����
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
	 * } break; case 1:// ���� if (this.getX() < TankMap.first[0].length - 1) {
	 * 
	 * Integer rightLocation = TankMap.map.get(this.getY())[this.getX() + 1];
	 * 
	 * // System.out.println("right:" + rightLocation.intValue());
	 * 
	 * if (rightLocation.intValue() == 0 || rightLocation.intValue() == 3) {
	 * this.setX(this.getX() + 1); this.setDir(1); } else { this.setDir(1); }
	 * 
	 * } break; case 2:// ���� if (this.getY() != TankMap.first.length - 1) {
	 * 
	 * Integer downLocation = TankMap.map.get(this.getY() + 1)[this.getX()];
	 * 
	 * // System.out.println("down:" + downLocation.intValue());
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * this.setY(this.getY() + 1); this.setDir(2); } else { this.setDir(2); } }
	 * 
	 * break; case 3:// ���� if (this.getX() != 0) {
	 * 
	 * Integer leftLocation = TankMap.map.get(this.getY())[this.getX() - 1];
	 * 
	 * // System.out.println("left:" + leftLocation.intValue());
	 * 
	 * if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * this.setX(this.getX() - 1); this.setDir(3); } else { this.setDir(3); } }
	 * break; default: break; } } else {// �������ԭ·�� switch (this.getDir()) { case
	 * 0:// �� Integer upLocation = TankMap.map.get(this.getY() - 1)[this.getX()]; if
	 * (upLocation.intValue() == 0 || upLocation.intValue() == 3) {
	 * 
	 * this.setY(this.getY() - 1); this.change[this.getDir()] += 1;// ǿ�ƻ����������� }
	 * 
	 * break; case 1:// �� Integer rightLocation =
	 * TankMap.map.get(this.getY())[this.getX() + 1]; if (rightLocation.intValue()
	 * == 0 || rightLocation.intValue() == 3) {
	 * 
	 * this.setX(this.getX() + 1); this.change[this.getDir()] += 1;// ǿ�ƻ����������� }
	 * break;
	 * 
	 * case 2:// �� Integer downLocation = TankMap.map.get(this.getY() +
	 * 1)[this.getX()];
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * 
	 * this.setY(this.getY() + 1); this.change[this.getDir()] += 1;// ǿ�ƻ����������� }
	 * break;
	 * 
	 * case 3:// �� Integer leftLocation = TankMap.map.get(this.getY())[this.getX() -
	 * 1]; if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * 
	 * this.setX(this.getX() - 1); this.change[this.getDir()] += 1;// ǿ�ƻ����������� }
	 * break; default: break; }
	 * 
	 * }
	 * 
	 * }
	 */
	/*
	 * �ж���һ���Ƿ�����ƶ�(�ж��˱߽���ϰ���)
	 */
	public boolean canMove(int dir) {
		Integer[][] gameMap = GamePanel.gameMap;
		boolean canMove = false;
		int x = this.getX();// ��ȡ��ǰλ�õĺ�������
		int y = this.getY();
		Tank player = GamePanel.player;//��ȡ�ҷ�̹��
		switch (dir) {
		case 0:// ����

			if (y > 0) {
				int upLocation = gameMap[y - 1][x].intValue();
				if (upLocation == 0 || upLocation == 3) {
					canMove = true;
//					if (upLocation == 3) {// ����һ����λ�ô������ݷ��������ɴ���ʵ��
//						creatThroughGrass(x, --y, 0);
//					}
				}
				
					if (y - 1 == player.getY() && x == player.getX()) {// �����һ�����ҷ�̹�ˣ������ƶ�
						canMove = false;
					}
				
			}
			break;

		case 2:// ����
			if (y < gameMap.length - 1) {
				int downLocation = gameMap[y + 1][x].intValue();
				if (downLocation == 0 || downLocation == 3)
					canMove = true;
//				if (downLocation == 3) {// ����һ����λ�ô������ݷ��������ɴ���ʵ��
//					creatThroughGrass(x, ++y, 0);
//				}
				if (y +1 == player.getY() && x == player.getX()) {// �����һ�����ҷ�̹�ˣ������ƶ�
					canMove = false;
				}
			}
			break;
		case 3:// ����
			if (x > 0) {
				int leftLocation = gameMap[y][x - 1].intValue();
				if (leftLocation == 0 || leftLocation == 3)
					canMove = true;
//				if (leftLocation == 3) {// ����һ����λ�ô������ݷ��������ɴ���ʵ��
//					creatThroughGrass(--x, y, 0);
//				}
				if (y  == player.getY() && x-1 == player.getX()) {// �����һ�����ҷ�̹�ˣ������ƶ�
					canMove = false;
				}
			}
			break;
		case 1:// ����
			if (x < gameMap[0].length - 1) {
				int rightLocation = gameMap[y][x + 1].intValue();
				if (rightLocation == 0 || rightLocation == 3)
					canMove = true;
//				if (rightLocation == 3) {// ����һ����λ�ô������ݷ��������ɴ���ʵ��
//					creatThroughGrass(++x, --y, 0);
//				}
				if (y == player.getY() && x+1 == player.getX()) {// �����һ�����ҷ�̹�ˣ������ƶ�
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