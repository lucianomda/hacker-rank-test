package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 * Min Max Sum
 *
 * @author lucianomda
 *
 */
public class MinMaxSum {

	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		System.out.printf("%d %d",
				(long) arr[0] + arr[1] + arr[2] + arr[3],
				(long) arr[1] + arr[2] + arr[3] + arr[4]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for(int arr_i = 0; arr_i < 5; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		miniMaxSum(arr);
		in.close();
	}
}
