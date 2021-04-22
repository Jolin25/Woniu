package com.woniu.tank.map;

/**
 * 状态：被遗弃
 * 
 * 重要备注：这是一个被遗弃的类，源自于老师未讲前自己的复杂穿草方法。唔，方法的复杂性在于，其实不需要集合
集合的，因为可以简单的在绘制敌我双方坦克的方法里面判断是画自己还是大草。
然后在move方法中检测当前位置是不是草就行了。因此比强行使用集合少了创建实例的过程：这个过程意味着
逻辑要复杂一截。
经验总结：复杂了的原因是在思考渲染的这个层次上，我考虑的是再次渲染进行覆盖（相当于又多了一个渲染的方法）
：先画坦克再画大草，再在移动后干掉大草，而老师的想法是在会改变地图（可以理解为最基础的那个层次）
的那个渲染处，即坦克渲染处，选择是否绘制大草。

 * 
 * 穿草类：用于实现坦克穿草的效果 当坦克的move方法里检测到下一步是个草，就生成穿草实例，添加到穿草集合中，然后在画布类里面
 * 渲染出来。在这个位置，先渲染坦克，再渲染草。 可以不用写成线程类。
 * 属性：横坐标：int x；纵坐标：int y；方向：int dir（草本来不需要，但是为了帮助坦克的绘制就加上了）
 *isAlive属性
 *
 * 
 * @author 小虫子的小日常
 *
 */
public class ThroughGrass {
	private int x;
	private int y;
	private int dir;
	private boolean isAlive = true;
	public ThroughGrass(int x, int y, int dir) {
		
		this.x = x;
		this.y = y;
		this.dir = dir;
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
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
}
