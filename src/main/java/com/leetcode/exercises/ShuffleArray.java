package com.leetcode.exercises;

import java.util.Random;

class ShuffleArray {

	public static void main (String[] args) {
		int[] nums = {1,2,3,4,5};
		ShuffleArray solution = new ShuffleArray(nums);

		solution.shuffle();
		solution.reset();
		solution.shuffle();
	}
	
	private int[] originalNums;
    private int[] nums;
    private Random rand = new Random();
    
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.originalNums = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	nums = originalNums;
    	originalNums = originalNums.clone();
    			
        return originalNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i ++) {
        	swapAt(i, randRange(i, nums.length));
        }
        
        return nums;
    }
    
    private int randRange(int min, int max) {
    	return rand.nextInt(max-min) + min;
    }
    
    private void swapAt(int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}