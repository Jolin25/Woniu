/**
 * TCP�ķ������������տͻ��˷��͵���Ϣ����������Ӧ����
 *  1.ȷ���������˿�
	2.�����������׽��֣��󶨷������˿�
	3.�����������ݰ������յ������ݰ���װΪSocket����ͨ��������Socket������Ի�ȡ�����ݰ������Ϣ
	4.��ȡ��socket�����������
	5.ͨ����������ȡ�����ݰ�����Socket���󣩷��͵�����
	6.��ȡ��socket����������
	7.ͨ��������������������Ϣ
	7.�ر�������
	8.�رպͿͻ������ӵ�Socket
	9.�رշ������׽���
 */
package com.woniuxy.web.tcplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		// ȷ���������˿�
		int port = 1234;
		ServerSocket server = null;
		Socket client = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// �����������׽��֣��󶨷������˿�
			server = new ServerSocket(port);
			/*
			 * �����������ݰ����Ὣ�յ������ݰ���װΪSocket�������ò�����Socket������� ��ȡ�����ݰ��������Ϣ
			 */
			client = server.accept();
			// ��ȡclient��������
			is = client.getInputStream();
			// ͨ����������ȡ�ͻ��˷��͵���Ϣ
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = is.read(b)) != -1) {// ���û�ж������һλ
				System.out.println(new String(b, 0, len));
			}
			// �������������������ͻ��˷�����Ϣ
			os = client.getOutputStream();
			os.write("����Ϣ��".getBytes());
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
