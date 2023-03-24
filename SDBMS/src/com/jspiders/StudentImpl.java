package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidStudentException;
import com.customexception.StudentNotFoundException;

import sortinglogic.SortStudentByAge;
import sortinglogic.SortStudentById;
import sortinglogic.SortStudentByMarks;
import sortinglogic.SortStudentByName;

public class StudentImpl implements StudentManagementSystem{
	/**
	 * 
	 * @author DELL
	 * @since 2022
	 * we are adding implementation for 8 abstract methods studentmanagementsystem
	 */

	//collection-->DataBase-->Map & LinkedHashMap -->key(String)-->value(Student)
	//scanner

	Map<String,Student> db=new LinkedHashMap<String,Student>();
	Scanner scan=new Scanner(System.in);

	@Override
	public void addStudent() 
	{
		//accept name,age,marks
		//student object
		System.out.println("Enter Student Name:");
		String name=scan.next();
		System.out.println("Enter Student Age:");
		int age=scan.nextInt();
		System.out.println("Enter Student Marks:");
		double marks=scan.nextDouble();

		Student s=new Student(name,age,marks);

		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student Id is "+s.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student id");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student obj=db.get(id);
			System.out.println("name:"+obj.getName());
			System.out.println("age:"+obj.getAge());
			System.out.println("marks:"+obj.getMarks());
			//System.out.println(obj);//toString() is overridden--optional
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record Not Found");
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() 
	{
		Set<String>keys=db.keySet();//"JSP101","JSP102"
		System.out.println("Student Records Are As Follows");
		System.out.println("----------------------------");
		if(db.size()!=0)
		{
			for(String key:keys)
			{
				System.out.println(db.get(key));//printing reference variable
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Data Not Available");
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() {
		System.out.println("enter Student the id");
		//String id=scan.next().toUpperCase();
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			db.remove(id);
			System.out.println("data removed successfully");
		}
		else {
			{
				try {
					throw new StudentNotFoundException("Student Data Deleted");
				}
				catch(StudentNotFoundException e)
				{

					System.out.println(e.getMessage());
				}
			}
		}

	}

	@Override
	public void removeAllStudents() {
		System.out.println(db.size()+"Student Data Present");
		db.clear();
		System.out.println("All Student Data Deleted");

	}

	@Override
	public void updateStudent() {
		//Accept id  & uppercase ,containskey,get the student object
		// switch case 1: update name,age,marks
		//invoke exception
		System.out.println("enter id ");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student stud=db.get(id);
			System.out.println("1:Update name\n2:update age\n3:update marks");
			System.out.println("enter choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println(" Enter name");
				String name=scan.next();
				stud.setName(name);
				System.out.println("Name update successfully");
				break;
			case 2:
				System.out.println(" Enter age");
				int age=scan.nextInt();
				stud.setAge(age);
				System.out.println("age update successfully");
				break;
			case 3:
				System.out.println(" Enter marks");
				int marks=scan.nextInt();
				stud.setMarks(marks);
				System.out.println("marks update successfully");
				break;
			default:{
				try {
					throw new InvalidStudentException("invalid choice");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			}
			//switch case1:
		}
		else {
			try {
				throw new StudentNotFoundException("Student record nod found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}

	@Override
	public void countStudents() {
		System.out.println("The Student Records Are "+db.size());

	}

	@Override
	public void sortStudents() {
		/**
		 *convert map into set -> keyset()
		 * 
		 * */
		 

		Set<String>keys=db.keySet();//"JSP101", "JSP102"


		//list & ArrayList -> student
		List<Student> list=new ArrayList<Student>();

		for(String key:keys)
		{
			list.add(db.get(key));//adding student objects from map to list
		}

		System.out.println("1.sort by id\n2.sort by name\n3.sort by age\n4.sort by marks");
		System.out.println("enter choice");
		int ch=scan.nextInt();
		switch(ch)
		{
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;

		case 2:
			Collections.sort(list, new SortStudentByName());
			display(list);
			break;

		case 3:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;

		case 4:
			Collections.sort(list, new SortStudentByMarks());
			display(list);
			break;

		default:
			try {
				throw new InvalidStudentException("Invalid Choice!!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}
	private static void display(List<Student> list)
	{
		for(Student s:list)
		{
			System.out.println(s);
		}
	}
}
