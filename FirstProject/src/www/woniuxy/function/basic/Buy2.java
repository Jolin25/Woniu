package www.woniuxy.function.basic;

public class Buy2 {
	int money1 = 100;
	//
	public void buy (String name,int money) {
		money1 -= money;
		System.out.print("买"+name+"花费了"+money+"元，"+
		"还剩"+money1+"元\n");
	}
}
