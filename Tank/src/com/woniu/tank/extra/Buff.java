package com.woniu.tank.extra;
/**
 * ���Ϊ������
 * ֻ���ҷ����ԳԵ�buffŶ
 * ���������Ϊbuff���࣬Ȼ�����buffȥ�̳и��࣬��д������--->��һ����
 * buff�ࣺ���ԣ������꣺int x  �������꣺int y  �����״̬��boolean isAlive�����ͣ� int type
 * 		     ��Ϊ�����ݲ�ͬ�����ͣ��в�ͬ������
 * @author С���ӵ�С�ճ�
 *
 */
public abstract class Buff {
	private int x ;//������
	private int y;//������
	private String type;//��û�п��Ǻ���ô�ã���������Ϊ��ǲ�ͬ��buff
	private boolean isAlive=true;//���״̬
	/*
	 * ���췽��
	 */
	public Buff(int x, int y, String type) {
		
		this.x = x;
		this.y = y;
		this.type = type;
	}
	/*
	 * ��Ϊ
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
