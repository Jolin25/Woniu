package com.woniu.tank.bullet;

/**
 * �ӵ���ըЧ���ࣺ ����д���߳��࣬��Ϊ����Ч������������ʲô��������������������ͼ������١�
 * ���ӵ����boom����������ײ�¼�����ʱ������һ��BulletBoom������ӵ�boom�����У� �ڻ��������汻�滭���Ժ��ɾ������
 * ���ԣ������꣺int x�������꣺int y��(x,y�������ӵ���ʵ����ײʱ��λ��)
 * ����Ҫ������Ϊԭ�ر�ը���������ͣ�int type��
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class BulletBoom {
	private int x;
	private int y;
	private int type;// ������������һ���ı�ըЧ��
	private boolean isAlive = true;// ���п��ް�

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

	public boolean isAlive() {// ԭ���Զ����ɲ����͵�getter�����ǲ�дget�ģ�
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}
