package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 * Diagonal Difference
 *
 * @author lucianomda
 *
 */
public class DiagonalDifference {

	static int diagonalDifference(int[][] a) {
		long diagonalDifference = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			diagonalDifference += a[i][i];
			diagonalDifference -= a[i][n - 1 - i];
		}
		return (int) Math.abs(diagonalDifference);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] a = new int[n][n];
		for(int a_i = 0; a_i < n; a_i++){
			for(int a_j = 0; a_j < n; a_j++){
				a[a_i][a_j] = in.nextInt();
			}
		}
		int result = diagonalDifference(a);
		System.out.println(result);
		in.close();
	}
}
