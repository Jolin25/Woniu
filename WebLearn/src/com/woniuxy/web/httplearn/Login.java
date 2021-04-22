package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 用Java代码通过协议进行获取登录首页，进行登录的操作。
 * 
 * @author 小虫子的小日常
 *
 */
public class Login {
	public static void main(String[] args) {
		// 确定服务器IP和端口号
		String ip = "localhost";
		int port = 8080;
		Socket browser = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// 创建客户端套接字
			browser = new Socket(ip, port);
			// 准备HTTP请求数据(记得每行都要换行，用\r\n换行哟)
			StringBuilder request = new StringBuilder();
			// 请求行
			request.append("POST http://localhost:8080/WoniuShop1.0.0/useroper HTTP/1.1\r\n");
			// 主机
			request.append("Host: localhost:8080\r\n");
			// 正文内容长度
			request.append("Content-Length: 42\r\n");
			// 正文内容类型
			request.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n");
			//cookie
			request.append("Cookie: JSESSIONID=A50DDCB794CFFB2D054755D28F2147EE\r\n");
			//头与正文分隔的空白行
			request.append("\r\n");
			// 正文内容
			request.append("oper=login&account=18990341730&pass=123456\r\n");
			// 将请求数据发给服务器
			// 创建输出流（获取指向服务器的输出流）
			os = browser.getOutputStream();
			// 输出给服务器
			// StringBuilder 没有getBytes哟，需要先转为String类型再用
			os.write(request.toString().getBytes());
			// 备注：不需要在这里切流了，因为服务器有个机制

			// 获取服务器的响应数据（获取指向客户端的输入流）
			is = browser.getInputStream();
			// 通过输入流读取数据
			int len = -1;
			byte[] response = new byte[1024];
			while ((len = is.read(response)) != -1) {
				System.out.println(new String(response, 0, len, "utf-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭流和socket
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (os != null)
						os.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (browser != null)
							browser.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
