package com.booking.algorithms;

import java.time.Instant;
import java.util.Arrays;

public class MergeSortedArrays {

	public MergeSortedArrays() {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		
		merge(nums1, m, nums2, n);
		
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
	}

	public static void main(String[] args) {
		new MergeSortedArrays();
	}

	//Ao contrário, do fim pro começo e usando while
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m -1;
		int p2 = n -1;
		
		int p = m + n -1;
		
		while ( p1 >= 0 && p2 >=0) {
			nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
		}
		
		System.arraycopy(nums2, 0, nums1, 0, p2+1);
	}
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] copy1 = new int[m];
		System.arraycopy(nums1, 0, copy1, 0, m);
		
		int p1 = 0;
		int p2 = 0;
		
		int p = 0;
		
		while ((p1 < m) && (p2 < n)) {
			nums1[p++] = (copy1[p1] < nums2[p2]) ? copy1[p1++] : nums2[p2++];
		}
		
		if (p1 < m) {
			System.arraycopy(copy1, p1, nums1, p1 + p2, m + n - p1 - p2);
		} 
		if (p2 < n) {
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n -p1 -p2);
		}
	}
	
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		long start = Instant.now().toEpochMilli();
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
		long end = Instant.now().toEpochMilli();
		
		System.out.println("Execution time: " + (end - start));
	}
}
