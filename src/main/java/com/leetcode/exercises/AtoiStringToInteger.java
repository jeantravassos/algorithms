package com.leetcode.exercises;

public class AtoiStringToInteger {

	public static void main(String[] args) {
		AtoiStringToInteger asi = new AtoiStringToInteger();
		System.out.println(asi.myAtoi("-91283472332"));
	}

	public int myAtoi(String str) {

		if (str == null || str.trim().length() == 0) 
			return 0;
		
		int i = 0;
		int sum = 0;
		int sign = 1;
		str = str.trim();
		
		if (str.charAt(i) == '-' || str.charAt(i) == '+')
			sign = str.charAt(i++) == '+' ? 1 : -1;
		for (; i < str.length(); ++i) {
			int tmp = str.charAt(i) - '0';
			if (tmp < 0 || tmp > 9)
				break;
			if (sum > Integer.MAX_VALUE / 10
					|| (sum == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			else
				sum = sum * 10 + tmp;
		}
		return sign * sum;
	}

}
