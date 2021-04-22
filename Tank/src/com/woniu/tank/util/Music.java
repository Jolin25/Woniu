package com.woniu.tank.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.AudioPlayer;

/**
 * ������
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class Music {
	String path;

	public Music(String path) {

		this.path = path;
	}

	public void play() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			AudioPlayer.player.start(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//????Ϊʲô�ֶ��ر����ͻ᲻��
//		}finally{
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
