package www.woniuxy.function.basic;

/*
 * ����һ������Auto�� ������̥���� ������ɫ �����������ٶȵȳ�Ա������
 * ��ͨ����ͬ�Ĺ��췽������ʵ��������Ҫ�� �����ܹ����� ���� ͣ���� 
 * �ٶ���һ��С������Car �̳�Auto ����ӿյ���CD�ȳ�Ա���� ���Ǽ��� ���ٵķ���
 */
public class Auto {
	// ����
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

	// ���췽��
	public Auto(int tireNumber, int weight, int speed) {
		this.speed = speed;
		this.tireNumber = tireNumber;
		this.weight = weight;
	}

	// ��Ϊ
	// ������Ϣ
	public void show() {
		System.out.println(speed + "��" + "����̥����" + tireNumber + ",����Ϊ:" + weight);
	}

	// ����
	public int accelerate(int target) {
		if (target < speed) {
			System.out.println("�������");
		} else {
			speed = target;
			System.out.println("�Ѽ�����" + speed + "��");
		}
		return speed;
	}

	// ����
	public int decelerate(int target) {
		if (target > speed) {
			System.out.println("�������");
		} else {
			speed = target;
			System.out.println("�Ѽ�����" + speed + "��");
		}
		return speed;
	}

	// ͣ��
	public void stop() {
		System.out.println("��ͣ��");
	}

}
