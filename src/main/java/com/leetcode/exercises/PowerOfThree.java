package com.leetcode.exercises;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(new PowerOfThree().isPowerOfThree(82));
	}

	public boolean isPowerOfThree(int n) {
    
		if (n == 0) return false;
		
		while (n != 1 && n % 3 == 0) {
			n = n / 3;
			if (n == 1) 
				return true;
			else if (n < 1) 
				return false;
		}
		
		return false;
    }
	
	public boolean isPowerOfThree1(int n) {
		if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
	}

}
