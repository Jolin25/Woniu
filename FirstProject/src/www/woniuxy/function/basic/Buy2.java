package www.woniuxy.function.basic;

public class Buy2 {
	int money1 = 100;
	//
	public void buy (String name,int money) {
		money1 -= money;
		System.out.print("��"+name+"������"+money+"Ԫ��"+
		"��ʣ"+money1+"Ԫ\n");
	}
}
