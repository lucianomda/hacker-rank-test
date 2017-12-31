package com.luciano.hackerranktest.java.strings;

import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-regex/problem
 * Java Regex
 *
 * @author lucianomda
 *
 */
public class JavaRegex {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String IP = in.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
	}
}

class MyRegex {
//	String pattern = "((25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9]{1,2})\\.){3}(25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9]{1,2})";
	String pattern = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])";
}
