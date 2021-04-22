package com.woniu.tank.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

import com.woniu.tank.map.TankMap;
import com.woniu.tank.util.Music;

public class GameFrame extends JFrame {
	public GameFrame() {

		// 对用户界面进行默认设置
		/*
		 * 第一种：设置JFrame，通过细节微调来找到适合的宽高
		 */
		// 6和29是细节微调
		this.setSize(992 +300+ 6, 672 + 29);// 设置大小宽31个，高21个。ScorePanel宽300
		// 获取工具（F）
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		// 屏幕尺寸(F)
		Dimension screenSize = defaultToolkit.getScreenSize();
		// 设置默认所处位置(F)
		this.setLocation((int) (screenSize.getWidth() - 992 - 6-300) / 2, (int) (screenSize.getHeight() - 672 - 29) / 2);
		
		// this.setLocation(400, 100);//设置默认所处位置
		this.setTitle("坦克大战");// 设置面板标题
		this.setResizable(false);// 设置面板时候可以调整大小
		this.setLayout(null);// 取消当前容器的布局（F）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置点击关闭按钮实现结束程序
		// 绑定一个JPanel实例(一个画布) 相当于我们在画布对象上的绘制通过该面板进行展示
		// this.setContentPane(new GamePanel());
		
		// 设置内层画板，获取父类所有画板对象，添加一个组件(F)
		this.getContentPane().add(new GamePanel());
		this.getContentPane().add(new ScorePanel());
		/*
		 * 第二种：通过直接设置JPanel的宽高，来让JFrame自动添加标题栏的宽高
		 */
//		this.getContentPane().setPreferredSize(new Dimension(992, 672));
//		this.pack();
		this.setVisible(true);// 设置Frame是否可见，这句最好放在最后，规范
	}

	public static void main(String[] args) throws IOException {

		new GameFrame();
		TankMap.upload(TankMap.randomMap);
	}
}
