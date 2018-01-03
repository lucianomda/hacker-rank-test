package com.luciano.hackerranktest.java.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
 * Java Exception Handling (Try Catch)
 *
 * @author lucianomda
 *
 */
public class JavaExceptionHandlingTryCatch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(x/y);
		} catch (InputMismatchException ime) {
			System.out.println(ime.getClass().getCanonicalName());
		} catch (ArithmeticException ae) {
			System.out.println(ae.getClass().getCanonicalName() + ": / by zero");
		}
	}
}
