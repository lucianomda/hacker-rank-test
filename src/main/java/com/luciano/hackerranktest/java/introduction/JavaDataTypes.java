package com.luciano.hackerranktest.java.introduction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-datatypes/problem
 * Java Data Types
 *
 * @author lucianomda
 *
 */
public class JavaDataTypes {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			long x = 0;
			try {
				x = sc.nextLong();
			} catch (InputMismatchException e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
				continue;
			}

			System.out.println(x + " can be fitted in:");
			if (x >= -128 && x <= 127) {
				System.out.println("* byte");
				System.out.println("* short");
				System.out.println("* int");
				System.out.println("* long");
			} else if (x >= -32768 && x <= 32767){
				System.out.println("* short");
				System.out.println("* int");
				System.out.println("* long");
			} else if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
				System.out.println("* int");
				System.out.println("* long");
			} else {
				// No need to check long boundaries.
				System.out.println("* long");
			}
		}
	}
}
