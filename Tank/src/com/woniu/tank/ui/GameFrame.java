package com.woniu.tank.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import com.woniu.tank.map.TankMap;
import com.woniu.tank.util.Music;

public class GameFrame extends JFrame {
	public GameFrame() {

		// ���û��������Ĭ������
		/*
		 * ��һ�֣�����JFrame��ͨ��ϸ��΢�����ҵ��ʺϵĿ��
		 */
		// 6��29��ϸ��΢��
		this.setSize(992 +300+ 6, 672 + 29);// ���ô�С��31������21����ScorePanel��300
		// ��ȡ���ߣ�F��
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		// ��Ļ�ߴ�(F)
		Dimension screenSize = defaultToolkit.getScreenSize();
		// ����Ĭ������λ��(F)
		this.setLocation((int) (screenSize.getWidth() - 992 - 6-300) / 2, (int) (screenSize.getHeight() - 672 - 29) / 2);
		
		// this.setLocation(400, 100);//����Ĭ������λ��
		this.setTitle("̹�˴�ս");// ����������
		this.setResizable(false);// �������ʱ����Ե�����С
		this.setLayout(null);// ȡ����ǰ�����Ĳ��֣�F��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���õ���رհ�ťʵ�ֽ�������
		// ��һ��JPanelʵ��(һ������) �൱�������ڻ��������ϵĻ���ͨ����������չʾ
		// this.setContentPane(new GamePanel());
		
		// �����ڲ㻭�壬��ȡ�������л���������һ�����(F)
		this.getContentPane().add(new GamePanel());
		this.getContentPane().add(new ScorePanel());
		/*
		 * �ڶ��֣�ͨ��ֱ������JPanel�Ŀ�ߣ�����JFrame�Զ���ӱ������Ŀ��
		 */
//		this.getContentPane().setPreferredSize(new Dimension(992, 672));
//		this.pack();
		this.setVisible(true);// ����Frame�Ƿ�ɼ��������÷�����󣬹淶
	}

	public static void main(String[] args) throws IOException {

		new GameFrame();
		TankMap.upload(TankMap.randomMap);
	}
}
