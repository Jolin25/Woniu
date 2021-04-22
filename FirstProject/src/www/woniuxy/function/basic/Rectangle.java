package www.woniuxy.function.basic;

public class Rectangle {
	// 属性
	public int wide;
	public int tall;
	//方法
	public void perimeter() {
		System.out.print((wide+tall)*2+"\n");
	}
	public void area() {
		System.out.print(wide * tall+"\n");
	}
	
//	//构造方法（无参）
//	public Rectangle() {
//		
//	}//没有显示声明时，系统默认的就是这种形式
//	
	
//	//构造方法（无参）
//		public Rectangle() {
//			wide = 1;
//			tall = 1;
//		}//被调用时，如果程序没有再次赋值，则会使用构造方法里已经赋好的值

	
	//构造方法（一个参数）
//	public Rectangle(int num) {
//		this.tall = num;
//		this.wide = num;
//	}//实例化时，将会为对象的属性赋值
		
	
	//构造方法（两个参数）
	public Rectangle(int tall,int wide) {
		this.tall = tall;
		this.wide = wide;
	}
}
