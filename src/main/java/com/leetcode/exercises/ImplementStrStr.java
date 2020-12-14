package com.leetcode.exercises;

public class ImplementStrStr {

	public static void main(String[] args) {
		
		String haystack = "hlello";
		String needle = "ll";

		System.out.println(strStr(haystack, needle));
	}
	
	public static int strStr(String haystack, String needle) {
        
		if (haystack == null || 
				needle == null ||
				!haystack.contains(needle)) {
			return -1;
		}
		
		if (haystack.equals(needle))
			return 0;
		
		return haystack.indexOf(needle);
    }
	
	public static int strStr1(String haystack, String needle) {
		int L = needle.length();
		int n = haystack.length();
		
		for (int start = 0; start < n - L + 1; ++start) {
			if (haystack.substring(start, start + L).equals(needle)) {
				return start;
			}
		}
		
		return -1;
	}

}
