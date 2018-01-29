package com.luciano.bairesdev;

import java.util.Scanner;

public class AverageDistanceBetween3Points {
	static double calcAverageDistance(int x1, int y1, int x2, int y2, int x3, int y3) {
		double d1 = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		double d2 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
		double d3 = Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));

		return (d1 + d2 + d3) / 3;
	}

	public static void main(String[] args) {
		// Read 6 integers separated by whitespaces in one line from stdin in following order: x1 y1 x2 y2 x3 y3.
		Scanner in = new Scanner(System.in);
		System.out.println(calcAverageDistance(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
		in.close();
	}
}
