package InterviewPrep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student1 {

	private int rollNum;
	private String name;
	private double marks;

	public Student1(int rollNum, String name, double marks) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.marks = marks;
	}

	public Student1() {
		super();
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student1 [rollNum=" + rollNum + ", name=" + name + ", marks=" + marks + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student1> studentsDetails = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("How many students you want to add : ");
		int numberOfStudents = sc.nextInt();

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println("Enter roll number : ");
			int rollNum = sc.nextInt();

			System.out.println("Enter roll name : ");
			String name = sc.next();

			System.out.println("Enter roll percentage : ");
			double marks = sc.nextDouble();

			studentsDetails.add(new Student1(rollNum, name, marks));
		}

		System.out.println(studentsDetails);

		Student1 topper = studentsDetails.get(0);

		for (Student1 student : studentsDetails) {
			if (topper.getMarks() < student.getMarks()) {
				topper = student;
			}
		}
		System.out.println("TOpper of the class is : ");
		System.out.println(topper);
	}

}
