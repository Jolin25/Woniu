package www.woniuxy.function.basic;

/*
 * 建立一个汽车Auto类 包括轮胎个数 汽车颜色 车身重量、速度等成员变量。
 * 并通过不同的构造方法创建实例。至少要求 汽车能够加速 减速 停车。 
 * 再定义一个小汽车类Car 继承Auto 并添加空调、CD等成员变量 覆盖加速 减速的方法
 */
public class AutoTest {
	public static void main(String[] args) {
//		// 实例化Auto类
//		Auto car = new Auto(4, 4000, 50);
//		car.show();
//		// car.accelerate(40);
//		car.accelerate(70);
//		// car.show();
//		car.decelerate(20);
//		// car.show();
//		// car.decelerate(100);
//		car.stop();
		
		SedanCar scar = new SedanCar(4, 122, 12, "松下", "有CD");
		scar.show();
		scar.accelerate(90);
	}
}
