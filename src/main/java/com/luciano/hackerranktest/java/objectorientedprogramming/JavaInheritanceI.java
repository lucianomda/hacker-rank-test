package com.luciano.hackerranktest.java.objectorientedprogramming;

class Animal{
	void walk()
	{
		System.out.println("I am walking");
	}
}

class Bird extends Animal
{
	void fly()
	{
		System.out.println("I am flying");
	}

	void sing() {
		System.out.println("I am singing");
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-inheritance-1/problem
 * Java Inheritance I
 *
 * @author lucianomda
 */
public class JavaInheritanceI {
	public static void main(String args[]){

		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();

	}
}
