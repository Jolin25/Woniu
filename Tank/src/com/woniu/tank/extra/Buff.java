package com.woniu.tank.extra;
/**
 * 设计为数据类
 * 只有我方可以吃到buff哦
 * ？考虑设计为buff父类，然后各种buff去继承该类，重写方法？--->试一下先
 * buff类：属性：横坐标：int x  ；纵坐标：int y  ；存活状态：boolean isAlive；类型： int type
 * 		     行为：根据不同的类型，有不同的内容
 * @author 小虫子的小日常
 *
 */
public abstract class Buff {
	private int x ;//横坐标
	private int y;//纵坐标
	private String type;//还没有考虑好怎么用，姑且先作为标记不同的buff
	private boolean isAlive=true;//存活状态
	/*
	 * 构造方法
	 */
	public Buff(int x, int y, String type) {
		
		this.x = x;
		this.y = y;
		this.type = type;
	}
	/*
	 * 行为
	 */
	public abstract void buffEffects();
	/*
	 * getter,setter
	 */
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	
}
