package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 * Tag Content Extractor
 *
 * @author lucianomda
 *
 */
public class TagContentExtractor {

	private static final Pattern VALID_TAG_PATTERN = Pattern.compile("<([^>]+)>([^<]+)</\\1>");

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		while(testCases>0){
			String line = in.nextLine();
			Matcher m = VALID_TAG_PATTERN.matcher(line);
			boolean hasValidTag = false;

			while (m.find()) {
				System.out.println(m.group(2));
				hasValidTag = true;
			}

			if (!hasValidTag) {
				System.out.println("None");
			}
			testCases--;
		}

		in.close();
	}
}
