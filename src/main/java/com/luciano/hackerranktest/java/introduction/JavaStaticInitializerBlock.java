package com.luciano.hackerranktest.java.introduction;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-static-initializer-block/problem
 * Java Static Initializer Block
 *
 * @author lucianomda
 */
public class JavaStaticInitializerBlock {

	private static int B;
	private static int H;
	private static boolean flag;

	static {
		Scanner sc = new Scanner(System.in);
		B = sc.nextByte();
		H = sc.nextByte();
		sc.close();
		if (B <= 0 || H <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		} else {
			flag = true;
		}
	}

	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
	}
}
