package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();

		TreeNode tnRoot = new TreeNode(3);
		TreeNode tn1 = new TreeNode(9);
		TreeNode tn2 = new TreeNode(20);
		TreeNode tn3 = new TreeNode(15);
		TreeNode tn4 = new TreeNode(7);

		tnRoot.left = tn1;
		tnRoot.right = tn2;
		tn2.left = tn3;
		tn2.right = tn4;

		btlot.levelOrder(tnRoot);
	}

	List<List<Integer>> levels = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		if (root == null)
			return levels;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			levels.add(new ArrayList<Integer>());

			int level_length = queue.size();
			for (int i = 0; i < level_length; ++i) {
				TreeNode node = queue.remove();

				levels.get(level).add(node.val);

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			level++;
		}
		return levels;
	}

	public List<List<Integer>> levelOrderRecursion(TreeNode root) {

		if (root == null)
			return levels;
		helper(root, 0);

		return levels;
	}

	private void helper(TreeNode root, int level) {
		if (levels.size() == level)
			levels.add(new ArrayList<>());

		levels.get(level).add(root.val);

		if (root.left != null)
			helper(root.left, level + 1);
		if (root.right != null)
			helper(root.right, level + 1);
	}

}
