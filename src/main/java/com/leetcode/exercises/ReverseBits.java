package com.leetcode.exercises;

public class ReverseBits {

	public static void main(String[] args) {
		System.out.println(new ReverseBits().reverseBits(43261596));
	}

	public int reverseBits(int n) {

		int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    return result;
	}
}