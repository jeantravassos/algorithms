package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/*
 * Write a method to find the 2nd largest element in a binary search tree
 * */

public class Find2ndLargestBST {

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}

	public static int findSecondLargest(BinaryTreeNode rootNode) {

		// find the second largest item in the binary search tree
		if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
			throw new IllegalArgumentException("Tree must have at least one child");
		}

		BinaryTreeNode current = rootNode;

		while (true) {
			// case: current is largest and has a left subtree
			// 2nd largest is the largest in that subtree
			if (current.left != null && current.right == null) {
				return findLargestIterative(current.left);
			}

			// case: current is parent of largest, and largest has no children,
			// so current is 2nd largest
			if (current.right != null && current.right.left == null && current.right.right == null) {
				return current.value;
			}

			current = current.right;
		}

		// TODO - OBS: alternative solution using Recursion below
		// return findSecondLargestRecursion(rootNode);
	}

	public static int findLargestIterative(BinaryTreeNode rootNode) {
		BinaryTreeNode current = rootNode;

		while (current.right != null) {
			current = current.right;
		}

		return current.value;
	}

	public static int findLargestRecursion(BinaryTreeNode root) {
		if (root == null) {
			throw new IllegalArgumentException("Tree must have at least 1 node");
		}

		if (root.right != null) {
			return findLargestRecursion(root.right);
		}

		return root.value;
	}

	public static int findSecondLargestRecursion(BinaryTreeNode rootNode) {
		if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
			throw new IllegalArgumentException("Tree must have at least one child");
		}

		// case: we are currently at largest, and largest has a left subtree,
		// so 2nd largest is largest in said subtree
		if (rootNode.left != null && rootNode.right == null) {
			return findLargestRecursion(rootNode.left);
		}

		// case: we are at parent of largest, and largest has no left subtree,
		// so 2nd largest must be current node
		if (rootNode.right != null && rootNode.right.left == null && rootNode.right.right == null) {
			return rootNode.value;
		}

		return findSecondLargestRecursion(rootNode.right);
	}

	// tests

	@Test
	public void findSecondLargestTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70);
		b.insertLeft(60);
		b.insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftChildTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70).insertLeft(60);
		final int actual = findSecondLargest(root);
		final int expected = 60;
		assertEquals(expected, actual);
	}

	@Test
	public void largestHasLeftSubtreeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		final BinaryTreeNode b = root.insertRight(70).insertLeft(60);
		b.insertLeft(55).insertRight(58);
		b.insertRight(65);
		final int actual = findSecondLargest(root);
		final int expected = 65;
		assertEquals(expected, actual);
	}

	@Test
	public void secondLargestIsRootNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		final BinaryTreeNode a = root.insertLeft(30);
		a.insertLeft(10);
		a.insertRight(40);
		root.insertRight(70);
		final int actual = findSecondLargest(root);
		final int expected = 50;
		assertEquals(expected, actual);
	}

	@Test
	public void descendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertLeft(40).insertLeft(30).insertLeft(20);
		final int actual = findSecondLargest(root);
		final int expected = 40;
		assertEquals(expected, actual);
	}

	@Test
	public void ascendingLinkedListTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		root.insertRight(60).insertRight(70).insertRight(80);
		final int actual = findSecondLargest(root);
		final int expected = 70;
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void exceptionWithTreeThatHasOneNodeTest() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		findSecondLargest(root);
	}

	@Test(expected = Exception.class)
	public void exceptionWithEmptyTreeTest() {
		findSecondLargest(null);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(Find2ndLargestBST.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}