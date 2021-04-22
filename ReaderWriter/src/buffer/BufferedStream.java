package buffer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedStream {
	public void readMessage() throws IOException {
		File file = new File("one.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] b = new byte[1024];
		bis.read(b);
		System.out.println(new String(b));
	}
	public static void main(String[] args) throws IOException {
		BufferedStream bs = new BufferedStream();
		bs.readMessage();
	}
}
