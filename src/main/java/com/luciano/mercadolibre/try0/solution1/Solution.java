package com.luciano.mercadolibre.try0.solution1;
import java.io.*;
import java.util.*;

/**
 * Cut the sticks
 */
public class Solution {

	/*
	 * Complete the function below.
	 */
	static int[] cutSticks(int[] lengths) {
		List<Integer> results = new LinkedList<>();
		int n = lengths.length;
		while(n > 0) {
			results.add(lengths.length);
			int min = Arrays.stream(lengths).min().getAsInt();
			for (int i = 0; i < n; i++) {
				int cuttedLength = lengths[i] - min;
				lengths[i] = cuttedLength > 0 ? cuttedLength : 0;
			}
			lengths = Arrays.stream(lengths).filter(l -> l > 0).toArray();
			n = lengths.length;
		}

		return results.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
//		final String fileName = System.getenv("OUTPUT_PATH");
//		BufferedWriter bw = null;
//		if (fileName != null) {
//			bw = new BufferedWriter(new FileWriter(fileName));
//		}
//		else {
//			bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		}
//
//		int[] res;
//		int lengths_size = 0;
//		lengths_size = Integer.parseInt(in.nextLine().trim());
//
//		int[] lengths = new int[lengths_size];
//		for(int i = 0; i < lengths_size; i++) {
//			int lengths_item;
//			lengths_item = Integer.parseInt(in.nextLine().trim());
//			lengths[i] = lengths_item;
//		}
		int n = 1000;
		int[] res;
		int[] lengths = new int[n];
		for (int i = 0; i < n; i++) {
			lengths[i] = (int) (Math.random() * 1000 + 1);
		}
//		int[] lengths = new int[] {5,4,4,2,2,8};
		res = cutSticks(lengths);
		for (int r : res) {
			System.out.println(r);
		}
//		for(int res_i = 0; res_i < res.length; res_i++) {
//			bw.write(String.valueOf(res[res_i]));
//			bw.newLine();
//		}

//		bw.close();
	}
}
