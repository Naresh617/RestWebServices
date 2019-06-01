package com.apspdcl.modal;

import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>
{
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	public static List<Student> getStudentList()
	{
		Student s1=new Student("Naresh", 21);
		Student s2=new Student("Mahesh",23);
		Student s3=new Student("Arun",50);
		
		List<Student> list=Arrays.asList(s1,s2,s3);
		return list;
	}
	@Override
	public int compareTo(Student o) {
		
		return name.compareTo(o.getName());
	}
}
