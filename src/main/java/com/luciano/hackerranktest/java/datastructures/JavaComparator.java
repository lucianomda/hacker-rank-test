package com.luciano.hackerranktest.java.datastructures;

import java.util.*;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-comparator/problem
 * Java Comparator
 *
 * @author lucianomda
 *
 */
public class JavaComparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for(int i = 0; i < n; i++){
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for(int i = 0; i < player.length; i++){
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}
}

class Player{
	String name;
	int score;

	Player(String name, int score){
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {

	public int compare(Player p0, Player p1) {
		return p0.score < p1.score ? 1 : (p0.score > p1.score ? -1 : p0.name.compareTo(p1.name));
	}
}
