package com.woniu.tank.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.woniu.tank.map.Player;
import com.woniu.tank.map.TankMap;
import com.woniu.tank.util.ImageUtil;
import com.woniu.tank.util.Music;

/**
 * 计分板
 * 
 * @author 小虫子的小日常
 *
 */
public class ScorePanel extends JPanel implements Runnable {
	int step = 0;// 背景图每次改变的步进

	/**
	 * 构造方法：进行默认设置
	 */
	public ScorePanel() {
		this.setSize(300, 672 + 29);// 画布的尺寸
		this.setLocation(992, 0);// 画布位置

		// 默认设置
		this.setBackground(Color.red);// 设置背景颜色
		// 开启线程,在构造方法中构造，方便创建即开启
		new Thread(this).start();

	}

	@Override
	public void run() {
		// 不断调用repaint方法进行该画布的绘制
		while (!GamePanel.gameOver) {
			// 每100毫秒刷新一次
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			step += 2;
			if (step >= 866) {
				step = 0;
			}
			// 对该画布重新进行绘制
			this.repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// 注意，下面这个调用父类的绘制方法必须要保留
		super.paintComponent(g);
		drawScoreMap(g);
		drawScore(g);
	}

	/**
	 * 绘制背景轮播图
	 * 
	 * @param g
	 */
	private void drawScoreMap(Graphics g) {
		g.drawImage(ImageUtil.scoreImage, 0, 0, 300, 672 + 29, 0, 0 + step, 532, 700 + step, this);
	}

	/**
	 * 绘制得分情况
	 */
	public void drawScore(Graphics g) {
		// 设置字体
		g.setFont(new Font("黑体", Font.BOLD, 30));
		// 设置颜色
		g.setColor(Color.yellow);
		//绘制
		g.drawString("击杀敌方坦克数量:"+(GamePanel.killNpcNumber), 10, 100);
		g.drawString("剩余坦克数量："+(6-GamePanel.killNpcNumber),10, 200);
		g.drawString("得分:"+(GamePanel.killNpcNumber*10), 10, 300);
	}

}
