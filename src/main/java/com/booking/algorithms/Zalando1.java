package com.booking.algorithms;

public class Zalando1 {

	public Zalando1() {
//		int[] arr = {1, 3, 4, 2, 5};
//		System.out.println("Momentos: " + solution(arr));
		
		int[] arr = {3, 5, 6, 3, 3, 5};
		System.out.println(solution(arr));
//		System.out.println(solution("011100"));
	}

	
	public int solution(int[] A) {
        if (A == null || A.length <= 1) {
        	return 0;
        }
		
        int pairs = 0;
        for (int i = 0; i < A.length; i++) {
        	
        	for (int j = 1; j < A.length; j++) {
        		if (i < j) {
        			
        			if (A[i] == A[j]) {
        				pairs++;
        				if (pairs >= 1000000000) {
        					return 1000000000;
        				}
        			}
        		}
        	}
        }
        
		return pairs;
    }
	
	
	
	
	public static void main(String[] args) {
		new Zalando1();
	}

	public int solution1(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int numeric = Integer.parseInt(S, 2);
        int[] keepsTotal = new int[1];
        recursion(numeric, keepsTotal);
     
        return keepsTotal[0];
    }
	
	public void recursion(int times, int[] keepsTotal) {
		
		int toReturn = 0;
		
		if (times == 0) 
			return;
		
		if ((times % 2) == 0 ) {
			recursion(times / 2, keepsTotal);
		} else {
			recursion(times - 1, keepsTotal);
		}
		
		keepsTotal[0]++;
	}
	
	
}
