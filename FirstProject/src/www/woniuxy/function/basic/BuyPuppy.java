package www.woniuxy.function.basic;

public class BuyPuppy {
	static int  number;//�ܹ����˵�ֻ��
	static int  money = 10000;//׼����Ǯ
	//�����
	public void Bichon(int num) {
		money -= 1500*num;
		number +=num;
		if(money<0) {
			System.out.print("����\n");
		}else {
		System.out.print("����"+num+"ֻ���ܣ���ʣ"+money+"Ԫ��"+
		"����"+number+"ֻС��\n");
		}
	
	}
	//���ʿ��
	public void Huskie(int num) {
		money -= 2000*num;
		number +=num;
		if(money<0) {
			System.out.print("����\n");
		}else {
		System.out.print("����"+num+"ֻ��ʿ�棬��ʣ"+money+"Ԫ��"+
		"����"+number+"ֻС��\n");
		}
	}
	//�����
	public void Tig(int num) {
		money -= 3000*num;
		number +=num;
		if(money<0) {
			System.out.print("����\n");
		}else {
		System.out.print("����"+num+"ֻ��������ʣ"+money+"Ԫ��"+
		"����"+number+"ֻС��\n");
		}
	}
}
