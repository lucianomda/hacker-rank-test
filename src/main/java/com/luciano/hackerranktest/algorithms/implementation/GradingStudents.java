package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/grading/problem
 * Grading Students
 *
 * @author lucianomda
 *
 */
public class GradingStudents {

	private static int[] solve(int[] grades) {
		final int n = grades.length;
		int[] result = new int[grades.length];
		for (int i = 0; i < n; i++) {
			result[i] = grades[i] < 38 ? grades[i] : round(grades[i]);
		}

		return result;
	}

	private static int round(int grade) {
		int mod = grade % 5;
		int diff = 5 - mod;

		return diff < 3 ? grade + diff : grade;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for(int grades_i=0; grades_i < n; grades_i++){
			grades[grades_i] = in.nextInt();
		}
		in.close();

		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%d\n", result[i]);
		}
	}
}
