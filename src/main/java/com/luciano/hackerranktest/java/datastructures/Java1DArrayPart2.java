package com.luciano.hackerranktest.java.datastructures;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 * Java 1D Array (Part 2)
 *
 * @author lucianomda
 *
 */
public class Java1DArrayPart2 {

	public static boolean canWin(final int leap, final int[] game, final int i) {
		boolean result = false;
		game[i] = 1;

		if (i == game.length -1 || i + leap >= game.length) {
			result = true;
		} else {
			if(game[i + leap] == 0 && canWin(leap, game, i + leap)) {
				result = true;
			} else if (game[i + 1] == 0 && canWin(leap, game, i + 1)) {
				result = true;
			} else if (i > 0 && game[i - 1] == 0 && canWin(leap, game, i - 1)) {
				result = true;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
		}
		scan.close();
	}
}
