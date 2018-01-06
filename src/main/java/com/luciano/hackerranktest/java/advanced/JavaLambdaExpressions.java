package com.luciano.hackerranktest.java.advanced;

import java.io.*;
import java.util.*;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {

	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}
	/*** Beign of my code ***/

	public PerformOperation isOdd() {
		return  n -> n % 2 == 1;
	}

	public PerformOperation isPrime() {
		return n -> {
			boolean result = true;
			if (n > 3) {
				int squareRoot = (int) Math.sqrt(n);
				for (int i = 2; i <= squareRoot; i++) {
					if (n % i == 0) {
						result = false;
						break;
					}
				}
			}
			return result;
		};
	}

	public PerformOperation isPalindrome() {
		return n -> {
			int tmp = n;
			int reverse = 0;
			while (tmp != 0) {
				int remainder = tmp % 10;
				reverse = reverse * 10 + remainder;
				tmp = tmp / 10;
			}
			return n == reverse;
		};
	}
}
/*** End of my code ***/

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 * Lambda Expressions
 *
 * @author lucianomda
 *
 */
public class JavaLambdaExpressions {
	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T--> 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
