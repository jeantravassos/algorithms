package com.booking.algorithms;

public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent; /* only used for certain cases */

    public TreeNode(int x) {
        value = x;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        System.out.println(n.value);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNode n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) System.out.println("  ");
        if (isLeft)
        	System.out.println("/- " + n.value);
        else
        	System.out.println("\\- " + n.value);
        printTree(n.left, level + 1, true);
        printTree(n.right, level + 1, false);
    }
}
