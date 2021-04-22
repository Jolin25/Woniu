package com.woniu.tank.map;

import java.awt.event.KeyEvent;

/**
 * Tank�࣬��Ϊ�����࣬���ҷ�̹�˺�̹��NPC�ĸ���
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public abstract class Tank {
	// ����
	private int x;
	private int y;
	private int dir;// ���� 0���� 1���� 2���� 3���󣬸���ԴͼƬ���õ���ֵ��Ϊ�˺�����̵ķ���
	private boolean isDrawStar=false;//��־�Ƿ��Ѿ�����������
	// ��Ϊ

	public abstract void move();

	public abstract void attack();

	// ���췽����Ϊ�˷�������ȥ�̳й��췽��
	public Tank(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Tank() {

	}
	// ����Ϊpublic �������������ĵ���
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

	public boolean isDrawStar() {
		return isDrawStar;
	}

	public void setDrawStar(boolean isDrawStar) {
		this.isDrawStar = isDrawStar;
	}

	

	


}
