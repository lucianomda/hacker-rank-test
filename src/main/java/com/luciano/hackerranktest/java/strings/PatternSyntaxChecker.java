package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
 * Pattern Syntax Checker
 *
 * @author lucianomda
 *
 */
public class PatternSyntaxChecker {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
			try {
				Pattern.compile(pattern);
				System.out.println("Valid");
			} catch (PatternSyntaxException pse) {
				System.out.println("Invalid");
			}
			testCases--;
		}
	}
}
