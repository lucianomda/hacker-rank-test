package com.luciano.hackerranktest.java.datastructures;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-2d-array/problem
 * Java 2D Array
 *
 * @author lucianomda
 *
 */
public class Java2DArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int m = 6;
		final int n = 6;
		int array[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		scanner.close();

		int max = -9 * 7;
		int hourglassSum = max;
		for (int i = 0; i < m - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				hourglassSum = calculateHourglassSum(array, i, j);
				if (max < hourglassSum) {
					max = hourglassSum;
				}
			}
		}
		System.out.println(max);
	}

	private static int calculateHourglassSum(final int[][] array, final int row, final int column) {
		return array[row][column] + array[row][column + 1] + array[row][column + 2]
				+ array[row + 1][column + 1]
				+ array[row + 2][column] + array[row + 2][column + 1] + array[row + 2][column + 2];
	}
}
