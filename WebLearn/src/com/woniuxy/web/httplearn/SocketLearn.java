package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socket学习 参考java核心技术
 * 
 * @author 小虫子的小日常
 *
 */
public class SocketLearn {
	public static void main(String[] args) {
		SocketLearn sl = new SocketLearn();
//		sl.socketWithSystem();
		sl.LearnInetAddress();
	}

	/*
	 * 因特网地址转换练习：域名-->IP
	 */
	public void LearnInetAddress(){
		String host ="time-a.nist.gov";
		try {
		InetAddress  address = 	InetAddress.getByName(host);
			byte[] addressBytes = address.getAddress();
			for(byte b:addressBytes){
				if(b>0){
					System.out.print(b);										
				}else{
					//因为byte是-128到127，但是这里想用的ip是0-255，所以要转换，-127对应的是129.所以-128对应128,-1对应255.
					System.out.print(256+b);
				}
				System.out.print(".");
			}
			System.out.println("\n");
			//用这个方式得到的就是想看的IP
			String add = address.getHostAddress();
			System.out.println(add);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 结合了System使用的套接字
	 */
	public void socketWithSystem() {
		try {
			/*
			 * "xxxx"是一个域名，13是端口号 创建套接字
			 */
			Socket s = new Socket("time-a.nist.gov", 13);
			/*
			 * 一旦套接字被打开，getInputStream就会返回一个输入流对象，可以和别的流对象一样使用
			 */
			Scanner in = new Scanner(s.getInputStream(), "utf-8");
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		} catch (UnknownHostException e) {// 如果连接失败（UnknownHostException是IOException的一个子类）
			e.printStackTrace();
		} catch (IOException e) {// 如果是其他问题
			e.printStackTrace();
		}
	}

}
