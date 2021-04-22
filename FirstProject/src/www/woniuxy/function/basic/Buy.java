package www.woniuxy.function.basic;

public class Buy {
	int money = 100;
	//买鸡肉花了30
	public void buyC() {
		money -= 30;
		System.out.print("买鸡肉花了30元，还剩"+money+"\n");
		
	}
	//卖猪肉20
	public void buyM() {
		money -= 20;
		System.out.print("买猪肉花了20元，还剩"+money+"\n");
	}
	//卖蔬菜 20
	public void buyV(String...names) {
		money -= 20;
		System.out.print("买了");
		for(String name:names) {
			System.out.print(name+" ");
		}
		System.out.print("买蔬菜花了20元，还剩"+money+"\n");
	}
	//买零食10
	public void buyJ() {
		money -= 10;
		System.out.print("买零食花了10元，还剩"+money+"\n");
	}
	//
	public void buyCo() {
		money -= 20;
		System.out.print("买可乐花了20元，还剩"+money+"\n");
	}
}
