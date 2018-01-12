package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * Migratory Birds
 *
 * @author lucianomda
 *
 */
public class MigratoryBirds {

	static int migratoryBirds(int n, int[] ar) {
		int[] result = new int[5];
		for (int i = 0; i < n; i++) {
			result[ar[i] - 1]++;
		}

		int maxIndex = 0;
		for (int i = 1; i < 5; i++) {
			if (result[maxIndex] < result[i]) {
				maxIndex = i;
			}
		}

		return maxIndex + 1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];

		for(int ar_i = 0; ar_i < n; ar_i++){
			ar[ar_i] = in.nextInt();
		}
		in.close();
		int result = migratoryBirds(n, ar);
		System.out.println(result);
	}
}
