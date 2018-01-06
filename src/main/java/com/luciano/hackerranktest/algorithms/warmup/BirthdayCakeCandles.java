package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * BirthdayCakeCandles
 *
 * @author lucianomda
 *
 */
public class BirthdayCakeCandles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int max = 1;
		int count = 0;
		for(int ar_i = 0; ar_i < n; ar_i++){
			int hi = in.nextInt();
			if (max == hi) {
				count++;
			} else if (hi > max) {
				max = hi;
				count = 1;
			}
		}
		System.out.println(count);
	}
}
