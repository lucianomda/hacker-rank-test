package com.luciano.hackerranktest.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-biginteger/problem
 * Java BigInteger
 *
 * @author lucianomda
 *
 */
public class JavaBigInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.nextLine());
		BigInteger b = new BigInteger(sc.nextLine());
		sc.close();
		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
	}
}
