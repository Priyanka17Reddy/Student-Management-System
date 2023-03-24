package com.jspiders;

import java.util.Scanner;

import com.customexception.InvalidStudentException;

public class Solution {

	public static void main(String[] args) {

		//to accept input from the user
		Scanner sc=new Scanner(System.in);

		//UPCASTING FOR ACHIEVING ABSTRACTION
		StudentManagementSystem stud=new StudentImpl();
while(true) {
		System.out.println("student data base management");
		System.out.println("---------------------------------");

		System.out.println("1.Add Student\n2.Display Student\n3.Display All Students\n4.Remove Student\n"
				+ "5.Remove All Student\n6.Update Student\n7.Count Students\n8.Sort Students \n9.nExit");
		System.out.println("enter choice ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			stud.addStudent();
			break;

		case 2:
			stud.displayStudent();
			break;

		case 3:
			stud.displayAllStudents();
			break;

		case 4:
			stud.removeStudent();
			break;

		case 5:
			stud.removeAllStudents();
			break;

		case 6:
			stud.updateStudent();
			break;

		case 7:
			stud.countStudents();
			break;

		case 8:
			stud.sortStudents();
			break;

		default :
			try {
				throw new InvalidStudentException ("invalid choice");
			}
			catch(InvalidStudentException  e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
}
//menu driven program
//UPCASTING
//switch case
//system.exit(0);
//infinite loop-->while(true)
//custom exception