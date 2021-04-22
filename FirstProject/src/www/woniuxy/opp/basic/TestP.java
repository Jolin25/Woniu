package www.woniuxy.opp.basic;

public class TestP {
	public static void main(String[]args) {
		Person [] person = new Person[5];//创建数组
		Person p = null;//创建对象
		p = new Person();
		p.setName("张一");
		p.setAge(1);
		person[0]=p;
		p = new Person();
		p.setName("张二");
		p.setAge(2);
		person[1]=p;
		//
		for(Person per:person) {
			System.out.println(per);
		}
	}
}
