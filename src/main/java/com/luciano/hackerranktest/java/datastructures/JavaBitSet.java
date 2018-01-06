package com.luciano.hackerranktest.java.datastructures;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * Java Deque
 *
 * @author lucianomda
 *
 */
public class JavaBitSet {

	private static final String AND = "AND";
	private static final String OR = "OR";
	private static final String XOR = "XOR";
	private static final String SET = "SET";
	private static final String FLIP = "FLIP";

	private final BitSet b1 = new BitSet();
	private final BitSet b2 = new BitSet();

	public JavaBitSet(int n) {
		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);
	}

	public String cardinality() {
		return String.format("%d %d", b1.cardinality(), b2.cardinality());
	}

	public void operation(String operation, int a, int b) {
		switch (operation) {
			case AND:
				and(a, b);
				break;
			case OR:
				or(a, b);
				break;
			case XOR:
				xor(a, b);
				break;
			case FLIP:
				flip(a, b);
				break;
			case SET:
				set(a, b);
				break;
		}
	}

	private void and(int set0, int set1) {
		BitSet bitSet0 = getBitSet(set0);
		BitSet bitSet1 = getBitSet(set1);
		bitSet0.and(bitSet1);
	}

	private void or(int set0, int set1) {
		BitSet bitSet0 = getBitSet(set0);
		BitSet bitSet1 = getBitSet(set1);
		bitSet0.or(bitSet1);
	}

	private void xor(int set0, int set1) {
		BitSet bitSet0 = getBitSet(set0);
		BitSet bitSet1 = getBitSet(set1);
		bitSet0.xor(bitSet1);
	}

	private void set(int set, int index) {
		BitSet bitSet = getBitSet(set);
		bitSet.set(index, true);
	}

	private void flip(int set, int index) {
		BitSet bitSet = getBitSet(set);
		bitSet.flip(index);
	}

	private BitSet getBitSet(int set) {
		return set == 1 ? b1 : b2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		JavaBitSet javaBitSet = new JavaBitSet(n);
		for (int i = 0; i < m; i++) {
			in.nextLine();
			javaBitSet.operation(in.next(), in.nextInt(), in.nextInt());
			System.out.println(javaBitSet.cardinality());
		}
	}
}
