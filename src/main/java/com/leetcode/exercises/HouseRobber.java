package com.leetcode.exercises;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {2, 7, 9, 3, 1, 6};
		
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
    
		int prevMax = 0;
		int currMax = 0;
		
		for (int x : nums) {
			int temp = currMax;
			currMax = Math.max(prevMax + x, currMax);
			prevMax = temp;
		}
		
		return currMax;
    }

}
