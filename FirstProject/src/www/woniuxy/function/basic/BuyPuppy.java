package www.woniuxy.function.basic;

public class BuyPuppy {
	static int  number;//总共买了的只数
	static int  money = 10000;//准备的钱
	//买比熊
	public void Bichon(int num) {
		money -= 1500*num;
		number +=num;
		if(money<0) {
			System.out.print("余额不足\n");
		}else {
		System.out.print("买了"+num+"只比熊，还剩"+money+"元，"+
		"现有"+number+"只小狗\n");
		}
	
	}
	//买哈士奇
	public void Huskie(int num) {
		money -= 2000*num;
		number +=num;
		if(money<0) {
			System.out.print("余额不足\n");
		}else {
		System.out.print("买了"+num+"只哈士奇，还剩"+money+"元，"+
		"现有"+number+"只小狗\n");
		}
	}
	//买边牧
	public void Tig(int num) {
		money -= 3000*num;
		number +=num;
		if(money<0) {
			System.out.print("余额不足\n");
		}else {
		System.out.print("买了"+num+"只边牧，还剩"+money+"元，"+
		"现有"+number+"只小狗\n");
		}
	}
}
