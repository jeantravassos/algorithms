package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

//	private final static int THREE = 3;
//	private final static int FIVE = 5;

	public static void main(String[] args) {
		new FizzBuzz();
	}

	public FizzBuzz() {

		for (String s : fizzBuzz(15))
			System.out.println(s);
	}

	public List<String> fizzBuzz(int n) {

		List<String> ans = new ArrayList<String>(n);
		HashMap<Integer, String> fizzBuzzDict = new HashMap<Integer, String>() {
			{
				put(3, "fizz");
				put(5, "Buzz");
			}
		};

		for (int num = 1; num <= n; num++) {
			String numAnsStr = "";

			for (Integer key : fizzBuzzDict.keySet()) {
				if (num % key == 0) {
					numAnsStr += fizzBuzzDict.get(key);
				}
			}

			if (numAnsStr.equals("")) {
				numAnsStr += Integer.toString(num);
			}

			ans.add(numAnsStr);
		}
		
		return ans;
	}

//	public List<String> fizzBuzz(int n) {
//		List<String> list = new ArrayList<String>(n);
//
//		for (int i = 1; i <= n; i++) {
//			String numAnsStr = "";
//			if ((i % THREE) == 0) {
//				numAnsStr = "Fizz";
//			}
//			if ((i % FIVE) == 0) {
//				numAnsStr += "Buzz";
//			}
//			if (numAnsStr.equals("")) {
//				numAnsStr = String.valueOf(i);
//			}
//
//			list.add(numAnsStr);
//		}
//
//		return list;
//	}
}
