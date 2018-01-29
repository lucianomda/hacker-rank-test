package com.luciano.bairesdev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

	private static Map<String, Integer> getLetterCountMap(String word) {
		Map<String, Integer> result = new HashMap<>(word.length());
		for (int i = 0; i < word.length(); i++) {
			String letter = String.valueOf(word.charAt(i));
			if (result.get(letter) == null) {
				result.put(letter, 1);
			} else {
				result.put(letter, result.get(letter) + 1);
			}
		}

		return result;
	}

	private static boolean hasSameLetters(Map<String, Integer> m0, Map<String, Integer> m1) {
		boolean result = true;
		if (m0.size() != m1.size()) {
			result = false;
		} else {
			for (String letter : m0.keySet()) {
				if (m0.get(letter) != m1.get(letter)) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	private static List<String> getAnagrams(String word) throws FileNotFoundException {
		ClassLoader classLoader = Anagrams.class.getClassLoader();
		File f = new File(classLoader.getResource("wl.txt").getFile());

		Scanner sc = new Scanner(f);
		Map<String, Integer> lettersCountMap = getLetterCountMap(word);
		List<String> anagrams = new ArrayList<>();

		while(sc.hasNextLine()) {
			String tempWord = sc.nextLine();
			if (word.length() == tempWord.length()) {
				Map<String, Integer> tempLettersCountMap = getLetterCountMap(tempWord);
				if (hasSameLetters(lettersCountMap, tempLettersCountMap)) {
					anagrams.add(tempWord);
				}
			}
		}
		sc.close();

		return anagrams;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		in.close();
		System.out.println(getAnagrams(word.toLowerCase()));
	}
}
