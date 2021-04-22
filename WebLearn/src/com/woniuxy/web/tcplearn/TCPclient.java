
package com.woniuxy.web.tcplearn;

/**
 * 向服务器发送消息，并接受服务器的响应数据
 * 备注：记住切流
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclient {
	public static void main(String[] args) {
		// 目标IP
		String host = "127.0.0.1";
		// 目标端口
		int port = 1234;
		// Socket套接字,基于TCP协议进行数据传输
		Socket client = null;
		// 输出流，用于向服务器发送消息
		OutputStream os = null;
		// 输入流，用于接收服务器发回的消息
		InputStream is = null;
		try {
			// 创建套接字，绑定目标主机以及端口
			client = new Socket(host, port);
			// 获取输出流
			os = client.getOutputStream();
			// 这是要发送的消息
			String content = "this is a test啊!!!!!!";
			// 发送数据
			os.write(content.getBytes());
			// 切流啊！！！不然服务器根本不知道客户端有没有发送完数据，会一直停着不挥手
			client.shutdownOutput();
			// 接收服务器发送回来的数据
			is = client.getInputStream();
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = is.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (is != null)
				is.close();
		} catch (Exception e) {

		} finally {
			try {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e2) {

			} finally {
				try {
					if (client != null) {
						try {
							client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e3) {

				}

			}

		}

	}
}
