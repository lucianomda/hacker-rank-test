package com.luciano.mercadolibre.try0.solution2;

import java.util.Scanner;

/**
 * Sub Matrix Median
 */
public class Solution {

	private static int calculateMedian(int r1, int c1, int r2, int c2, int[][] matrix) {
		int result;
		int m = r2 - r1 + 1;
		int n = c2 - c1 + 1;
		int length = m * n;

		if (length % 2 != 0) {
			int i = (r1 + r2) / 2 - 1;
			int j = (c1 + c2) / 2 - 1;
			result = matrix[i][j];
		} else {
			int index = length > 1 ? length / 2 - 1 : 0;
			int i1 = index / n;
			int j1 = index % n;
			int i2 = (index + 1) / n;
			int j2 = (index + 1) % n;
			result = (matrix[r1 + i1 - 1][c1 + j1 - 1] + matrix[r1 + i2 - 1][c1 + j2 - 1]) / 2;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = in.nextInt();
			}
		}

		int q = in.nextInt();
		for (int qi = 0; qi < q; qi++) {
			int r1 = in.nextInt();
			int c1 = in.nextInt();
			int r2 = in.nextInt();
			int c2 = in.nextInt();
			System.out.println(calculateMedian(r1, c1, r2, c2, m));
		}
	}
}

/***
 case 0

 4
 1 3 2 4
 8 1 2 9
 1 1 2 2
 7 5 3 6
 3
 1 1 2 2
 1 2 3 4
 4 4 4 4

 expected
 5
 2
 6

 *************
 case 1

 3
 1 2 3
 4 5 6
 7 8 9
 3
 1 1 3 3
 1 1 2 2
 2 1 3 3

 expected
 5
 3
 6

 **************
 case 2

 5
 1 2 3 4 5
 6 7 8 9 1
 2 3 4 5 6
 7 8 9 1 2
 3 4 5 6 7
 5
 2 2 3 4
 3 1 5 4
 3 3 4 4
 2 1 5 1
 3 3 3 3

 expected
 6
 8
 7
 4
 4

 **************
 case 3
 8
 1 2 3 4 5 6 7 8
 9 8 7 6 5 4 3 2
 2 3 4 5 6 7 8 9
 3 4 5 6 7 8 9 1
 6 7 8 9 1 2 3 4
 6 5 4 3 2 1 9 8
 2 3 4 9 8 7 1 2
 9 1 2 8 3 7 4 6
 16
 8 8 8 8
 1 1 1 1
 3 3 3 3
 1 1 4 4
 3 3 6 6
 3 3 3 5
 3 3 3 6
 2 1 2 8
 2 1 2 7
 2 1 3 8
 2 1 3 7
 3 3 5 6
 1 2 1 3
 1 3 2 3
 2 2 4 3
 3 2 7 6

 expected
 6
 1
 4
 4
 8
 5
 5
 5
 6
 2
 2
 6
 2
 5
 3
 9

 **/
