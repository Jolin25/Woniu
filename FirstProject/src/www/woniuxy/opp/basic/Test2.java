package www.woniuxy.opp.basic;

public class Test2 {
	public static void main(String[]args) {
		Son son = new Son();
		//son.name = "��Ը�⡣��";
		son.playGames();
		son.eat();
		System.out.println(son.name);
		
		//���ø��ඨ������,����ת��
		Father fson = new Son();
		fson.eat();
		if(fson instanceof Son) {
			((Son) fson).playGames();
		}
		
		//
		//super.eat();�����ھ�̬������ʹ��
		
	}
}
