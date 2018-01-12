package com.luciano.mercadolibre.try0.solution0;

import java.util.*;

/**
 * FizzBuzz
 */
public class Solution {

	/*
	 * Complete the function below.
	 */
	static void fizzBuzz(int n) {
		boolean multipleOf3;
		boolean multipleOf5;
		for (int i = 1; i <= n; i++) {
			multipleOf3 = i % 3 == 0;
			multipleOf5 = i % 5 == 0;
			String out;
			if (multipleOf3 && multipleOf5) {
				System.out.println("FizzBuzz");
			} else if (multipleOf3) {
				System.out.println("Fizz");
			} else if (multipleOf5) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		n = Integer.parseInt(in.nextLine().trim());
		in.close();
		fizzBuzz(n);
	}
}
