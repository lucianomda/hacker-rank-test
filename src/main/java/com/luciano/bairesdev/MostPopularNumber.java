package com.luciano.bairesdev;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostPopularNumber {
	static Integer ZERO = Integer.valueOf("0");

	static int mostPopularNumber(int[] ar, int n) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Integer value = Integer.valueOf(ar[i]);
			if (countMap.get(value) == null) {
				countMap.put(value, ZERO);
			}
			Integer count = countMap.get(value);
			countMap.put(value, Integer.sum(count, 1));
		}

		int index = 0;
		int maxCount = 0;
		for (Integer key : countMap.keySet()) {
			if (maxCount < countMap.get(key)) {
				maxCount = countMap.get(key);
				index = key;
			} else if (maxCount == countMap.get(key)) {
				if (key < index) {
					index = key;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		in.close();
		int mostPopular = mostPopularNumber(ar, ar.length);
		System.out.println(mostPopular);
	}
}
