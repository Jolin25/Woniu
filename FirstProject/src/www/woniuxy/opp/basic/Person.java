package www.woniuxy.opp.basic;
/*
 * 为人类进行封装
 
 */
public class Person {
	private String name;
	private int age;
	//为name属性进行设值
	public void setName(String name) {
		this.name = name;//把传进来的name属性值赋值给成员变量name
	}
	//为age属性进行设值
	public void setAge(int age) {
		//对年龄进行合法性判断
//		if(age != 20) {
//			this.age = 20;
//		}else {
//		this.age = age;}   
//	
		this.age = age;
		}
	//为年龄属性取值
	public int getAge() {
		return age;
	}
	//为name属性取值
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "姓名"+name+"年龄"+age;
	}
}
