package www.woniuxy.function.basic;

import java.text.DecimalFormat;

public class Circle {
	int flag = 1;//��־�Ƿ��������
	double PI =Math.PI;
	DecimalFormat df = new DecimalFormat("#0.00");//�����������ʽ
	
	//����
	public double radius;
	//����
	public String show() {
		
		return "���Ϊ��" +df.format(radius*radius*PI) + "�ܳ�Ϊ��"+ df.format(radius*2*PI);
		
	}
	//���췽��
	public Circle(double radius) {
		this.radius=radius;
	
	}
}
