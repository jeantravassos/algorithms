package com.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StringScore {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();
	    		
		for (int i = 1; i <= t; i ++) {
		    int N = in.nextInt();
		    int K = in.nextInt();
		    
		    String S = in.next();
		    
			System.out.println("\nT : " + t + " - N: " + N + " - K: " + K + " vezes");
			System.out.println("String: " + S);

			int count = 0;
			for (int j = 0; j < N/2; j++) {
				char a = S.charAt(j);
				char b = S.charAt(N - 1 - j);
				
				if (a != b) {
					count++;
				}
			}
			
			System.out.println("Case #" + i + ": " + (K - count));
		}
	}

}
/*
2
5 1
ABCAA
4 2
ABAA
*/