package com.leetcode.exercises;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		
		System.out.println(solution(gas, cost));
	}

	public static int solution(int[] gas, int[] cost) {
		
		int n = gas.length;
		
		int totalRank = 0;
		int currentRank = 0;
		int startingStation = 0;
		
		for (int i = 0; i < n; i++) {
			totalRank += gas[i] - cost[i];
			currentRank += gas[i] - cost[i];
			if (currentRank < 0 ) {
				currentRank = 0;
				startingStation = i+1;
			}
		}
		
		return totalRank >= 0 ? startingStation : -1;
	}
	
}
