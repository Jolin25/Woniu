package www.woniuxy.function.basic;

/*
 * ����һ������Auto�� ������̥���� ������ɫ �����������ٶȵȳ�Ա������
 * ��ͨ����ͬ�Ĺ��췽������ʵ��������Ҫ�� �����ܹ����� ���� ͣ���� 
 * �ٶ���һ��С������Car �̳�Auto ����ӿյ���CD�ȳ�Ա���� ���Ǽ��� ���ٵķ���
 */
public class SedanCar extends Auto {
	// ��ӳ�Ա����
	String airCondition;
	String CD;

	public SedanCar(int tireNumber, int weight, int speed, String airCondition, String CD) {
		super(tireNumber, weight, speed);

		this.airCondition = airCondition;
		this.CD = CD;
		
	}
	// ���Ǽ��ٷ���
	@Override
	public int accelerate(int target) {
		if (target < speed) {
			System.out.println("�������");
		} else {
			speed = target;
			System.out.println("�Ѽ�����" + speed + "��");
			System.out.println("��С�ļ�ʻ");
		}
		return speed;
	}
	//���Ǽ���
	@Override
	public int decelerate(int target) {
		if (target > speed) {
			System.out.println("�������");
		} else {
			speed = target;
			System.out.println("�Ѽ�����" + speed + "��");
			System.out.println("��С�ļ�ʻ");
		}
		return speed;
	}
}
