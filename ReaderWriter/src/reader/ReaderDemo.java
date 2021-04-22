package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {
	public void readMessage() throws IOException {
		// 利用字符流将文件里的内容读到程序中
		File file = new File("one.txt");
		FileReader fr = new FileReader(file);//输入字符流对象
		BufferedReader br = new BufferedReader(fr);//缓存流
		/*
		 * 利用字符串来处理输入显示，缺点String不可以修改
		 */
//		String content = br.readLine();
//		while(content!=null) {
//			System.out.println(content);
//			content = br.readLine();
//		}
		/*
		 * 利用StringBuffer
		 */
		StringBuffer sb = new StringBuffer(br.readLine());
//		while(sb!=null) {
//			System.out.println(sb);//如果这样写，会不停的输出第一句
//			
//		}
		
		String s = " ";
		while(( s = br.readLine())!=null) {
			sb.append(s);
			s = br.readLine();
			
		}
		System.out.println(new String(sb));
		//关闭流
		br.close();
		fr.close();
	}
	public static void main(String[] args) throws IOException {
		ReaderDemo rd = new ReaderDemo();
		rd.readMessage();
	}
}
