package com.luciano.hackerranktest.java.objectorientedprogramming;

import java.util.Scanner;

interface AdvancedArithmetic{

	int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

	public int divisor_sum(int n) {
		int sum = n == 1 ? 1 : 1 + n;
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-interface/problem
 * Java Interface
 *
 * @author lucianomda
 *
 */
public class JavaInterface {

	public static void main(String []args){
		MyCalculator my_calculator = new MyCalculator();
		System.out.print("I implemented: ");
		ImplementedInterfaceNames(my_calculator);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(my_calculator.divisor_sum(n) + "\n");
		sc.close();
	}
	/*
	 *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
	 */
	static void ImplementedInterfaceNames(Object o){
		Class[] theInterfaces = o.getClass().getInterfaces();
		for (int i = 0; i < theInterfaces.length; i++){
			String interfaceName = theInterfaces[i].getName();
			System.out.println(interfaceName);
		}
	}
}