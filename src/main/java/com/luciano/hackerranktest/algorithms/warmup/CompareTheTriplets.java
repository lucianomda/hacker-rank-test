package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 * Compare The triplets
 *
 * @author lucianomda
 *
 */
public class CompareTheTriplets {

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
		int[] scores = {0, 0};
		rate(scores, a0, b0);
		rate(scores, a1, b1);
		rate(scores, a2, b2);
		return scores;
	}

	private static void rate(int[] scores, int ai, int bi) {
		if (ai > bi) {
			scores[0]++;
		} else if (ai < bi) {
			scores[1]++;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a0 = in.nextInt();
		int a1 = in.nextInt();
		int a2 = in.nextInt();
		int b0 = in.nextInt();
		int b1 = in.nextInt();
		int b2 = in.nextInt();
		int[] result = solve(a0, a1, a2, b0, b1, b2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");


	}
}
