
package com.woniuxy.web.tcplearn;

/**
 * �������������Ϣ�������ܷ���������Ӧ����
 * ��ע����ס����
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPclient {
	public static void main(String[] args) {
		// Ŀ��IP
		String host = "127.0.0.1";
		// Ŀ��˿�
		int port = 1234;
		// Socket�׽���,����TCPЭ��������ݴ���
		Socket client = null;
		// ������������������������Ϣ
		OutputStream os = null;
		// �����������ڽ��շ��������ص���Ϣ
		InputStream is = null;
		try {
			// �����׽��֣���Ŀ�������Լ��˿�
			client = new Socket(host, port);
			// ��ȡ�����
			os = client.getOutputStream();
			// ����Ҫ���͵���Ϣ
			String content = "this is a test��!!!!!!";
			// ��������
			os.write(content.getBytes());
			// ��������������Ȼ������������֪���ͻ�����û�з��������ݣ���һֱͣ�Ų�����
			client.shutdownOutput();
			// ���շ��������ͻ���������
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
