package www.woniuxy.opp.basic;

public class TestP {
	public static void main(String[]args) {
		Person [] person = new Person[5];//��������
		Person p = null;//��������
		p = new Person();
		p.setName("��һ");
		p.setAge(1);
		person[0]=p;
		p = new Person();
		p.setName("�Ŷ�");
		p.setAge(2);
		person[1]=p;
		//
		for(Person per:person) {
			System.out.println(per);
		}
	}
}
