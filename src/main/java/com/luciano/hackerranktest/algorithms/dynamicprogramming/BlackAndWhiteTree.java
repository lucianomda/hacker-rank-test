package com.luciano.hackerranktest.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Edge {
	private final Integer u;
	private final Integer v;

	public Edge(Integer u, Integer v) {
		this.u = u;
		this.v = v;
	}

	public Integer getU() {
		return u;
	}

	public Integer getV() {
		return v;
	}
}

/**
 * Solution for
 * https://www.hackerrank.com/challenges/black-n-white-tree-1/problem
 * Black and white tree
 *
 * STILL INCOMPLETE
 * @author lucianomda
 */
public class BlackAndWhiteTree {

	private Map<Integer, Set<Integer>> graph;
	private Set<Integer> whites;
	private Set<Integer> blacks;
	private Set<Integer> undefined;
	private List<Edge> extraEdges;

	public BlackAndWhiteTree(int n) {
		graph = new HashMap<>(n);
		whites = new HashSet<>();
		blacks = new HashSet<>();
		undefined = IntStream.range(1, n + 1).boxed().collect(Collectors.toSet());
		extraEdges = new LinkedList<>();
	}

	public List<Edge> getExtraEdges() {
		return new ArrayList<>(extraEdges);
	}

	private void addEdge(int u, int v) {
		if (graph.get(u) == null) {
			graph.put(u, new HashSet<>());
		}

		if (graph.get(v) == null) {
			graph.put(v, new HashSet<>());
		}

		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	private int getD() {
		return whites.size() - blacks.size();
	}

	public int getAbsD() {
		return Math.abs(getD());
	}

	private boolean hasUndefined() {
		return undefined.size() > 0;
	}

	private Integer getUndefined() {
		Integer result = null;
		Iterator<Integer> it = undefined.iterator();
		if (it.hasNext()) {
			result = it.next();
		}
		return result;
	}

	private Integer getBlack() {
		Iterator<Integer> it = blacks.iterator();
		return it.hasNext() ? it.next() : null;
	}

	private void addWhite(Integer u) {
		Set<Integer> vSet = graph.get(u);

		undefined.remove(u);
		whites.add(u);
		if (vSet != null) {
			vSet.stream().filter(v -> undefined.contains(v)).forEach(this::addBlack);
		}
	}

	private void addBlack(Integer u) {
		Set<Integer> vSet = graph.get(u);

		undefined.remove(u);
		blacks.add(u);
		if (vSet != null) {
			vSet.stream().filter(v -> undefined.contains(v)).forEach(this::addWhite);
		}
	}

	public void fixGraph() {
		Integer whiteNode = Integer.valueOf(1);
		addWhite(whiteNode);
		Integer blackNode = getBlack();
		while(hasUndefined()) {
			Integer undefined = getUndefined();
			if (getD() >= 0) {
				addBlack(undefined);
				blackNode = undefined;
				extraEdges.add(new Edge(whiteNode, undefined));
			} else {
				addWhite(undefined);
				extraEdges.add(new Edge(blackNode, undefined));
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		BlackAndWhiteTree blackAndWhiteTree = new BlackAndWhiteTree(n);
		for (int i = 0; i < m; i++) {
			int u = in.nextInt();
			int v = in.nextInt();
			blackAndWhiteTree.addEdge(u, v);
		}

		blackAndWhiteTree.fixGraph();

		List<Edge> extraEdges = blackAndWhiteTree.getExtraEdges();
		System.out.printf("%d %d\n", blackAndWhiteTree.getAbsD(), extraEdges.size());
		StringBuilder sb = new StringBuilder();
		extraEdges.forEach(e -> sb.append(e.getU()).append(" ").append(e.getV()).append("\n"));
		System.out.println(sb.toString());
	}
}
