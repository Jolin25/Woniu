package com.woniuxy.web.httplearn;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Socketѧϰ �ο�java���ļ���
 * 
 * @author С���ӵ�С�ճ�
 *
 */
public class SocketLearn {
	public static void main(String[] args) {
		SocketLearn sl = new SocketLearn();
//		sl.socketWithSystem();
		sl.LearnInetAddress();
	}

	/*
	 * ��������ַת����ϰ������-->IP
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
					//��Ϊbyte��-128��127�������������õ�ip��0-255������Ҫת����-127��Ӧ����129.����-128��Ӧ128,-1��Ӧ255.
					System.out.print(256+b);
				}
				System.out.print(".");
			}
			System.out.println("\n");
			//�������ʽ�õ��ľ����뿴��IP
			String add = address.getHostAddress();
			System.out.println(add);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/*
	 * �����Systemʹ�õ��׽���
	 */
	public void socketWithSystem() {
		try {
			/*
			 * "xxxx"��һ��������13�Ƕ˿ں� �����׽���
			 */
			Socket s = new Socket("time-a.nist.gov", 13);
			/*
			 * һ���׽��ֱ��򿪣�getInputStream�ͻ᷵��һ�����������󣬿��Ժͱ��������һ��ʹ��
			 */
			Scanner in = new Scanner(s.getInputStream(), "utf-8");
			while (in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
		} catch (UnknownHostException e) {// �������ʧ�ܣ�UnknownHostException��IOException��һ�����ࣩ
			e.printStackTrace();
		} catch (IOException e) {// �������������
			e.printStackTrace();
		}
	}

}
