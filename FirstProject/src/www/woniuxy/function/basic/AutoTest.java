package www.woniuxy.function.basic;

/*
 * ����һ������Auto�� ������̥���� ������ɫ �����������ٶȵȳ�Ա������
 * ��ͨ����ͬ�Ĺ��췽������ʵ��������Ҫ�� �����ܹ����� ���� ͣ���� 
 * �ٶ���һ��С������Car �̳�Auto ����ӿյ���CD�ȳ�Ա���� ���Ǽ��� ���ٵķ���
 */
public class AutoTest {
	public static void main(String[] args) {
//		// ʵ����Auto��
//		Auto car = new Auto(4, 4000, 50);
//		car.show();
//		// car.accelerate(40);
//		car.accelerate(70);
//		// car.show();
//		car.decelerate(20);
//		// car.show();
//		// car.decelerate(100);
//		car.stop();
		
		SedanCar scar = new SedanCar(4, 122, 12, "����", "��CD");
		scar.show();
		scar.accelerate(90);
	}
}
