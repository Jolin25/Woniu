package www.woniuxy.function.basic;

public class Rectangle {
	// ����
	public int wide;
	public int tall;
	//����
	public void perimeter() {
		System.out.print((wide+tall)*2+"\n");
	}
	public void area() {
		System.out.print(wide * tall+"\n");
	}
	
//	//���췽�����޲Σ�
//	public Rectangle() {
//		
//	}//û����ʾ����ʱ��ϵͳĬ�ϵľ���������ʽ
//	
	
//	//���췽�����޲Σ�
//		public Rectangle() {
//			wide = 1;
//			tall = 1;
//		}//������ʱ���������û���ٴθ�ֵ�����ʹ�ù��췽�����Ѿ����õ�ֵ

	
	//���췽����һ��������
//	public Rectangle(int num) {
//		this.tall = num;
//		this.wide = num;
//	}//ʵ����ʱ������Ϊ��������Ը�ֵ
		
	
	//���췽��������������
	public Rectangle(int tall,int wide) {
		this.tall = tall;
		this.wide = wide;
	}
}
