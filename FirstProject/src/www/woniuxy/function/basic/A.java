package www.woniuxy.function.basic;

/*
 * ��������Ϸһ����A��һ����Ա����v��һ����ֵ100��
 * ����һ�����A��ĳ�Ա����v���в¡������������ʾ����С������ʾС�ˡ�
 * ��������ʾ�²�ɹ�
 */
public class A {
	int v = 100;
	public void compare(int guess) {
		if (guess == v) {
			System.out.print("������ȷ");
		} else if (guess < v) {
			System.out.println("С��");
		} else {
			System.out.println("����");
		}
	}
}
