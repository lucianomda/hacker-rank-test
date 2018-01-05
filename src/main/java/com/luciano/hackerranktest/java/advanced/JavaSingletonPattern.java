package com.luciano.hackerranktest.java.advanced;

import java.util.Scanner;

class Singleton {

	private static Singleton singleton;

	public String str;

	private Singleton() {
		// do nothing
	}

	public static Singleton getSingleInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}

		return singleton;
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-singleton/problem
 * Java Singleton Pattern
 *
 * @author lucianomda
 *
 */
public class JavaSingletonPattern {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Singleton.getSingleInstance().str = in.nextLine();
		in.close();
		System.out.printf("Hello I am a singleton! Let me say %s to you", Singleton.getSingleInstance().str);
	}
}
