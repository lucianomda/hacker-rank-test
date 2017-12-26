package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 * Java String Reverse
 *
 * @author lucianomda
 */
public class JavaStringReverse {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		sc.close();

		StringBuilder sb = new StringBuilder(a);
		System.out.println(sb.reverse().toString().equals(a) ? "Yes" : "No");
	}
}
