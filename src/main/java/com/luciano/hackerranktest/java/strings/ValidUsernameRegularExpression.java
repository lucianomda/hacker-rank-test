package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/valid-username-checker/problem
 * Valid Username Regular Expression
 *
 * @author lucianomda
 *
 */
public class ValidUsernameRegularExpression {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int n = Integer.parseInt(scan.nextLine());
		while (n-- != 0) {
			String userName = scan.nextLine();

			if (userName.matches(UsernameValidator.regularExpression)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}
	}
}

class UsernameValidator {
	/*
	 * Write regular expression here.
	 */
	public static final String regularExpression = "[A-Za-z]\\w{7,29}";
}
