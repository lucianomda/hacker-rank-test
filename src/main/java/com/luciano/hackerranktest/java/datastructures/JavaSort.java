package com.luciano.hackerranktest.java.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student> {
	public int compare(Student s0, Student s1) {
		int result = s0.getCgpa() < s1.getCgpa() ? 1 : (s0.getCgpa() > s1.getCgpa() ? -1 : s0.getFname().compareTo(s1.getFname()));
		if (result == 0) {
			result = s0.getId() > s1.getId() ? 1 : (s0.getId() < s1.getId() ? -1 : 0);
		}
		return result;
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-sort/problem
 * Java Sort
 *
 * @author lucianomda
 */
public class JavaSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<>(testCases);
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		studentList.sort(new StudentComparator());

		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
