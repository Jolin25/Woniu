package writer;
/*
 * 向文件写数据
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
	public void WriteMessage() throws IOException {
		File file = new File("one.txt");
		FileWriter fw = new FileWriter(file, true);// 创建文件字符流对象
		BufferedWriter bw = new BufferedWriter(fw);// 创建字符缓存流，将文件字符流包装成字符缓存流来进行操作
		bw.write("啊哈哈哈哈哈哈哈哈哈");
		fw.write("\r\t");//换行
		
		bw.flush();// 刷新缓存流，则直接将缓存流的内容保存到了文件中
		bw.close();// 关闭缓存流，也可以将缓存流中的内容保存进文件中，但是缓存流有一个默认大小

	}

	public static void main(String[] args) throws IOException {
		WriterDemo wd = new WriterDemo();
		wd.WriteMessage();
	}
}
