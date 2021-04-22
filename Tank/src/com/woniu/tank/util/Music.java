package com.woniu.tank.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import sun.audio.AudioPlayer;

/**
 * 音乐类
 * 
 * @author 小虫子的小日常
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
		//????为什么手动关闭流就会不响
//		}finally{
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
