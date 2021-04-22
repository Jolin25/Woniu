package com.woniu.tank.map;

import java.awt.event.KeyEvent;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.extra.Buff;
import com.woniu.tank.ui.GamePanel;
import com.woniu.tank.util.Music;

/**
 * Player�ࣺ�ҷ�̹��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Player extends Tank {

	public boolean underGrass = false;// ��־̹����û�о����ݣ�Ĭ��Ϊû��
	public boolean isDrawStar = false;//// ��־�Ƿ��Ѿ������˳���Ч��������
	public int StarStep = 0;// Ϊ�˻���������Ƶı�ʾ���Ƶ��˵ڼ���ͼ
	public int StarTimes =8;//�������ǻ滭ʱ��
	// ���췽��

	public Player(int x, int y, int dir) {
		super(x, y, dir);
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
	 * �ƶ���Ϊ�Ż�
	 */
	public void move(KeyEvent e) {
		int x = this.getX();
		int y = this.getY();
		int dir = this.getDir();
		int code = e.getKeyCode();// ��ȡ���¼��Ķ�Ӧ����
		switch (code) {
		case KeyEvent.VK_UP:// ����
			if (canMove(code)) {
				y--;
			}
			dir = 0;
			break;
		case KeyEvent.VK_DOWN:// ����
			if (canMove(code)) {
				y++;
			}
			dir = 2;
			break;
		case KeyEvent.VK_LEFT:// ����
			if (canMove(code)) {
				x--;
			}
			dir = 3;
			break;
		case KeyEvent.VK_RIGHT:// ����
			if (canMove(code)) {
				x++;
			}
			dir = 1;
			break;
		case KeyEvent.VK_SPACE:// ���ո񣬷����ӵ�
			this.attack();
			break;
		case KeyEvent.VK_A://��A���Զ������
			aaaKill();
			break;
		default:
			break;
		}
		this.setX(x);
		this.setY(y);
		this.setDir(dir);
		// �ƶ����ж���û�н���
		if (GamePanel.gameMap[this.getY()][this.getX()] == 3) {
			this.underGrass = true;
		} else {
			this.underGrass = false;
		}
		// �ƶ����ж���û�гԵ�buff
		for (int i = 0; i < GamePanel.buffs.size(); i++) {
			Buff buff = GamePanel.buffs.get(i);
			// �ж���û�гԵ�buff
			if (buff.getX() == this.getX() && buff.getY() == this.getY()) {
				// �жϳԵ���buff����һ��
				switch (buff.getType()) {
				case "pauseBuff":
					buff.buffEffects();// ���ø�buff����Ч
					// ����Ҫ��һ���Ե�buff����Ч
					break;
				default:
					break;
				}
				buff.setAlive(false);
			}
		}
		/*
		 * ״̬�������� ��������Ч�����ı��ݵ�����״̬
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
	 * �Զ������:����ǰ���е���
	 */
	public void aaaKill() {
		new Music("music/shoot2.wav").play();
		for(int i =0;i<GamePanel.npcs.size();i++) {//�������
			Npc npc = GamePanel.npcs.get(i);
			npc.setIsAlive(false);
		}
		for(int i = 0;i<GamePanel.bullets.size();i++) {//�����ӵ�
			Bullet bullet = GamePanel.bullets.get(i);
			bullet.setIsAlive(false);
		}
		GamePanel.aaakill=true;//���Ĵ����Ƿ���״̬
		GamePanel.killNpcNumber = GamePanel.untilnowNumber;//���Ļ�ɱ��Ŀ
		
		if(GamePanel.killNpcNumber==6) {//�����ɱ�����е��ˣ�������Ϸ״̬
			GamePanel.isWin=true;
		}
	}
	/*
	 * �ж���һ���Ƿ�����ƶ�
	 */
	public boolean canMove(int code) {
		Integer[][] gameMap = GamePanel.gameMap;
		boolean canMove = false;
		int x = this.getX();// ��ȡ��ǰλ�õĺ�������
		int y = this.getY();
		switch (code) {
		case KeyEvent.VK_UP:// ����

			if (y > 0) {
				int upLocation = gameMap[y - 1][x].intValue();
				if (upLocation == 0 || upLocation == 3) {// �����һ���ǲݻ��߿հ�������ƶ�
					canMove = true;

//					if (upLocation == 3) {// ����һ����λ�ô������ݷ��������ɴ���ʵ��
//						creatThroughGrass(x, --y, 0);
//					}

				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y - 1 == npc.getY() && x == npc.getX()) {// �����һ���ǵз�̹�ˣ������ƶ�
						canMove = false;
					}
				}

			}
			break;

		case KeyEvent.VK_DOWN:// ����
			if (y < gameMap.length - 1) {
				int downLocation = gameMap[y + 1][x].intValue();
				if (downLocation == 0 || downLocation == 3)
					canMove = true;
//				if (downLocation == 3) {
//					creatThroughGrass(x, ++y, 2);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y + 1 == npc.getY() && x == npc.getX()) {// �����һ���ǵз�̹�ˣ������ƶ�
						canMove = false;
					}
				}
			}

			break;
		case KeyEvent.VK_LEFT:// ����
			if (x > 0) {
				int leftLocation = gameMap[y][x - 1].intValue();
				if (leftLocation == 0 || leftLocation == 3)
					canMove = true;
//				if (leftLocation == 3) {
//					creatThroughGrass(--x, y, 3);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y  == npc.getY() && x -1== npc.getX()) {// �����һ���ǵз�̹�ˣ������ƶ�
						canMove = false;
					}
				}
			}
			break;
		case KeyEvent.VK_RIGHT:// ����
			if (x < gameMap[0].length - 1) {
				int rightLocation = gameMap[y][x + 1].intValue();
				if (rightLocation == 0 || rightLocation == 3)
					canMove = true;
//				if (rightLocation == 3) {
//					creatThroughGrass(++x, y, 1);
//				}
				for (int i = 0; i < GamePanel.npcs.size(); i++) {
					Npc npc = GamePanel.npcs.get(i);
					if (y  == npc.getY() && x+1 == npc.getX()) {// �����һ���ǵз�̹�ˣ������ƶ�
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
	 * �ƶ���Ϊ
	 */
	/*
	 * public void move(KeyEvent e) { int code = e.getKeyCode();// ��ȡ���¼��Ķ�Ӧ���� switch
	 * (code) { case KeyEvent.VK_UP:// ���� if (this.getY() != 0) {
	 * 
	 * Integer upLocation = TankMap.map.get(this.getY() - 1)[this.getX()];
	 * 
	 * // System.out.println("up:" + upLocation.intValue());
	 * 
	 * if (upLocation.intValue() == 0 || upLocation.intValue() == 3) {
	 * this.setY(this.getY() - 1); this.setDir(0); } else { this.setDir(0); }
	 * 
	 * } break; case KeyEvent.VK_DOWN:// ���� if (this.getY() != TankMap.first.length
	 * - 1) {
	 * 
	 * Integer downLocation = TankMap.map.get(this.getY() + 1)[this.getX()];
	 * 
	 * // System.out.println("down:" + downLocation.intValue());
	 * 
	 * if (downLocation.intValue() == 0 || downLocation.intValue() == 3) {
	 * this.setY(this.getY() + 1); this.setDir(2); } else { this.setDir(2); } }
	 * 
	 * break; case KeyEvent.VK_LEFT:// ���� if (this.getX() != 0) {
	 * 
	 * Integer leftLocation = TankMap.map.get(this.getY())[this.getX() - 1];
	 * 
	 * // System.out.println("left:" + leftLocation.intValue());
	 * 
	 * if (leftLocation.intValue() == 0 || leftLocation.intValue() == 3) {
	 * this.setX(this.getX() - 1); this.setDir(3); } else { this.setDir(3); } }
	 * break; case KeyEvent.VK_RIGHT:// ���� if (this.getX() < TankMap.first[0].length
	 * - 1) {
	 * 
	 * Integer rightLocation = TankMap.map.get(this.getY())[this.getX() + 1];
	 * 
	 * // System.out.println("right:" + rightLocation.intValue());
	 * 
	 * if (rightLocation.intValue() == 0 || rightLocation.intValue() == 3) {
	 * this.setX(this.getX() + 1); this.setDir(1); } else { this.setDir(1); }
	 * 
	 * } break; case KeyEvent.VK_SPACE:// ���ո񣬷����ӵ� this.attack(); break; default:
	 * break; } }
	 */
	/*
	 * ������Ϊ�������¿ո񣬼�����attack���������ݵ�ǰ�ҷ�̹�˵�λ�úͷ�������bulletʵ���ĳ�������; ������ǰ�ӵ�ʵ�����ӵ�������
	 */
	@Override
	public void attack() {
		new Music("music/shoot.wav").play();
		Bullet bullet = new Bullet(this.getX(), this.getY(), this.getDir(), 0);// 0�����ҷ�̹��
		GamePanel.bullets.add(bullet);
	}

	@Override
	public void move() {

	}

}