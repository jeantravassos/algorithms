package com.booking.algorithms;

public class Node {

	public int adjacentCount;
	private Node adjacent[];
	private String vertex;
	public GraphSearch.State state;
	
	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}
	
	public void addAdjacent(Node x) {
		if (adjacentCount < adjacent.length) {
			this.adjacent[adjacentCount] = x;
		}
		else
		{
			System.out.println("No more adjacent can be added");
		}
	}
	
	public Node[] getAdjacent () {
		return adjacent;
	}
	
	public String getVertex() {
		return vertex;
	}

}
