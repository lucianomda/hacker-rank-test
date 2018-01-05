package com.luciano.hackerranktest.java.advanced;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis
{
	public abstract int getResult();
	public abstract void visitNode(TreeNode node);
	public abstract void visitLeaf(TreeLeaf leaf);

}

/*** Begin of my code ***/

class SumInLeavesVisitor extends TreeVis {

	private int sum = 0;

	@Override
	public int getResult() {
		return sum;
	}

	@Override
	public void visitNode(TreeNode node) {
		// Do nothing.
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		sum += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {

	private static final int PRIME_NUMBER = 1000000007;
	private long subResult = 1;

	@Override
	public int getResult() {
		return (int)subResult;
	}

	@Override
	public void visitNode(TreeNode node) {
		if (node.getColor() == Color.RED) {
			subResult = (subResult * node.getValue()) % PRIME_NUMBER;
		}
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.RED) {
			subResult = (subResult * leaf.getValue()) % PRIME_NUMBER;
		}
	}
}

class FancyVisitor extends TreeVis {

	private int fancySubResult = 0;

	@Override
	public int getResult() {
		return Math.abs(fancySubResult);
	}

	@Override
	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			fancySubResult += node.getValue();
		}
	}

	@Override
	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN) {
			fancySubResult -= leaf.getValue();
		}
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 * Java Visitor Pattern
 *
 * @author lucianomda
 *
 */
public class JavaVisitorPattern {

	private static int[] readValues(Scanner in, int n) {
		int[] values = new int[n];
		for (int i = 0; i < n; i ++) {
			values[i] = in.nextInt();
		}

		return values;
	}

	private static Color[] readColors(Scanner in, int n) {
		Color[] colors = new Color[n];
		for (int i = 0; i < n; i++) {
			colors[i] = in.nextInt() == 0 ? Color.RED : Color.GREEN;
		}

		return colors;
	}

	private static Map<Integer, Set<Integer>> readEdges(Scanner in, int n) {
		Map<Integer, Set<Integer>> edgesMap = new HashMap<>(n - 1);
		for (int i = 0; i < n - 1; i++) {
			Integer ui = Integer.valueOf(in.nextInt() - 1);
			Integer vi = Integer.valueOf(in.nextInt() - 1);
			if (edgesMap.get(ui) == null) {
				Set<Integer> childIndexes = new HashSet<>();
				edgesMap.put(ui, childIndexes);
			}
			edgesMap.get(ui).add(vi);
			if (edgesMap.get(vi) == null) {
				Set<Integer> childIndexes = new HashSet<>();
				edgesMap.put(vi, childIndexes);
			}
			edgesMap.get(vi).add(ui);
		}

		return edgesMap;
	}

	private static Tree createTreeNodes(int[] values, Color[] colors, Map<Integer, Set<Integer>> edgesMap, int index, int depth) {
		TreeNode node = new TreeNode(values[index], colors[index], depth);
		Set<Integer> childIndexes = edgesMap.get(index);
		int childDepth = depth + 1;
		for (Integer childIndex : childIndexes) {
			edgesMap.get(childIndex).remove(index);
			Tree childNode;
			if (edgesMap.containsKey(childIndex) && !edgesMap.get(childIndex).isEmpty()) {
				childNode = createTreeNodes(values, colors, edgesMap, childIndex, childDepth);
			} else {
				childNode = new TreeLeaf(values[childIndex], colors[childIndex], childDepth);
			}
			node.addChild(childNode);
		}
		return node;
	}

	private static Tree solve() {
		//read the tree from STDIN and return its root as a return value of this function
		Scanner in = new Scanner(System.in);

		// This code creates a file with test data, then scanner can read from the file instead of stdin.
//		String path = System.getProperty("user.home") + "/test.txt");
//		CreateTestFile.createFile(path);
//		Scanner in = null;
//		try {
//			in = new Scanner(new File(path);
//		} catch (FileNotFoundException e) {
// 			e.printStackTrace();
//		}

		int n = in.nextInt();
		int[] values = readValues(in, n);
		Color[] colors = readColors(in, n);
		Map<Integer, Set<Integer>> edgesMap = readEdges(in, n);
		in.close();

		return createTreeNodes(values, colors, edgesMap, 0, 0);
	}

	/*** End of my code. ***/

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
