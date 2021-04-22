package www.woniuxy.function.basic;

/*
 * 建立一个汽车Auto类 包括轮胎个数 汽车颜色 车身重量、速度等成员变量。
 * 并通过不同的构造方法创建实例。至少要求 汽车能够加速 减速 停车。 
 * 再定义一个小汽车类Car 继承Auto 并添加空调、CD等成员变量 覆盖加速 减速的方法
 */
public class Auto {
	// 属性
	public int tireNumber;
	public int weight;
	public int speed;

	public int getTireNumber() {
		return tireNumber;
	}

	public void setTireNumber(int tireNumber) {
		this.tireNumber = tireNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// 构造方法
	public Auto(int tireNumber, int weight, int speed) {
		this.speed = speed;
		this.tireNumber = tireNumber;
		this.weight = weight;
	}

	// 行为
	// 车辆信息
	public void show() {
		System.out.println(speed + "码" + "，轮胎数：" + tireNumber + ",重量为:" + weight);
	}

	// 加速
	public int accelerate(int target) {
		if (target < speed) {
			System.out.println("输入错误");
		} else {
			speed = target;
			System.out.println("已加速至" + speed + "码");
		}
		return speed;
	}

	// 减速
	public int decelerate(int target) {
		if (target > speed) {
			System.out.println("输入错误");
		} else {
			speed = target;
			System.out.println("已减速至" + speed + "码");
		}
		return speed;
	}

	// 停车
	public void stop() {
		System.out.println("已停车");
	}

}
