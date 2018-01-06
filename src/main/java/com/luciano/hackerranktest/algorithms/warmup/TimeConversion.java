package com.luciano.hackerranktest.algorithms.warmup;

import java.util.Scanner;

/**
 * Solution for:
 * https://www.hackerrank.com/challenges/time-conversion/problem
 * Time Conversion
 *
 * @author lucianomda
 *
 */
public class TimeConversion {

	static String timeConversion(String s) {
		String hs = s.substring(0, 2);
		String period = s.substring(8, 10);
		int hi = Integer.parseInt(hs) % 12;
		if ("PM".equals(period)) {
			hi += 12;
		}
		return String.format("%02d" + s.substring(2, 8), hi);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = timeConversion(s);
		System.out.println(result);
	}
}
