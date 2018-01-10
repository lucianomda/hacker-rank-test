package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 * Apple and orange
 *
 * @author lucianomda
 *
 */
public class AppleAndOrange {
	static int[] appleAndOrange(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int[] result = {0, 0};
		result[0] = (int) Arrays.stream(apples).filter(apple -> {
			int landingPoint = a + apple;
			return landingPoint >= s && landingPoint <=t;
		}).count();

		result[1] = (int) Arrays.stream(oranges).filter(orange -> {
			int landingPoint = b + orange;
			return landingPoint <=t && landingPoint >= s;
		}).count();

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		for(int apple_i = 0; apple_i < m; apple_i++){
			apple[apple_i] = in.nextInt();
		}
		int[] orange = new int[n];
		for(int orange_i = 0; orange_i < n; orange_i++){
			orange[orange_i] = in.nextInt();
		}
		int[] result = appleAndOrange(s, t, a, b, apple, orange);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");


		in.close();
	}
}
