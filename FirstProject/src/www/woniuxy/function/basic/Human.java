package www.woniuxy.function.basic;
/*
 * 
 * 人类
 * 
 */
public class Human {
	//属性
	public String name;
	public int age;
	// public int weight;
	public char sex;
	//行为
	public void eat() {
		System.out.print("我在吃东西，");
	}
	public void walk() {
		System.out.print("我在走路，");
	}
	public void os() {
		System.out.print("这里还有好多我这样的人类，妈耶。。。救我。。 我要回家。。\n");
	}
	public void showMe() {
		//walk();
		
		System.out.print("我叫"+name+",性别："+sex+",今年" + age+"岁。\n");
		//os();
	}
	//构造函数
	public Human(String name,int age,char sex) {
		this.name = name;//this.name为成员变量
		this.age = age;
		this.sex = sex;
	}
	
	
}

