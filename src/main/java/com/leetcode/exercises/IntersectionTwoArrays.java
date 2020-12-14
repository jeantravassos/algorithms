package com.leetcode.exercises;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		
		Arrays.stream(new IntersectionTwoArrays().intersect(nums1, nums2)).forEach(System.out::print);
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				++i;
			else if (nums1[i] > nums2[j])
				++j;
			else {
				nums1[k++] = nums1[i++];
				++j;
			}
		}
		
		return Arrays.copyOfRange(nums1, 0, k);
	}
	
	public int[] intersect1(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		
		HashMap<Integer, Integer> m = new HashMap<>();
		for (int num : nums1) {
			m.put(num, m.getOrDefault(num, 0) + 1);
		}
		
		int k = 0;
		for (int n : nums2) {
			int cont = m.getOrDefault(n, 0);
			if (cont > 0) {
				nums1[k++] = n;
				m.put(n, cont - 1);
			}
		}
		
		return Arrays.copyOfRange(nums1, 0, k);
	}
}
