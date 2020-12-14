package com.interviewcake;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import static org.junit.Assert.*;

/*
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.

Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are encrypted while they're in transit.)

Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.

Given information about active users on the network, find the shortest route for a message from one user (the sender) to another (the recipient). Return an array of users that make up this route.

There might be a few shortest delivery routes, all with the same length. For now, let's just return any shortest route.

Your network information takes the form of a hash map mapping username strings to an array of other users nearby:

  Map<String, String[]> network = new HashMap<String, String[]>() {{
    put("Min",     new String[] { "William", "Jayden", "Omar" });
    put("William", new String[] { "Min", "Noam" });
    put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
    put("Ren",     new String[] { "Jayden", "Omar" });
    put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
    put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
    put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
    put("Noam",    new String[] { "Nathan", "Jayden", "William" });
    put("Omar",    new String[] { "Ren", "Min", "Scott" });
    ...
}};

Java
For the network above, a message from Jayden to Adam should have this route:

  { "Jayden", "Amelia", "Adam" }
 */
public class ReconstructPathGraph {

	public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

		// find the shortest route in the network between the two users

		return bfsGetPath(graph, startNode, endNode);
	}

	private static String[] reconstructPath(Map<String, String> previousNodes, String startNode, String endNode) {
		List<String> reversedShortestPath = new ArrayList<>();

		// start from the end of the path and work backwards
		String currentNode = endNode;
		while (currentNode != null) {
			reversedShortestPath.add(currentNode);
			currentNode = previousNodes.get(currentNode);
		}

		// reverse our path to get the right order
		// by flipping it around, in place
		Collections.reverse(reversedShortestPath);
		return reversedShortestPath.toArray(new String[reversedShortestPath.size()]);
	}

	public static String[] bfsGetPath(Map<String, String[]> graph, String startNode, String endNode) {
		if (!graph.containsKey(startNode)) {
			throw new IllegalArgumentException("Start node not in graph");
		}

		if (!graph.containsKey(endNode)) {
			throw new IllegalArgumentException("End node not in graph");
		}

		Queue<String> nodesToVisit = new ArrayDeque<>();
		nodesToVisit.add(startNode);

		// keep track of how we got to each node
		// we'll use this to reconstruct the shortest path at the end
		// we'll also use this to keep track of which nodes we've already visited
		Map<String, String> howWeReachedNodes = new HashMap<>();
		howWeReachedNodes.put(startNode, null);

		while (!nodesToVisit.isEmpty()) {
			String currentNode = nodesToVisit.remove();

			// stop when we reach the end node
			if (currentNode.equals(endNode)) {
				return reconstructPath(howWeReachedNodes, startNode, endNode);
			}

			for (String neighbor : graph.get(currentNode)) {
				if (!howWeReachedNodes.containsKey(neighbor)) {
					nodesToVisit.add(neighbor);
					howWeReachedNodes.put(neighbor, currentNode);
				}
			}
		}

		// if we get here, the we never found the end node
		// so there's NO path from startNode to endNode
		return null;
	}

	// tests

	@Test
	public void twoHopPath1Test() {
		final String[] expected = { "a", "c", "e" };
		final String[] actual = getPath(getNetwork(), "a", "e");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoHopPath2Test() {
		final String[] expected = { "d", "a", "c" };
		final String[] actual = getPath(getNetwork(), "d", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath1Test() {
		final String[] expected = { "a", "c" };
		final String[] actual = getPath(getNetwork(), "a", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath2Test() {
		final String[] expected = { "f", "g" };
		final String[] actual = getPath(getNetwork(), "f", "g");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath3Test() {
		final String[] expected = { "g", "f" };
		final String[] actual = getPath(getNetwork(), "g", "f");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void zeroHopPath() {
		final String[] expected = { "a" };
		final String[] actual = getPath(getNetwork(), "a", "a");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void noPathTest() {
		final String[] actual = getPath(getNetwork(), "a", "f");
		assertNull(actual);
	}

	@Test(expected = Exception.class)
	public void startNodeNotPresentTest() {
		getPath(getNetwork(), "h", "a");
	}

	@Test(expected = Exception.class)
	public void endNodeNotPresentTest() {
		getPath(getNetwork(), "a", "h");
	}

	private static Map<String, String[]> getNetwork() {
		return new HashMap<String, String[]>() {
			{
				put("a", new String[] { "b", "c", "d" });
				put("b", new String[] { "a", "d" });
				put("c", new String[] { "a", "e" });
				put("d", new String[] { "a", "b" });
				put("e", new String[] { "c" });
				put("f", new String[] { "g" });
				put("g", new String[] { "f" });
			}
		};
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ReconstructPathGraph.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}