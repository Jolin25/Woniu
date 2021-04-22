package com.woniu.tank.map;

import java.awt.event.KeyEvent;

/**
 * Tank类，作为抽象类，是我方坦克和坦克NPC的父类
 * 
 * @author 小虫子的小日常
 *
 */
public abstract class Tank {
	// 属性
	private int x;
	private int y;
	private int dir;// 方向 0：上 1：右 2：下 3：左，根据源图片设置的数值，为了后续编程的方便
	private boolean isDrawStar=false;//标志是否已经绘制了星星
	// 行为

	public abstract void move();

	public abstract void attack();

	// 构造方法，为了方便子类去继承构造方法
	public Tank(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Tank() {

	}
	// 设置为public ，方便其他包的调用
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
