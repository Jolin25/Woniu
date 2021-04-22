package www.woniuxy.opp.basic;

import java.util.Scanner;

public class Test {
	public static void main(String[]args) {
		//实例化
		Person p = new Person();
		//先设值
		p.setAge(18);
		p.setName("momoko");
		//再取值
		String name = p.getName();
		int age = p.getAge();
		System.out.println("姓名："+name+",年龄："+age);
	//用数组保存对象
		Scanner sc = new Scanner(System.in);
		Person[] person = new Person[5];//创建数组
		for(int i =0;i<person.length-1;i ++) {
			person[i]=new Person();//创建对象
			//输入
			System.out.print("请输入姓名：");
			String name0 = sc.next();
			person[i].setName(name0);
			System.out.print("请输入年龄：");
			int age0 = sc.nextInt();
			person[i].setAge(age0);
			//int age1 = person[i].getAge();
			//String name1 = person[i].getName();
			//System.out.println(name1 + "  "+age1 );
			
		} 
		//System.out.println(person[4]);
		for(Person i:person) {
		//	System.out.println(i);
			
			System.out.println("姓名为："+i.getName()+"，年龄为："+i.getAge());/*当没有创建对象，
			无法调用方法时，则不会执行此句*/
													
		}
//for循环输出	
//		for(int i = 0;i<person.length;i++) {
//			int age1 = person[i].getAge();
//			String name1 = person[i].getName();
//			System.out.println(name1 + "  "+age1 );
//		}
	}
}
