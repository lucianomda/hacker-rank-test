package com.luciano.hackerranktest.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-primality-test/problem
 * Java Primality Test
 *
 * @author lucianomda
 *
 */
public class JavaPrimalityTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger n = in.nextBigInteger();

		in.close();
		// Write your code here.
		if (n.isProbablePrime(100)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}
}
