package com.leetcode.exercises;

public class MaximumSubarray {

	public static void main(String[] args) {
		new MaximumSubarray();
	}

	public MaximumSubarray() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}
	
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i-1] > 0 ) 
				nums[i] += nums[i-1];
			
			maxSum = Math.max(nums[i], maxSum);
		}
		
		return maxSum;
	}
	
	//Gostei e usa máximos
	//Inicializa os int com o primeiro valor e começa o loop a partir do segundo
	public int maxSubArray2(int[] nums) {

		int currSum = nums[0];
		int maxSum = nums[0];
		
		for (int i = 1; i < nums.length; ++i) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		
		return maxSum;
	}

	// Complexa mas 'divide and conquer'
	public int maxSubArray1(int[] nums) {

		return helper(nums, 0, nums.length - 1);
	}

	public int crossSum(int[] nums, int left, int right, int p) {

		if (left == right)
			return nums[left];

		int leftSubsum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i = p; i > left - 1; --i) {
			currSum += nums[i];
			leftSubsum = Math.max(leftSubsum, currSum);
		}

		int rightSubsum = Integer.MIN_VALUE;
		currSum = 0;
		for (int i = p + 1; i < right + 1; ++i) {
			currSum += nums[i];
			rightSubsum = Math.max(rightSubsum, currSum);
		}

		return leftSubsum + rightSubsum;
	}

	public int helper(int[] nums, int left, int right) {

		if (left == right)
			return nums[left];

		int p = (left + right) / 2;
		int leftSum = helper(nums, left, p);
		int rightSum = helper(nums, p + 1, right);
		int crossSum = crossSum(nums, left, right, p);

		return Math.max(Math.max(leftSum, rightSum), crossSum);
	}
}
