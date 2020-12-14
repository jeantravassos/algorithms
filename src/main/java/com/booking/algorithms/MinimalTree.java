package com.booking.algorithms;

public class MinimalTree {

	
	public static TreeNode addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid - 1);
		n.right = addToTree(arr, mid+1, end );
		return n;
	}
	
	public static TreeNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}
	
}
