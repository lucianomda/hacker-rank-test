package com.luciano.hackerranktest.java.advanced;

import java.util.Scanner;

class Flower {
	String whatsYourName() {
		return "I have many names and types.";
	}
}

class Jasmine extends Flower {

	@Override
	String whatsYourName() {
		return "Jasmine";
	}
}

class Lily extends Flower {

	@Override
	String whatsYourName() {
		return "Lily";
	}
}

class Lotus extends Flower {

	@Override
	String whatsYourName() {
		return "Lotus";
	}
}

class State {

	Flower yourNationalFlower() {
		return new Flower();
	}
}

class WestBengal extends State {

	@Override
	Jasmine yourNationalFlower() {
		return new Jasmine();
	}
}

class Karnataka extends State {

	@Override
	Lotus yourNationalFlower() {
		return new Lotus();
	}
}

class AndhraPradesh extends State {

	@Override
	Lily yourNationalFlower() {
		return new Lily();
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-reflection-attributes/problem
 * Java Annotations
 *
 * @author lucianomda
 *
 */
public class CovariantReturnTypes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			State state = (State) Class.forName("com.luciano.hackerranktest.java.advanced." + in.nextLine()).newInstance();

			System.out.println(state.yourNationalFlower().whatsYourName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}

