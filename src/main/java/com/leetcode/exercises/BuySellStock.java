package com.leetcode.exercises;

public class BuySellStock {

	public static void main (String[] args) {
		new BuySellStock();
	}
	
	
	public BuySellStock() {
		int [] arr = new int[] {7,1,2,3,6,4};
		System.out.println(maxProfit(arr));
	}
	
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		int minprice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice) {
				minprice = prices[i];
			} else if (prices[i] - minprice > maxprofit) {
				maxprofit = prices[i] - minprice;
			}
		}
		
		return maxprofit;
	}
	
	//#2
	public int maxProfit2(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		
		while (i < prices.length - 1)  {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length -1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}
	
	//#1
	public int maxProfit1(int[] prices) {
		return calculate(prices, 0);
	}
	
	public int calculate(int[] prices, int s) {
		if (s >= prices.length) 
			return 0;
		
		int max = 0;
		for (int start = s; start < prices.length; start++) {
			int maxProfit = 0;
			for (int i = start + 1; i < prices.length; i++) {
				
				if (prices[start] < prices[i]) {
					int profit = calculate(prices, i + 1) + prices[i] - prices[start];
					if (profit > maxProfit) 
						maxProfit = profit;
				}
			}
			if (maxProfit > max) 
				max = maxProfit;
		}
		
		return max;
	}

}
