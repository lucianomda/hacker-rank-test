package com.luciano.hackerranktest.java.datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-list/problem
 * Java List
 *
 * @author lucianomda
 *
 */
public class JavaList {

	public static final String INSERT = "Insert";
	public static final String DELETE = "Delete";

	private static void insert(List<Integer> list, int x, int y) {
		if (x >= list.size()) {
			list.add(y);
		} else {
			list.add(x, y);
		}
	}

	private static void delete(List<Integer> list, int x) {
		if (x < list.size()) {
			list.remove(x);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		int q = sc.nextInt();
		while (q-- > 0) {
			sc.nextLine();
			String query = sc.nextLine();
			if (query.contains(INSERT)) {
				insert(list, sc.nextInt(), sc.nextInt());
			} else if(query.contains(DELETE)) {
				delete(list, sc.nextInt());
			}
		}

		sc.close();
		list.forEach(s -> System.out.print(s + " "));
	}
}
