package com.leetcode.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(new ContainsDuplicates().containsDuplicate(nums));
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (Integer numero : nums) {
			if (set.contains(numero)) return true;
			set.add(numero);
		}
		
		return false;
	}
	
	
	public boolean containsDuplicate1(int[] nums) {
		if (nums == null || nums.length == 0 ) return false;
		
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1]) return true;
		}
		return false;
	}
}
