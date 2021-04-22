package www.woniuxy.function.basic;

import java.util.Scanner;

public class FunctionCall {
	public static void main(String[]args) {
		//Function2 add = new Function2();
		
//	//买菜	
//     Buy b = new Buy();
//     b.buyC();
//     b.buyM();
//     b.buyV("秋葵","西红柿");
//     b.buyJ();
//     b.buyCo();
		
		
//		//买狗
//		BuyPuppy mona = new BuyPuppy();
//		BuyPuppy nico = new BuyPuppy();
//		mona.Bichon(2);
//		nico.Huskie(2);
//		mona.Tig(1);
//		
		
		//买东西改进版
		Buy2 mona = new Buy2();
		mona.buy("新西兰", 90);
		mona.buy("亚马逊", 1);
	}
}
