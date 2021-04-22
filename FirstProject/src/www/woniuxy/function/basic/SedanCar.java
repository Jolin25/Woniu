package www.woniuxy.function.basic;

/*
 * 建立一个汽车Auto类 包括轮胎个数 汽车颜色 车身重量、速度等成员变量。
 * 并通过不同的构造方法创建实例。至少要求 汽车能够加速 减速 停车。 
 * 再定义一个小汽车类Car 继承Auto 并添加空调、CD等成员变量 覆盖加速 减速的方法
 */
public class SedanCar extends Auto {
	// 添加成员变量
	String airCondition;
	String CD;

	public SedanCar(int tireNumber, int weight, int speed, String airCondition, String CD) {
		super(tireNumber, weight, speed);

		this.airCondition = airCondition;
		this.CD = CD;
		
	}
	// 覆盖加速方法
	@Override
	public int accelerate(int target) {
		if (target < speed) {
			System.out.println("输入错误");
		} else {
			speed = target;
			System.out.println("已加速至" + speed + "码");
			System.out.println("请小心驾驶");
		}
		return speed;
	}
	//覆盖减速
	@Override
	public int decelerate(int target) {
		if (target > speed) {
			System.out.println("输入错误");
		} else {
			speed = target;
			System.out.println("已减速至" + speed + "码");
			System.out.println("请小心驾驶");
		}
		return speed;
	}
}
