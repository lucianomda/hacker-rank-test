package com.luciano.hackerranktest.java.exceptionhandling;

import java.util.Scanner;

class MyCalculator {

	long power(int n, int p) throws Exception {
		if (n < 0 || p < 0) {
			throw new Exception("n or p should not be negative.");
		} else if (n == 0 && p == 0) {
			throw new Exception("n and p should not be zero.");
		}

		long pow = n;
		if (p == 0) {
			pow = 1;
		} else {
			for (int i = 0; i < p - 1; i++) {
				pow *= n;
			}
		}

		return pow;
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-exception-handling/problem
 * Java Exception Handling
 *
 * @author lucianomda
 *
 */
public class JavaExceptionHandling {

	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in .hasNextInt()) {
			int n = in .nextInt();
			int p = in .nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
