package com.leetcode.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] nums = {-3, 4, 3, 90};
		int target = 0;
		
		Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> values = new HashMap<Integer, Integer>(nums.length);
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (values.containsKey(complement))
			{
				return new int[] {values.get(complement), i};
			}
			values.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("no possible solution");
	}
}
