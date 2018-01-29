package com.luciano.bairesdev;

import java.util.Scanner;

public class AlmostPalindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();
		System.out.println(isAlmostPalindrome(s));

	}

	public static boolean isAlmostPalindrome(String s) {
		int half = s.length() / 2;
		int count = 0;
		int i = 0;
		while (i < half && count < 2) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				count++;
			}
			i++;
		}
		return count < 2;
	}
 }
