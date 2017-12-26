package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-substring/problem
 * Java Substring
 *
 * @author lucianomda
 *
 */
public class JavaSubstring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int start = in.nextInt();
		int end = in.nextInt();
		System.out.println(s.substring(start, end));
	}
}
