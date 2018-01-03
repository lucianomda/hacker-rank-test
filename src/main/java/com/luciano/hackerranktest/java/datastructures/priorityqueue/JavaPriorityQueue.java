package com.luciano.hackerranktest.java.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class Student {

	private int id;
	private String name;
	private double cgpa;

	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student> {

	public int compare(Student s0, Student s1) {
		int result = s0.getCgpa() < s1.getCgpa() ? 1 : (s0.getCgpa() > s1.getCgpa() ? -1 : s0.getName().compareTo(s1.getName()));
		if (result == 0) {
			result = s0.getId() > s1.getId() ? 1 : (s0.getId() < s1.getId() ? -1 : 0);
		}
		return result;
	}
}

class Priorities {

	public List<Student> getStudents(List<String> events) {
		StudentComparator studentComparator = new StudentComparator();
		PriorityQueue<Student> q = new PriorityQueue<>(events.size(), studentComparator);

		for (String event : events) {
			if (event.equals("SERVED")) {
				q.poll();
			} else {
				q.add(parseStudent(event));
			}
		}

		return toPendingStudentList(q, studentComparator);
	}

	private Student parseStudent(String event) {
		Scanner sc = new Scanner(event);
		sc.next();
		String name = sc.next();
		double cpqa = sc.nextDouble();
		int id = sc.nextInt();
		sc.close();
		return new Student(id, name, cpqa);
	}

	private List<Student> toPendingStudentList(PriorityQueue<Student> q, StudentComparator studentComparator) {
		Student[] studentArray = new Student[q.size()];
		Arrays.sort(q.toArray(studentArray), studentComparator);
		return Arrays.asList(studentArray);
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 * Java Priority Queue
 *
 * NOTE: this class is not in 'java.datastructures' package because it already has Student class.
 * @author lucianomda
 *
 */
public class JavaPriorityQueue {

	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st: students) {
				System.out.println(st.getName());
			}
		}
	}
}
