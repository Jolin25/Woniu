package www.woniuxy.opp.basic;

import java.util.Scanner;

public class Test {
	public static void main(String[]args) {
		//ʵ����
		Person p = new Person();
		//����ֵ
		p.setAge(18);
		p.setName("momoko");
		//��ȡֵ
		String name = p.getName();
		int age = p.getAge();
		System.out.println("������"+name+",���䣺"+age);
	//�����鱣�����
		Scanner sc = new Scanner(System.in);
		Person[] person = new Person[5];//��������
		for(int i =0;i<person.length-1;i ++) {
			person[i]=new Person();//��������
			//����
			System.out.print("������������");
			String name0 = sc.next();
			person[i].setName(name0);
			System.out.print("���������䣺");
			int age0 = sc.nextInt();
			person[i].setAge(age0);
			//int age1 = person[i].getAge();
			//String name1 = person[i].getName();
			//System.out.println(name1 + "  "+age1 );
			
		} 
		//System.out.println(person[4]);
		for(Person i:person) {
		//	System.out.println(i);
			
			System.out.println("����Ϊ��"+i.getName()+"������Ϊ��"+i.getAge());/*��û�д�������
			�޷����÷���ʱ���򲻻�ִ�д˾�*/
													
		}
//forѭ�����	
//		for(int i = 0;i<person.length;i++) {
//			int age1 = person[i].getAge();
//			String name1 = person[i].getName();
//			System.out.println(name1 + "  "+age1 );
//		}
	}
}
