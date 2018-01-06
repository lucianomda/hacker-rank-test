package com.luciano.hackerranktest.java.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/phone-book/problem
 * Java Map
 *
 * @author lucianomda
 *
 */
public class JavaMap {

	private static final String NOT_FOUND = "Not found";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		Map<String, String> phoneBook = new HashMap<>(n);

		for(int i=0;i<n;i++) {
			phoneBook.put(in.nextLine(), in.nextLine());
		}

		while(in.hasNextLine()) {
			String name = in.nextLine();
			String phone = phoneBook.get(name);
			if (phone != null) {
				System.out.printf("%s=%s\n", name, phone);
			} else {
				System.out.println(NOT_FOUND);
			}
		}

		in.close();
	}
}
