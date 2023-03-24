package com.jspiders;

public class Student {
	String id;
	String name;
	int age;
	double marks;
	private static int count=101;
	
	public Student(String name, int age, double marks) {
		super();
		this.id="JSP"+count;
		this.name = name;
		this.age = age;
		this.marks = marks;
		count++;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getMarks() {
		return marks;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + "]";
	}
	

}
