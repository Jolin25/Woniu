package writer;
/*
 * ���ļ�д����
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
	public void WriteMessage() throws IOException {
		File file = new File("one.txt");
		FileWriter fw = new FileWriter(file, true);// �����ļ��ַ�������
		BufferedWriter bw = new BufferedWriter(fw);// �����ַ������������ļ��ַ�����װ���ַ������������в���
		bw.write("��������������������");
		fw.write("\r\t");//����
		
		bw.flush();// ˢ�»���������ֱ�ӽ������������ݱ��浽���ļ���
		bw.close();// �رջ�������Ҳ���Խ��������е����ݱ�����ļ��У����ǻ�������һ��Ĭ�ϴ�С

	}

	public static void main(String[] args) throws IOException {
		WriterDemo wd = new WriterDemo();
		wd.WriteMessage();
	}
}
