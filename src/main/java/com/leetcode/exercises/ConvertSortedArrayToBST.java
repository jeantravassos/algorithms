package com.leetcode.exercises;

public class ConvertSortedArrayToBST {

	public static void main(String[] args) {
		ConvertSortedArrayToBST csabst = new ConvertSortedArrayToBST();
		int[] nums = { -10, -3, 0, 5, 9 };
		csabst.sortedArrayToBST(nums);
	}

	int[] nums;
	
	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
		return helper(0, nums.length - 1);
	}

	private TreeNode helper(int left, int right) {
		if (left > right) return null;
		
		int p = (left + right) / 2;
		
		TreeNode root = new TreeNode(nums[p]);
		root.left = helper(left, p - 1);
		root.right = helper(p + 1, right);
		return root;
	}
	
}
