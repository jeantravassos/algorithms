package com.leetcode.exercises;

public class ReverseInteger {

	public ReverseInteger() {
		reverse(120);
	}

	public static void main(String[] args) {
		new ReverseInteger();
	}

	public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	// My solution
	public int reverse1(int x) {

		if (x > -10 && x < 10)
			return x;

		String str = Integer.toString(x);
		if (str == null || str.equals(""))
			return 0;

		StringBuilder sb = new StringBuilder();
		char[] sChar = str.toCharArray();
		boolean processFirst = true;
		if (sChar[0] == '-') {
			sb.append(sChar[0]);
			processFirst = false;
		}

		for (int i = sChar.length - 1; i >= 0; i--) {
			if (i > 0 || (i == 0 && processFirst)) {
				sb.append(sChar[i]);
			}
		}

		System.out.println(sb.toString());
		return Integer.parseInt(sb.toString());
	}
}
