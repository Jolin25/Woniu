package www.woniuxy.function.basic;

//import www.woniuxy.function.basic.Human.Bridge;

public class World {
	public static void main(String[]args) {
		// 对Human创建对象
		Human xiaoHong = new Human("小红",22,'女');
		Human xiaoZhang = new Human("校长",23,'男');
//		xiaoHong.name = "小红";
//		xiaoHong.sex = '女';
//		xiaoHong.age = 22;
//		xiaoZhang.name = "校长";
//		xiaoZhang.sex = '男';
//		xiaoZhang.age = 23;
		xiaoHong.showMe();
		xiaoZhang.showMe();
		//xiaoHong.eat();
		//xiaoHong.os();
//		//对Bridge创建对象
//		Bridge tongHui = new Bridge();
//		tongHui.color = "灰白";
//		tongHui.length = 15;
//		tongHui.wheight = 2000;
//		tongHui.show();
//		//对Lake创建对象
//		Lake hu = new Lake();
//		hu.area = 3000;
//		hu.color = "翠绿";
//		hu.show();
		
	}
}
