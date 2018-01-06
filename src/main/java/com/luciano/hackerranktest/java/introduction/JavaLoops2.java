package com.luciano.hackerranktest.java.introduction;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-loops/problem
 * Java Loops II
 *
 * @author lucianomda
 *
 */
public class JavaLoops2 {

	public static void main(String[] args) {
		int[][] queries = readQueries();
		long[] sequence;
		for (int i = 0; i < queries.length; i++) {
			sequence = calculateSequence(queries[i]);
			printSequence(sequence);
		}
	}

	private static int[][] readQueries() {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int[][] queries = new int[q][];
		for (int i = 0; i < q; i++) {
			int[] queryEntries = new int[3];
			queryEntries[0] = in.nextInt(); // a
			queryEntries[1] = in.nextInt(); // b
			queryEntries[2] = in.nextInt(); // n
			queries[i] = queryEntries;
		}

		in.close();
		return queries;
	}

	/**
	 * use only for testing
	 * @return A mocked query.
	 */
	private static int[][] mockQueries() {
		int[][] queries = {{0, 2, 10}, {5, 3, 5}};
		return queries;
	}

	private static long[] calculateSequence(int[] queryEntry) {
		int a = queryEntry[0];
		int b = queryEntry[1];
		int n = queryEntry[2];
		long[] sequence = new long[n];
		long sum = a;
		for (int i = 0; i < n; i++) {
			sum += (long) Math.pow(2, i) * b;
			sequence[i] = sum;
		}
		return sequence;
	}

	private static void printSequence(long[] sequence) {
		StringBuilder sb = new StringBuilder();
		for (long aSequence : sequence) {
			sb.append(aSequence).append(" ");
		}
		System.out.println(sb.toString());
	}
}
