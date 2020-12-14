package com.leetcode.exercises;

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		
		ValidAnagram va = new ValidAnagram();
		String s = "anagram", t = "nagaram";
		System.out.println(va.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {

		if (s == null || t == null) return false; 
		if (s.length() != t.length()) return false;
		
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		
		Arrays.sort(sChar);
		Arrays.sort(tChar);
		
		return Arrays.equals(sChar, tChar);
	}

}
