package com.luciano.hackerranktest.algorithms.implementation;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * Breaking the records
 *
 * @author lucianomda
 *
 */
public class BreakingTheRecords {

	static int[] breakingRecords(int[] score) {
		int lowest = score[0];
		int highest = score[0];
		int breakLowCount = 0;
		int breakHighCount = 0;

		for (int i = 1; i < score.length; i++) {
			if (lowest > score[i]) {
				lowest = score[i];
				breakLowCount++;
			} else if (highest < score[i]) {
				highest = score[i];
				breakHighCount++;
			}
		}

		return new int[] {breakHighCount, breakLowCount};
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] score = new int[n];
		for(int score_i = 0; score_i < n; score_i++){
			score[score_i] = in.nextInt();
		}
		int[] result = breakingRecords(score);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}
