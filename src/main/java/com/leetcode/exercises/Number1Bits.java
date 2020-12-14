package com.leetcode.exercises;

public class Number1Bits {

	public Number1Bits() {
		System.out.println(hammingWeight(00000000000000000000000000001011));
	}

	public static void main(String[] args) {
		new Number1Bits();
	}

	public int hammingWeight(int n) {
		
		int sum = 0;
		
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		
		return sum;
	}
	
	// #1
	public int hammingWeight1(int n) {

		int bits = 0;
		int mask = 1;
		
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			
			mask <<= 1;
		}
		
		return bits;
	}

}
