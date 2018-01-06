package com.luciano.hackerranktest.java.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-stack/problem
 * Java Stack
 *
 * @author lucianomda
 *
 */
public class JavaStack {

	private static boolean isBalanced(String input) {
		if (input.length() == 0) {
			return true;
		}

		Deque<Character> stack = new ArrayDeque<>();
		boolean balanced = true;
		char[] chars = input.toCharArray();
		int i = 0;

		while (balanced && i < chars.length) {
			char c = chars[i];
			if (c == '{' || c == '(' || c == '[') {
				stack.push(c);
			} else if (stack.size() == 0 && (c == '}' || c == ')' || c == ']')) {
				balanced = false;
			} else if (stack.size() > 0) {
				char poppedChar = stack.pop();
				if (((c == '}' && poppedChar != '{')
						|| (c == ')' && poppedChar != '(')
						|| (c == ']' && poppedChar != '['))) {
					balanced = false;
				}
			}

			i++;
		}

		return balanced && stack.size() == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			System.out.println(isBalanced(input));
		}
	}
}
