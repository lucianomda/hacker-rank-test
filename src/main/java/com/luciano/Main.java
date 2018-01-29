package com.luciano;

import com.luciano.bairesdev.Anagrams;

public class Main {

	public static void main(String[] args) {
		try {
			Anagrams.main(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
