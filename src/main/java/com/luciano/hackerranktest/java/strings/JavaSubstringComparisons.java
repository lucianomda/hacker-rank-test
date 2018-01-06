package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-string-compare/problem
 * Java Substring Comparisons
 *
 * @author lucianomda
 *
 */
public class JavaSubstringComparisons {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest;
		String largest;

		TreeSet<String> substrings = new TreeSet<>();
		for (int i = 0; i + k <= s.length(); i++) {
			substrings.add(s.substring(i, i + k));
		}

		smallest = substrings.first();
		largest = substrings.last();

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
