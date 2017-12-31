package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 * Java String Tokens
 *
 * @author lucianomda
 *
 */
public class JavaStringTokens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		scan.close();

		String s1 = s.replaceAll("[\\s!,?._'@]+", " ").trim();
		if (s1.length() == 0) {
			System.out.println(0);
		} else {
			String[] tokens = s1.split("\\s+");
			System.out.println(tokens.length);
			for (String token : tokens) {
				System.out.println(token);
			}
		}
	}

// He is a very very good boy, isn't he?adsa.e_as!pP
}
