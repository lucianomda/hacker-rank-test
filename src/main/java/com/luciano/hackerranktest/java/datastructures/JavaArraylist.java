package com.luciano.hackerranktest.java.datastructures;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 * Java Arraylist
 *
 * @author lucianomda
 *
 */
public class JavaArraylist {

	private static final String ERROR = "ERROR!";
	private final ArrayList<ArrayList<Integer>> lines;

	public JavaArraylist(ArrayList<ArrayList<Integer>> arrayList) {
		this.lines = arrayList;
	}

	public String getPosition(int x, int y) {
		x--;
		y--;
		String result = ERROR;
		if (x < lines.size() && y < lines.get(x).size()) {
			result = lines.get(x).get(y).toString();
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		ArrayList<ArrayList<Integer>> lines = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			int d = scanner.nextInt();
			ArrayList<Integer> columns = new ArrayList<>(d);
			for (int j = 0; j < d; j++) {
				columns.add(Integer.valueOf(scanner.next()));
			}
			lines.add(columns);
		}

		JavaArraylist javaArraylist = new JavaArraylist(lines);
		int q = scanner.nextInt();
		for (int query = 0; query < q; query++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			System.out.println(javaArraylist.getPosition(x, y));
		}
		scanner.close();
	}
}
