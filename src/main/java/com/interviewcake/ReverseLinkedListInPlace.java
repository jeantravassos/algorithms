package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/*
 * Hooray! It's opposite day. Linked lists go the opposite way today.
 * Write a method for reversing a linked list. ↴ Do it in place. 
 * Your method will have one input: the head of the list.
 * Your method should return the new head of the list.
 */
public class ReverseLinkedListInPlace {

	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	public static LinkedListNode reverse(LinkedListNode headOfList) {

		// reverse the linked list in place
		LinkedListNode currentNode = headOfList;
		LinkedListNode previousNode = null;
		LinkedListNode nextNode = null;

		// until we have 'falle off' the end of the list
		while (currentNode != null) {

			// copy a pointer to the next element
			// before we overwrite currentNode.next
			nextNode = currentNode.next;

			// reverse the 'next' pointer
			currentNode.next = previousNode;

			// step forward in the list
			previousNode = currentNode;
			currentNode = nextNode;
		}

		return previousNode;
	}

	// tests

	@Test
	public void shortLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void longLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4, 5, 6 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void oneElementLinkedListTest() {
		final LinkedListNode node = new LinkedListNode(1);
		final LinkedListNode result = reverse(node);
		assertSame(node, result);
	}

	@Test
	public void emptyLinkedListTest() {
		final LinkedListNode result = reverse(null);
		assertNull(result);
	}

	private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
		final LinkedListNode[] nodes = new LinkedListNode[values.length];
		for (int i = 0; i < values.length; i++) {
			nodes[i] = new LinkedListNode(values[i]);
			if (i > 0) {
				nodes[i - 1].next = nodes[i];
			}
		}
		return nodes;
	}

	private static boolean isListReversed(LinkedListNode list, LinkedListNode[] originalNodes) {
		int i = originalNodes.length - 1;
		while (list != null && i >= 0) {
			if (originalNodes[i] != list) {
				return false;
			}
			list = list.next;
			i--;
		}
		return list == null && i == -1;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ReverseLinkedListInPlace.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}