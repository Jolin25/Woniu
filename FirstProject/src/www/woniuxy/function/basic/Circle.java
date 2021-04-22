package www.woniuxy.function.basic;

import java.text.DecimalFormat;

public class Circle {
	int flag = 1;//标志是否输入错误
	double PI =Math.PI;
	DecimalFormat df = new DecimalFormat("#0.00");//浮点型输出格式
	
	//属性
	public double radius;
	//方法
	public String show() {
		
		return "面积为：" +df.format(radius*radius*PI) + "周长为："+ df.format(radius*2*PI);
		
	}
	//构造方法
	public Circle(double radius) {
		this.radius=radius;
	
	}
}
