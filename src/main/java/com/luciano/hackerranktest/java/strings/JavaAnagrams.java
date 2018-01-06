package com.luciano.hackerranktest.java.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-anagrams/problem
 * Java Anagrams
 *
 * @author lucianomda
 *
 */
public class JavaAnagrams {
	private static final Integer ZERO = Integer.valueOf(0);
	private static final Integer ONE = Integer.valueOf(1);

	static boolean isAnagram(String a, String b) {
		boolean result = false;
		if (a.length() == b.length()) {
			Map<String, Integer> aFrecuencies = new HashMap<>();
			Map<String, Integer> bFrecuencies = new HashMap<>();
			String charFromA;
			String charFromB;
			Integer aFrecuency;
			Integer bFrecuency;
			for (int i = 0; i < a.length(); i++) {
				charFromA = String.valueOf(a.charAt(i)).toUpperCase();
				aFrecuency = Integer.sum(aFrecuencies.getOrDefault(charFromA, ZERO), ONE);
				aFrecuencies.put(charFromA, aFrecuency);

				charFromB = String.valueOf(b.charAt(i)).toUpperCase();
				bFrecuency = Integer.sum(bFrecuencies.getOrDefault(charFromB, ZERO), ONE);
				bFrecuencies.put(charFromB, bFrecuency);
			}

			result = isAnagram(aFrecuencies, bFrecuencies);
		}
		return result;
	}

	private static boolean isAnagram(Map<String, Integer> aFrecuencies, Map<String, Integer> bFrecuencies) {
		boolean result = false;
		if (aFrecuencies.size() == bFrecuencies.size()) {
			long differentFrecuencies = aFrecuencies.keySet().stream()
					.filter(k -> !aFrecuencies.get(k).equals(bFrecuencies.get(k)))
					.count();
			result = differentFrecuencies == 0;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}
}
