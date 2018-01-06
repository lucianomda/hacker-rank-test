package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Collections;
import java.util.Scanner;

/**
 * Solution for:
 *
 * Staircase
 *
 * @author lucianomda
 *
 */
public class Staircase {

	static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}

			for (int j = n - i; j < n; j++) {
				sb.append("#");
			}

			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		staircase(n);
		in.close();
	}
}
