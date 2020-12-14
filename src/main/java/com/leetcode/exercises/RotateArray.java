package com.leetcode.exercises;

public class RotateArray {

	public static void main(String[] args) {

		//int[] nums = {1,2,3,4,5,6,7};
		int[] nums = {-1,-100,3,99};
		
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 2);
		
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public void rotate(int[] nums, int k) {
		//k %= nums.length;
		//k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1 );
		reverse(nums, k, nums.length - 1);
 	}
	
	public void reverse(int[] nums, int start, int end)  {
		
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
