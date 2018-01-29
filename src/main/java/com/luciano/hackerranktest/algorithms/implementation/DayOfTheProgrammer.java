package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Scanner;

public class DayOfTheProgrammer {

	static boolean isJulianLeapYear(int year) {
		return year % 4 == 0;
	}

	static boolean isGregorianLeapYear(int year) {
		return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
	}

	static String solveGregorian(int year) {
		String result;
		if (isGregorianLeapYear(year)) {
			result = "12.09." + year;
		} else {
			result = "13.09." + year;
		}

		return result;
	}

	static String solveJulian(int year) {
		String result;
		if (isJulianLeapYear(year)) {
			result = "12.09." + year;
		} else {
			result = "13.09." + year;
		}

		return result;
	}

	static String solve(int year){
		String result;
		if (year > 1918) {
			result = solveGregorian(year);
		} else if (year < 1918) {
			result = solveJulian(year);
		} else {
			// Transition year (1918).
			result = "26.09.1918";
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year = in.nextInt();
		in.close();
		String result = solve(year);
		System.out.println(result);

		int count = 0;
		for (int i = 1; i<305;i++) {
			if (i%3 ==0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
