package com.leetcode.exercises;

import java.util.HashMap;

public class FirstUniqueCharacter {

	public static void main(String[] args) {

		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		System.out.println(fuc.firstUniqChar("loveleetcode"));
	}

	public int firstUniqChar(String s) {

		HashMap<Character, Integer> hm = new HashMap<>();
		char[] sequence = s.trim().toCharArray();
		for (int i = 0; i < sequence.length; i++) {
			hm.put(sequence[i], hm.getOrDefault(sequence[i], 0) + 1);
		}
		
		for (int i = 0; i < sequence.length; i++) {
			if (hm.get(sequence[i]) == 1) {
				return i;
			}
		}
		
		return -1;
	}

}
