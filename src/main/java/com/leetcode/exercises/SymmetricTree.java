package com.leetcode.exercises;

public class SymmetricTree {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		TreeNode node3 = new TreeNode(2);
		node1.right = node3;
		TreeNode node4 = new TreeNode(3);
		node2.left = node4;
		TreeNode node5 = new TreeNode(4);
		node2.right = node5;
		TreeNode node6 = new TreeNode(4);
		node3.left = node6;
		TreeNode node7 = new TreeNode(3);
		node3.right = node7;

		System.out.println("Is symmetric tree : " + isSymmetric(node1));
	}

	public static boolean isSymmetric(TreeNode root) {

		return isMirror(root, root);
	}

	public static boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	}

}
