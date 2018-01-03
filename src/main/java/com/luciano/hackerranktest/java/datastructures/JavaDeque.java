package com.luciano.hackerranktest.java.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * Java Deque
 *
 * @author lucianomda
 */
public class JavaDeque {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		Deque<Integer> deque = new ArrayDeque<>(m);
		Set<Integer> set = new HashSet<>(m);

		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			if (deque.size() + 1 > m) {
				Integer polledNum = deque.pollFirst();
				if (!deque.contains(polledNum)) {
					set.remove(polledNum);
				}
			}
			deque.addLast(num);
			set.add(num);
			max = max > set.size() ? max : set.size();
		}

		in.close();
		System.out.println(max);
	}
}
