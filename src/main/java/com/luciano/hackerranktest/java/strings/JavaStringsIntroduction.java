package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-strings-introduction/problem
 * Java Strings Introduction
 *
 * @author lucianomda
 */
public class JavaStringsIntroduction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		sc.close();

		System.out.println(a.length() + b.length());
		System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");
		StringBuilder sb = new StringBuilder();
		sb.append(a.substring(0, 1).toUpperCase())
				.append(a.substring(1))
				.append(" ")
				.append(b.substring(0, 1).toUpperCase())
				.append(b.substring(1));
		System.out.println(sb.toString());
	}
}
