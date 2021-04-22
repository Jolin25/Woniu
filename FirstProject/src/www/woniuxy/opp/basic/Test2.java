package www.woniuxy.opp.basic;

public class Test2 {
	public static void main(String[]args) {
		Son son = new Son();
		//son.name = "不愿意。。";
		son.playGames();
		son.eat();
		System.out.println(son.name);
		
		//利用父类定义子类,向下转型
		Father fson = new Son();
		fson.eat();
		if(fson instanceof Son) {
			((Son) fson).playGames();
		}
		
		//
		//super.eat();不能在静态方法中使用
		
	}
}
