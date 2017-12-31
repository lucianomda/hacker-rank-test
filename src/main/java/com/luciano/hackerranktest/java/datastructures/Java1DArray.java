package com.luciano.hackerranktest.java.datastructures;

import java.util.*;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-1d-array-introduction/problem
 * Java 1D Array
 *
 * @author lucianomda
 *
 */
public class Java1DArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		// Declare array a here
		int[] a = new int[n];
		for(int i = 0 ; i < n; i++){
			int val = scan.nextInt();
			a[i] = val;
		}

		scan.close();

		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

