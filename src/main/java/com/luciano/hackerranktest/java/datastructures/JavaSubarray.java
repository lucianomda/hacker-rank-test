package com.luciano.hackerranktest.java.datastructures;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem
 * Java Subarray
 *
 * @author lucianomda
 *
 */
public class JavaSubarray {
	private final int[] array;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		sc.close();

		JavaSubarray javaSubarray = new JavaSubarray(array);
		System.out.println(javaSubarray.countNegativeSubarrays());
	}

	public JavaSubarray(int[] array) {
		this.array = array;
	}

	public int countNegativeSubarrays() {
		int count = 0;
		for (int length = 1; length <= array.length; length++) {
			for (int initIndex = 0; initIndex + length <= array.length; initIndex++) {
				if (isNegativeSubArray(initIndex, length)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isNegativeSubArray(int initIndex, int length) {
		return calculateSubarraySum(initIndex, length) < 0;
	}

	private int calculateSubarraySum(int initIndex, int length) {
		int sum = 0;
		for (int i = initIndex; i < initIndex + length; i++) {
			sum += array[i];
		}
		return sum;
	}
}

