package com.leetcode.exercises;

import java.util.Stack;

public class ValidateBST {

	public ValidateBST() {
//		TreeNode root = new TreeNode(2);
//		TreeNode left = new TreeNode(1);
//		TreeNode right = new TreeNode(3);
//		root.left = left;
//		root.right = right;

		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(6);
		TreeNode rightleft = new TreeNode(3);
		TreeNode rightright = new TreeNode(7);
		root.left = left;
		root.right = right;
		right.left = rightleft;
		right.right = rightright;

		System.out.println(isValidBST(root));
	}

	public static void main(String[] args) {
		new ValidateBST();
	}

	//Solução que preferi
	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;

		int val = node.val;
		if (lower != null && val <= lower)
			return false;
		if (upper != null && val >= upper)
			return false;

		if (!helper(node.right, val, upper))
			return false;
		if (!helper(node.left, lower, val))
			return false;
		return true;
	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	// melhor solução
	public boolean isValidBST2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		double inorder = -Double.MAX_VALUE;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			// If next element in inorder traversal
			// is smaller than the previous one
			// that's not BST.
			if (root.val <= inorder)
				return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}

	// minha solução poor
	public boolean isValidBST1(TreeNode root) {
		boolean leftOK = false;
		boolean rightOK = false;

		if (root.left != null) {
			leftOK = isValidBST(root.left);
			if (!leftOK)
				return false;

			if (root.left.val < root.val)
				leftOK = true;
			else
				return false;
		} else {
			leftOK = true;
		}

		if (root.right != null) {
			rightOK = isValidBST(root.right);
			if (!rightOK)
				return false;

			if (root.right.val > root.val)
				rightOK = true;
			else
				return false;
		} else {
			rightOK = true;
		}

		return leftOK && rightOK;
	}

}
