package com.woniu.tank.map;

/**
 * ״̬��������
 * 
 * ��Ҫ��ע������һ�����������࣬Դ������ʦδ��ǰ�Լ��ĸ��Ӵ��ݷ������������ĸ��������ڣ���ʵ����Ҫ����
���ϵģ���Ϊ���Լ򵥵��ڻ��Ƶ���˫��̹�˵ķ��������ж��ǻ��Լ����Ǵ�ݡ�
Ȼ����move�����м�⵱ǰλ���ǲ��ǲݾ����ˡ���˱�ǿ��ʹ�ü������˴���ʵ���Ĺ��̣����������ζ��
�߼�Ҫ����һ�ء�
�����ܽ᣺�����˵�ԭ������˼����Ⱦ���������ϣ��ҿ��ǵ����ٴ���Ⱦ���и��ǣ��൱���ֶ���һ����Ⱦ�ķ�����
���Ȼ�̹���ٻ���ݣ������ƶ���ɵ���ݣ�����ʦ���뷨���ڻ�ı��ͼ���������Ϊ��������Ǹ���Σ�
���Ǹ���Ⱦ������̹����Ⱦ����ѡ���Ƿ���ƴ�ݡ�

 * 
 * �����ࣺ����ʵ��̹�˴��ݵ�Ч�� ��̹�˵�move�������⵽��һ���Ǹ��ݣ������ɴ���ʵ������ӵ����ݼ����У�Ȼ���ڻ���������
 * ��Ⱦ�����������λ�ã�����Ⱦ̹�ˣ�����Ⱦ�ݡ� ���Բ���д���߳��ࡣ
 * ���ԣ������꣺int x�������꣺int y������int dir���ݱ�������Ҫ������Ϊ�˰���̹�˵Ļ��ƾͼ����ˣ�
 *isAlive����
 *
 * 
 * @author С���ӵ�С�ճ�
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
