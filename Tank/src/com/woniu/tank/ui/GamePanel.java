package com.woniu.tank.ui;

/**
 * ������
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.woniu.tank.bullet.Bullet;
import com.woniu.tank.bullet.BulletBoom;
import com.woniu.tank.extra.Blood;
import com.woniu.tank.extra.Buff;
import com.woniu.tank.extra.GameOver;
import com.woniu.tank.extra.PauseBuff;
import com.woniu.tank.map.Npc;
import com.woniu.tank.map.Player;
import com.woniu.tank.map.TankMap;
import com.woniu.tank.map.ThroughGrass;
import com.woniu.tank.util.ImageUtil;
import com.woniu.tank.util.Music;

//��ΪҪ���ϵ����»��Ƶ�ͼ�����԰Ѹ��������̣߳����ϵ���repaint����
public class GamePanel extends JPanel implements Runnable {
	public static Integer[][] gameMap;// ��ǰ��ͼ
	public static Player player = null;// ֻ��һ�����
	public static int untilnowNumber = 0;// �����ۼƲ���̹�˵�����
	public static int killNpcNumber = 0;// �����ۼƻ�ɱ�з�̹�˵�����
	public static boolean aaakill = false;// ��־�Զ�������Ƿ���
	public static boolean isWin = false;// ��־�Ƿ��Ѿ�ʤ��
	int step = 0;// ��������̹�ˡ�ˮ����Ч��ͼ
	public static Vector<Bullet> bullets = new Vector<Bullet>();// �ӵ�����
	public static Vector<Npc> npcs = new Vector<Npc>();// �з�̹�˼���
	public static Vector<BulletBoom> bulletBooms = new Vector<BulletBoom>();// �ӵ���ըЧ������
	public static Vector<Buff> buffs = new Vector<Buff>();// buff����
	public static Vector<Blood> bloods = new Vector<Blood>();// blood����
	public static GameOver gameOverEffect = null;// ��Ϸ����Ч��
	// �����Ĵ��ݼ���
	// public static Vector<ThroughGrass> throughGrasses = new
	// Vector<ThroughGrass>();// ����Ч������

	public static boolean gameOver = false;// ��־��Ϸ�Ƿ����

	/**
	 * ���췽��������Ĭ������
	 */
	public GamePanel() {
		this.setSize(992, 672 + 29);// �����ĳߴ�

		new Music("music/BGM.wav").play();// ���ſ�ʼ����
		/*
		 * ����һ���ҷ�̹��ʵ�������ó���λ��Ϊ���������λ,�����Ͻǵ�������Ϊx,y
		 */
		// ע��xy����Ͷ�ά������������෴�Ĺ�

		player = new Player((TankMap.first[0].length / 2 - 2), (TankMap.first.length - 1), 0);

		/*
		 * �����¼�����
		 */
		// �ǵ�ǰ������Ϊ�¼��Ľ��㣬�������ȷ��ѡ�������ã�����ȷ�����ĸ��������в���
		this.setFocusable(true);
		// ��д���̼�������
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				/*
				 * �������¼�����ʱ��Ҫִ�еĴ���
				 */
				// e �������¼��������Ϣ
				player.move(e);// �ҷ�̹���ƶ�
			}
		});

		// Ĭ������
		this.setBackground(Color.BLACK);// ���ñ�����ɫ
		// �����߳�,�ڹ��췽���й��죬���㴴��������
		new Thread(this).start();

	}

	/**
	 * ���ƻ����������˻���g��Graphicsͼ�񣩣� JPanel���󴴽�ʱ�������һ�λ��Ʒ�����paintComponent��
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// ע�⣬����������ø���Ļ��Ʒ�������Ҫ����
		super.paintComponent(g);
		// �ѻ��Ƶ�ͼ�ķ��������������
		drawMap(g);
		drawPlayer(g);
		drawNpc(g);
		drawBullet(g);
		drawBulletBoom(g);
		// drawThroughGrass(g); ������
		drawBuff(g);
		drawBlood(g);
		drawGameOver(g);
		drawAaaKill(g);
		drawWin(g);
	}

	/**
	 * ����buffʵ��
	 */
	public void creatBuff() {
		if (buffs.size() < 1) {
			int type = (int) (Math.random() * 1) + 1;
			// buff�����λ��
			int x = (int) (Math.random() * gameMap[0].length);
			int y = (int) (Math.random() * gameMap.length);
			if (gameMap[y][x] == 0) {// ��������λ����û�ж������������
				switch (type) {
				case 1:// ����pauseBuff
					Buff buff = new PauseBuff(x, y, "pauseBuff");
					buffs.add(buff);// ���������
					break;
				default:
					break;

				}
			}
		}
	}

	/**
	 * �����з�̹��ʵ��
	 */
	public static void createNpc() {
		/*
		 * �����з�̹��ʵ��(����Ϊ28*28)
		 */
		int npcBirth[] = { 0, TankMap.first[0].length / 2, TankMap.first[0].length - 1 };
		int limitNumber = 3;// ˲���������з�̹������
		int maxNumber = 6;// ������Ϸ�ܹ������ɵ�̹������
		// �������̹��
		while (npcs.size() < limitNumber && untilnowNumber < maxNumber) {
			Npc npc = new Npc(npcBirth[(int) (Math.random() * npcBirth.length)], 0, 2);
			npcs.add(npc);
			untilnowNumber++;
		}
	}

	/**
	 * ���Ƶ�ͼ
	 */
	public void drawMap(Graphics g) {
		gameMap = TankMap.randomMap;// Ҫ���Ƶĵ�ͼ����
		// ���û���g����ɻ����Ļ���
		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[i].length; j++) {
				switch (gameMap[i][j].intValue()) {
				case 1:
					// ��ԴͼƬ��ĳ�����򻭵�������ĳ��������
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 0, 0, 32, 32, this);
					break;
				case 2:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32, 0, 64, 32, this);
					break;
				case 3:// ��
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 64, 0, 96, 32, this);
					break;
				case 4:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * (3 + step), 0,
							32 * (4 + step), 32, this);
					break;
				case 5:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * (4 - step), 0,
							32 * (5 - step), 32, this);
					break;
				case 6:
					g.drawImage(ImageUtil.mapImage, j * 32, i * 32, 32 * (j + 1), 32 * (i + 1), 32 * 5, 0, 32 * 6, 32,
							this);
					break;
				default:
					break;
				}
			}
		}
	}

	/**
	 * �����ҷ�̹��:��Ϊ�᲻�ϵĵ���repaint�������ı���Ƶ�ͼ�����ʴ����ͼ�Ĳ��������ù̶���
	 * 
	 * @param g
	 */
	public void drawPlayer(Graphics g) {
		/*
		 * 32λ�����ƶ�
		 */
		if (player.underGrass) {// ����ǲݣ���ô��Ⱦ�ݡ�����ֱ����ô�Ŵ�ͼƬ����ʾЧ�������õ�����һ�Ÿ����ͼƬ
			g.drawImage(ImageUtil.mapImage, player.getX() * 32 - 8, player.getY() * 32 - 8, player.getX() * 32 + 32 + 8,
					player.getY() * 32 + 32 + 8, 64, 0, 96, 32, this);
		} else if (!player.isDrawStar) {// ���û�л������ǣ���ô��������
			g.drawImage(ImageUtil.starImage, player.getX() * 32, player.getY() * 32, player.getX() * 32 + 32,
					player.getY() * 32 + 32, (0 + player.StarStep) * 32, 0, (0 + player.StarStep) * 32 + 32, 32, this);
			player.StarStep++;
			player.StarTimes--;
			if (player.StarStep == 4) {// ����ֻ������ͼ
				player.StarStep = 0;
			}
			if (player.StarTimes == 0) {
				player.isDrawStar = true;// �����Ѿ�����������
			}
		} else {// ������ǲ�����Ⱦ̹��

			g.drawImage(ImageUtil.playerImage, player.getX() * 32, player.getY() * 32, player.getX() * 32 + 32,
					player.getY() * 32 + 32, (0 + step) * 32, player.getDir() * 32, (0 + step) * 32 + 32,
					player.getDir() * 32 + 32, this);
		}
		/*
		 * 4λ�����ƶ���x y ����ȫ���Ŵ�8��
		 */

//		g.drawImage(ImageUtil.playerImage, player.getX() * 4, player.getY() * 4, player.getX() * 4 + 32,
//				player.getY() * 4 + 32, (0 + step) * 32, player.getDir() * 32, (0 + step) * 32 + 32,
//				player.getDir() * 32 + 32, this);

	}

	/**
	 * ���Ƶз�̹��
	 */
	public void drawNpc(Graphics g) {
		createNpc();// �����µĵз�̹��

		// ��������
		for (int i = 0; i < GamePanel.npcs.size(); i++) {

			Npc npc = GamePanel.npcs.get(i);
			if (npc.underGrass) {// ����ڴ��ݣ�����Ʋ�
				g.drawImage(ImageUtil.mapImage, npc.getX() * 32 - 8, npc.getY() * 32 - 8, npc.getX() * 32 + 32 + 8,
						npc.getY() * 32 + 32 + 8, 64, 0, 96, 32, this);
			} else if (!npc.isDrawStar) {// ���û�л������ǣ���ô��������
				g.drawImage(ImageUtil.starImage, npc.getX() * 32, npc.getY() * 32, npc.getX() * 32 + 32,
						npc.getY() * 32 + 32, (0 + npc.StarStep) * 32, 0, (0 + npc.StarStep) * 32 + 32, 32, this);
				npc.StarStep++;
				npc.StarTimes--;
				if (npc.StarStep == 4) {// ����ֻ������ͼ
					npc.StarStep = 0;
				}
				if (npc.StarTimes == 0) {
					npc.isDrawStar = true;// �����Ѿ�����������
				}
			} else {// �������̹��
				g.drawImage(ImageUtil.npcImage, npc.getX() * 32, npc.getY() * 32, npc.getX() * 32 + 32,
						npc.getY() * 32 + 32, step * 28, npc.getDir() * 28, (step + 1) * 28, npc.getDir() * 28 + 28,
						this);
			}
			// ����з�̹�˲������ˣ���Ӽ�����ɾ��
			if (!npc.isAlive()) {
				npcs.remove(npc);
			}
		}
	}

	/**
	 * �����ӵ�
	 */
	public void drawBullet(Graphics g) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			// ����ӵ�������ˣ���Ӽ�����ɾ����Ԫ��
			if (!bullet.getIsAlive()) {
				bullets.remove(bullet);
			}
			g.drawImage(ImageUtil.bulletImage, bullet.getX() * 32, bullet.getY() * 32, bullet.getX() * 32 + 32,
					bullet.getY() * 32 + 32, 0, 0, 28, 28, this);

		}
	}

	/**
	 * �����ӵ���ըЧ��
	 */
	int j = 0;// ���ڱ�ʾ�û��Ʊ���Ч������һ����ͼ

	public void drawBulletBoom(Graphics g) {
		for (int i = 0; i < bulletBooms.size(); i++) {
			BulletBoom bulletBoom = bulletBooms.get(i);

			if (j < 8) {// �ܹ�8������
				g.drawImage(ImageUtil.boomImage, bulletBoom.getX() * 32, bulletBoom.getY() * 32,
						bulletBoom.getX() * 32 + 32, bulletBoom.getY() * 32 + 32, (0 + j) * 32, 0, (0 + j) * 32 + 32,
						32, this);
				j++;// �����˵�ǰ���ֺ󣬱�־�û�����һ����

			}
			if (j == 8) {
				bulletBoom.setAlive(false);// ��ʵĿǰ��������ҪisAlive������������Ϊͳһ
				j = 0;
			}
			if (!bulletBoom.isAlive())
				bulletBooms.remove(bulletBoom);
		}
	}

	/*
	 * ״̬�������� ������̹����Ⱦ�� ���ƴ���Ч��:�Ȼ���̹�ˣ��ٻ��ƴ��
	 */

	/*
	 * public void drawThroughGrass(Graphics g) { for (int i = 0; i <
	 * throughGrasses.size(); i++) { ThroughGrass throughGrass =
	 * throughGrasses.get(i); g.drawImage(ImageUtil.playerImage, throughGrass.getX()
	 * * 32, throughGrass.getY() * 32, throughGrass.getX() * 32 + 32,
	 * throughGrass.getY() * 32 + 32, (0 + step) * 32, throughGrass.getDir() * 32,
	 * (0 + step) * 32 + 32, throughGrass.getDir() * 32 + 32, this);
	 * g.drawImage(ImageUtil.throughGrassImage, throughGrass.getX() * 32 - 6,
	 * throughGrass.getY() * 32 - 6, throughGrass.getX() * 32 + 32 + 6,
	 * throughGrass.getY() * 32 + 32 + 6, 0, 0, 38, 38, this);
	 * 
	 * if (!throughGrass.isAlive()) {
	 * 
	 * throughGrasses.remove(throughGrass);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */
	/**
	 * ����buff
	 * 
	 * @param g
	 */
	public void drawBuff(Graphics g) {
		creatBuff();
		for (int i = 0; i < buffs.size(); i++) {
			Buff buff = buffs.get(0);
			if (buff.isAlive()) {// ��buff���ʱ�Ž��л滭
				String type = buff.getType();
				int x = buff.getX();
				int y = buff.getY();
				// ѡ���Ӧ��buff������Ⱦ
				switch (type) {
				case "pauseBuff":
					g.drawImage(ImageUtil.buffImage, x * 32, y * 32, x * 32 + 32, y * 32 + 32, 32, 0, 32 + 32, 32,
							this);

					break;
				default:
					break;
				}
			}
			// ���buff���������Ƴ�����
			if (!buff.isAlive()) {
				buffs.remove(buff);
			}
		}
	}

	/**
	 * ���Ƴ�ѪЧ��
	 */
	public void drawBlood(Graphics g) {
		for (int i = 0; i < bloods.size(); i++) {
			Blood blood = bloods.get(i);
			if (blood.times > 0) {
				g.drawImage(ImageUtil.bloodImage, 0, 0, 992, 672, 0, 0, 500, 500, this);
				blood.times--;
			}
			if (blood.times <= 0) {
				bloods.remove(blood);
			}
		}

	}

	/**
	 * ������Ϸ����Ч��ͼ
	 */
	public void drawGameOver(Graphics g) {
		if (gameOverEffect != null) {
			g.drawImage(ImageUtil.gameOverImage, 0, 0, 992, 672, 0, 0, 256, 160, this);
			gameOverEffect = null;
		}
	}

	/**
	 * ���ƴ���Ч��ͼ
	 */
	int killStep = 0;

	public void drawAaaKill(Graphics g) {
		if (aaakill) {

			if (killStep == 0)
				g.drawImage(ImageUtil.aaaKillImage01, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 1)
				g.drawImage(ImageUtil.aaaKillImage02, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 2)
				g.drawImage(ImageUtil.aaaKillImage03, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 3)
				g.drawImage(ImageUtil.aaaKillImage04, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 4)
				g.drawImage(ImageUtil.aaaKillImage05, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 5)
				g.drawImage(ImageUtil.aaaKillImage06, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 6)
				g.drawImage(ImageUtil.aaaKillImage07, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 7)
				g.drawImage(ImageUtil.aaaKillImage08, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 8)
				g.drawImage(ImageUtil.aaaKillImage09, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 9)
				g.drawImage(ImageUtil.aaaKillImage10, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 10)
				g.drawImage(ImageUtil.aaaKillImage11, 0, 0, 992, 672, 0, 0, 414, 328, this);
			if (killStep == 11)
				g.drawImage(ImageUtil.aaaKillImage12, 0, 0, 992, 672, 0, 0, 414, 328, this);
			killStep++;
		}
		if (killStep == 12) {
			killStep = 0;
			aaakill = false;
		}
	}

	/**
	 * ����ʤ��
	 */
	public void drawWin(Graphics g) {
		if (isWin) {
			g.drawImage(ImageUtil.wimImage, 0, 0, 992, 672, 0, 0, 256, 256, this);
			gameOver = true;// ��Ϸ����
		}
	}

	/**
	 * run����
	 */
	@Override
	public void run() {
		// ���ϵ���repaint�������иû����Ļ���
		while (!gameOver) {
			// ÿ100����ˢ��һ��
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			step++;
			if (step > 1) {// ������2��ʱ�򣬾�����һ��0��1��
				step = 0;
			}

			// �Ըû������½��л���
			this.repaint();

		}
		if (!isWin) {
			new Music("music/GAMEOVER.wav").play();
		}
	}
}
