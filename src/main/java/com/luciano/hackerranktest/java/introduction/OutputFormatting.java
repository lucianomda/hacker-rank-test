package com.luciano.hackerranktest.java.introduction;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-output-formatting/problem Java
 * Output formatting
 * 
 * @author lucianomda
 *
 */
public class OutputFormatting {

	public static void main(String[] args) {
		int numberOfLines = 3;
		String[] stringArray = new String[numberOfLines];
		int[] intArray = new int[numberOfLines];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numberOfLines; i++) {
			stringArray[i] = sc.next();
			intArray[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("================================");
		for (int i = 0; i < numberOfLines; i++) {
			System.out.printf("%-15.15s%03d\n", stringArray[i], intArray[i]);
		}
		System.out.println("================================");
	}
}
