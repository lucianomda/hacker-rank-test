package com.luciano.hackerranktest.java.introduction;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-loops-i/problem
 * Java Loops I
 * 
 * @author lucianomda
 *
 */
public class JavaLoops1 {

	public static void main(String[] args) {
		int numberOfMultiples = 10;
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.close();
		if (n < 2 || n > 20) {
			throw new IllegalArgumentException("n must be between 2 and 20 (inclusive).");
		}
		
		for (int i = 1; i <= numberOfMultiples; i++) {
			System.out.printf("%d x %d = %d\n", n, i, n*i);
		}
	}
}
