package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/plus-minus/problem
 * Plus Minus
 *
 * @author lucianomda
 *
 */
public class PlusMinus {

	static void plusMinus(int[] arr) {
		int positive = 0;
		int negative = 0;
		int zeros = 0;
		for (int ai : arr) {
			if (ai > 0) {
				positive++;
			} else if (ai < 0) {
				negative++;
			} else {
				zeros++;
			}
		}
		double length = arr.length;
		System.out.printf("%1.6f\n%1.6f\n%1.6f", positive / length, negative / length, zeros / length);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		plusMinus(arr);
		in.close();
	}
}
