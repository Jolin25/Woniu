package com.woniuxy.library.dao.po;

import java.io.Serializable;

/**
 * 书籍类：数据类 属性：书籍编号：String id；书籍名称：String name；书籍种类：String type；
 * 书籍数量：int number；
 * 是否借出：boolean isOut
 * 
 * @author 小虫子的小日常
 *
 */
public class Book implements Serializable  {
	
	//属性
	private String id;//避免主键约束？？啥意思
	private String name;
	private String type;
	private int number;
	private boolean isOut;
	/*
	 * 构造方法
	 */
	public Book(String id, String name, String type, int number, boolean isOut) {
		
		this.id = id;
		this.name = name;
		this.type = type;
		this.number = number;
		this.isOut = isOut;
	}
	/*
	 * getter,setter
	 */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isOut() {
		return isOut;
	}
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isOut ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	/*
	 * equals,hashCode
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isOut != other.isOut)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
