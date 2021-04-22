package com.woniu.tank.bullet;

/**
 * 子弹爆炸效果类： 不用写成线程类，因为爆照效果不用连续做什么处理。当即产生当即画完图后就销毁。
 * 当子弹类的boom方法中有碰撞事件发生时，生成一个BulletBoom对象，添加到boom集合中， 在画布类里面被绘画了以后就删除掉，
 * 属性：横坐标：int x；纵坐标：int y。(x,y来自于子弹类实例碰撞时的位置)
 * 不需要方向，因为原地爆炸。爆照类型：int type。
 * 
 * @author 小虫子的小日常
 *
 */
public class BulletBoom {
	private int x;
	private int y;
	private int type;// 后期拿来做不一样的爆炸效果
	private boolean isAlive = true;// 可有可无吧

	public BulletBoom(int x, int y) {
		this.x = x;
		this.y = y;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isAlive() {// 原来自动生成布尔型的getter方法是不写get的！
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
