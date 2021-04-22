/**
 * TCP的服务器哈：接收客户端发送的信息，并发回响应数据
 *  1.确定服务器端口
	2.创建服务器套接字，绑定服务器端口
	3.阻塞接收数据包，将收到的数据包封装为Socket对象，通过操作该Socket对象可以获取该数据包相关信息
	4.获取该socket对象的输入流
	5.通过输入流读取该数据包（即Socket对象）发送的数据
	6.获取该socket对象的输出流
	7.通过输出流向服务器发送消息
	7.关闭输入流
	8.关闭和客户端连接的Socket
	9.关闭服务器套接字
 */
package com.woniuxy.web.tcplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		// 确定服务器端口
		int port = 1234;
		ServerSocket server = null;
		Socket client = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// 创建服务器套接字，绑定服务器端口
			server = new ServerSocket(port);
			/*
			 * 阻塞接收数据包，会将收到的数据包封装为Socket对象，利用操作该Socket对象可以 获取该数据包的相关信息
			 */
			client = server.accept();
			// 获取client的输入流
			is = client.getInputStream();
			// 通过输入流读取客户端发送的信息
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = is.read(b)) != -1) {// 如果没有读到最后一位
				System.out.println(new String(b, 0, len));
			}
			// 构造输出流，服务器向客户端发送信息
			os = client.getOutputStream();
			os.write("回消息啦".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e2) {
			} finally {
				try {
					if (server != null) {
						server.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
						try {
							if(client!=null)
								client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}finally {
							if (is != null) {
								try {
									is.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
				}
			}
		}

	}
}
