package com.woniuxy.basic.abstract1;

public class TestShape {
public static void main(String[] args) {
	
	Circle c = new Circle(3);
	c.zhouChang();
	c.mianJi();
	
	
	Rectangle r = new Rectangle(22, 2);
	r.zhouChang();
	r.mianJi();
	
    CongruentTriangle con = new CongruentTriangle(10, 12, 13);
    con.mianJi();
	
	
}
}
