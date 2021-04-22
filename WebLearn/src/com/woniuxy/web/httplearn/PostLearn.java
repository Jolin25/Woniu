/**
 * ģ����������������������
 */
package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PostLearn {
	public static void main(String[] args) {
		//ȷ��������IP�Ͷ˿ں�
		String ip = "localhost";
		int port = 8080;
		Socket browser = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//�����ͻ����׽���
			browser = new Socket(ip,port);
			//׼��HTTP��������(�ǵ�ÿ�ж�Ҫ���У���\r\n����Ӵ)
			StringBuilder request = new StringBuilder();
			String content = "oper=login&account=18990341730&pass=123456";
			//����POST�����ĸ������Ǳ���Ĺ�
			//������
			request.append("POST http://localhost:8080/WoniuShop1.0.0/useroper HTTP/1.1\r\n");
			//����
			request.append("Host: localhost:8080\r\n");
			//�������ݳ���
			request.append("Content-Length: "+content.length()+"\r\n");
		
			//������������
			request.append("Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n");
			
			request.append("Cookie:JSESSIONID=CBEB6AF526A413BD3547F5C363414E2D\r\n");
			
			request.append("\r\n");
			//��������
			request.append(content);
			//���������ݷ���������
			//�������������ȡָ����������������
			os = browser.getOutputStream();
			//�����������
			//StringBuilder û��getBytesӴ����Ҫ��תΪString��������
			os.write(request.toString().getBytes());
			//��ע������Ҫ�����������ˣ���Ϊ�������и�����
			
			//��ȡ����������Ӧ���ݣ���ȡָ��ͻ��˵���������
			is = browser.getInputStream();
			//ͨ����������ȡ����
			int len = -1;
			byte[] response = new byte[1024];
			while((len = is.read(response))!=-1) {
				System.out.println(new String(response,0,len,"utf-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//�ر�����socket
			try {
				if(is!=null)
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(os!=null)
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						if(browser!=null)
						browser.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
