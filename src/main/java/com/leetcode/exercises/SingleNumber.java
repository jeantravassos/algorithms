package com.leetcode.exercises;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {4, 1, 2, 1, 2, 500000, 4, 91234567, 91234567, 91234567};
		System.out.println(new SingleNumber().singleNumber(nums));
	}

	public int singleNumber(int[] nums) {
		int ans =0;
	    
	    int len = nums.length;
	    for(int i=0;i!=len;i++)
	        ans ^= nums[i];
	    
	    return ans;
	}

}
