package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 * A Very Big Sum
 *
 * @author lucianomda
 *
 */
public class AVeryBigSum {
	static long aVeryBigSum(int n, long[] ar) {
		return Arrays.stream(ar).sum();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] ar = new long[n];
		for(int ar_i = 0; ar_i < n; ar_i++){
			ar[ar_i] = in.nextLong();
		}
		long result = aVeryBigSum(n, ar);
		System.out.println(result);
	}
}
