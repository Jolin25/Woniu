package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {
	public void readMessage() throws IOException {
		// �����ַ������ļ�������ݶ���������
		File file = new File("one.txt");
		FileReader fr = new FileReader(file);//�����ַ�������
		BufferedReader br = new BufferedReader(fr);//������
		/*
		 * �����ַ���������������ʾ��ȱ��String�������޸�
		 */
//		String content = br.readLine();
//		while(content!=null) {
//			System.out.println(content);
//			content = br.readLine();
//		}
		/*
		 * ����StringBuffer
		 */
		StringBuffer sb = new StringBuffer(br.readLine());
//		while(sb!=null) {
//			System.out.println(sb);//�������д���᲻ͣ�������һ��
//			
//		}
		
		String s = " ";
		while(( s = br.readLine())!=null) {
			sb.append(s);
			s = br.readLine();
			
		}
		System.out.println(new String(sb));
		//�ر���
		br.close();
		fr.close();
	}
	public static void main(String[] args) throws IOException {
		ReaderDemo rd = new ReaderDemo();
		rd.readMessage();
	}
}
