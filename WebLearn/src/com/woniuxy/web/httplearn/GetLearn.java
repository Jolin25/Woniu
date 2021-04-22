/**
 * ģ���������������������ݣ�
 * ��Ϊhttp����Ӧ�ò㣬����ҲҪ�����ײ�ģ����Ի��ǻ�ʹ��tcp���׽���ʲô�ģ�tcp�ڴ����
 */
package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class GetLearn {
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
			/*
			 * 	һ��http�������������С�����ͷ�����С���������4���������
			 */
			//������
			request.append("GET http://localhost:8080/JavaWebBasicLearn/ HTTP/1.1\r\n");
			//����
			request.append("Host: localhost:8080\r\n");
			
			//��ʹû������ҲҪ��ͷ�����ļ�Ŀհ��д����Ӵ
			request.append("\r\n");
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
