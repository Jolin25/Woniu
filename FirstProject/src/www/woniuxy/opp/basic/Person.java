package www.woniuxy.opp.basic;
/*
 * Ϊ������з�װ
 
 */
public class Person {
	private String name;
	private int age;
	//Ϊname���Խ�����ֵ
	public void setName(String name) {
		this.name = name;//�Ѵ�������name����ֵ��ֵ����Ա����name
	}
	//Ϊage���Խ�����ֵ
	public void setAge(int age) {
		//��������кϷ����ж�
//		if(age != 20) {
//			this.age = 20;
//		}else {
//		this.age = age;}   
//	
		this.age = age;
		}
	//Ϊ��������ȡֵ
	public int getAge() {
		return age;
	}
	//Ϊname����ȡֵ
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "����"+name+"����"+age;
	}
}
