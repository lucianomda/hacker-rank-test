package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * Birthday Chocolate
 *
 * @author lucianomda
 *
 */
public class BirthdayChocolate {

	static int solve(int n, int[] s, int d, int m){
		int count = 0;
		int lastValidI = n - m;
		for (int i = 0; i <= lastValidI; i++) {
			int sum = 0;
			int lastValidJ = i + m;
			for (int j = i; j < lastValidJ; j ++) {
				sum += s[j];
			}

			if (sum == d) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for(int s_i=0; s_i < n; s_i++){
			s[s_i] = in.nextInt();
		}
		int d = in.nextInt();
		int m = in.nextInt();
		int result = solve(n, s, d, m);
		System.out.println(result);
	}
}
