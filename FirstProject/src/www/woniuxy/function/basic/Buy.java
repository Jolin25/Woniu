package www.woniuxy.function.basic;

public class Buy {
	int money = 100;
	//���⻨��30
	public void buyC() {
		money -= 30;
		System.out.print("���⻨��30Ԫ����ʣ"+money+"\n");
		
	}
	//������20
	public void buyM() {
		money -= 20;
		System.out.print("�����⻨��20Ԫ����ʣ"+money+"\n");
	}
	//���߲� 20
	public void buyV(String...names) {
		money -= 20;
		System.out.print("����");
		for(String name:names) {
			System.out.print(name+" ");
		}
		System.out.print("���߲˻���20Ԫ����ʣ"+money+"\n");
	}
	//����ʳ10
	public void buyJ() {
		money -= 10;
		System.out.print("����ʳ����10Ԫ����ʣ"+money+"\n");
	}
	//
	public void buyCo() {
		money -= 20;
		System.out.print("����ֻ���20Ԫ����ʣ"+money+"\n");
	}
}
