package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/between-two-sets/problem
 * Between two sets
 *
 * @author lucianomda
 *
 */
public class BetweenTwoSets {

	static int getTotalX(int[] a, int[] b) {
		IntPredicate intPredicate = a.length < b.length
				? x -> testA(a, x) && testB(b, x)
				: x -> testB(b, x) && testA(a, x);
		return (int) IntStream.range(1, 101).filter(intPredicate).count();
	}

	static boolean testA(int[] a, int x) {
		return Arrays.stream(a).allMatch(ai -> x % ai == 0);
	}

	static boolean testB(int[] b, int x) {
		return Arrays.stream(b).allMatch(bi -> bi % x == 0);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];

		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for(int b_i = 0; b_i < m; b_i++){
			b[b_i] = in.nextInt();
		}
		int total = getTotalX(a, b);
		System.out.println(total);
		in.close();
	}
}
