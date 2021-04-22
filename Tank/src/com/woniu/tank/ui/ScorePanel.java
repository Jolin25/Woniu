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
 * �Ʒְ�
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class ScorePanel extends JPanel implements Runnable {
	int step = 0;// ����ͼÿ�θı�Ĳ���

	/**
	 * ���췽��������Ĭ������
	 */
	public ScorePanel() {
		this.setSize(300, 672 + 29);// �����ĳߴ�
		this.setLocation(992, 0);// ����λ��

		// Ĭ������
		this.setBackground(Color.red);// ���ñ�����ɫ
		// �����߳�,�ڹ��췽���й��죬���㴴��������
		new Thread(this).start();

	}

	@Override
	public void run() {
		// ���ϵ���repaint�������иû����Ļ���
		while (!GamePanel.gameOver) {
			// ÿ100����ˢ��һ��
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			step += 2;
			if (step >= 866) {
				step = 0;
			}
			// �Ըû������½��л���
			this.repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// ע�⣬����������ø���Ļ��Ʒ�������Ҫ����
		super.paintComponent(g);
		drawScoreMap(g);
		drawScore(g);
	}

	/**
	 * ���Ʊ����ֲ�ͼ
	 * 
	 * @param g
	 */
	private void drawScoreMap(Graphics g) {
		g.drawImage(ImageUtil.scoreImage, 0, 0, 300, 672 + 29, 0, 0 + step, 532, 700 + step, this);
	}

	/**
	 * ���Ƶ÷����
	 */
	public void drawScore(Graphics g) {
		// ��������
		g.setFont(new Font("����", Font.BOLD, 30));
		// ������ɫ
		g.setColor(Color.yellow);
		//����
		g.drawString("��ɱ�з�̹������:"+(GamePanel.killNpcNumber), 10, 100);
		g.drawString("ʣ��̹��������"+(6-GamePanel.killNpcNumber),10, 200);
		g.drawString("�÷�:"+(GamePanel.killNpcNumber*10), 10, 300);
	}

}
