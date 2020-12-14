package com.interviewcake;

public class MergeArrays {

	public static void main(String[] args) {

		int[] myArray = {3,  4,  6, 10, 11, 15};
		int[] aliceArray = {1,  5,  8, 12, 14, 19};
				
		System.out.println(mergeSortedArrays(myArray, aliceArray));
	}

	public static int[] mergeSortedArrays(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];

		int aIndex = 0;
		int bIndex = 0;
		int mergedIndex = 0;

		while (mergedIndex < merged.length) {

			boolean isAExhausted = aIndex >= a.length;
			boolean isBExhausted = bIndex >= b.length;
			
			if (!isAExhausted && (isBExhausted || a[aIndex] < b[bIndex])) {
				merged[mergedIndex] = a[aIndex];
				aIndex++;
			} else {
				merged[mergedIndex] = b[bIndex];
				bIndex++;
			}

			mergedIndex++;
		}

		return merged;
	}

}
