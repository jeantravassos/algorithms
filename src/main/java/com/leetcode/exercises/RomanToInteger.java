package com.leetcode.exercises;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
	}

	public HashMap<String, Integer> mappingValues() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);

		return map;
	}

	public int[] valuesToArray() {
		int[] mapping = new int[128]; 
		mapping['I'] = 1;
		mapping['X'] = 10;
		mapping['C'] = 100;
		mapping['V'] = 5;
		mapping['L'] = 50;
		mapping['D'] = 500;
		mapping['M'] = 1000;

		return mapping;
	}

	public int romanToInt(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int[] map = valuesToArray();

		int prev = 0;
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int current = map[s.charAt(i)];
			if (current < prev)
				result -= current;
			else
				result += current;

			prev = current;
		}

		return result;
	}

	public int romanToInt1(String s) {

		if (s == null || s.length() == 0)
			return 0;

		HashMap<String, Integer> map = mappingValues();

		int prev = 0;
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int current = map.get(String.valueOf(s.charAt(i)));
			if (current < prev)
				result -= current;
			else
				result += current;

			prev = current;
		}

		return result;
	}

}
