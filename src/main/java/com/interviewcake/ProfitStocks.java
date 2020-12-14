package com.interviewcake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ProfitStocks {
	public static int getMaxProfit(int[] stockPrices) {
		if (stockPrices == null)
			throw new IllegalArgumentException("Empty array");
		if (stockPrices.length <= 1)
			throw new IllegalArgumentException("Only one element, no buy and sell operation possible");

		// calculate the max profit
		int minValue = stockPrices[0];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < stockPrices.length; i++) {
			int calculatedPrice = stockPrices[i] - minValue;

			maxProfit = Math.max(maxProfit, calculatedPrice);

			minValue = Math.min(minValue, stockPrices[i]);
		}

		return maxProfit;
	}

	// tests

	@Test
	public void priceGoesUpThenDownTest() {
		final int actual = getMaxProfit(new int[] { 1, 5, 3, 2 });
		final int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void priceGoesDownThenUpTest() {
		final int actual = getMaxProfit(new int[] { 7, 2, 8, 9 });
		final int expected = 7;
		assertEquals(expected, actual);
	}

	@Test
	public void priceGoesUpAllDayTest() {
		final int actual = getMaxProfit(new int[] { 1, 6, 7, 9 });
		final int expected = 8;
		assertEquals(expected, actual);
	}

	@Test
	public void priceGoesDownAllDayTest() {
		final int actual = getMaxProfit(new int[] { 9, 7, 4, 1 });
		final int expected = -2;
		assertEquals(expected, actual);
	}

	@Test
	public void priceStaysTheSameAllDayTest() {
		final int actual = getMaxProfit(new int[] { 1, 1, 1, 1 });
		final int expected = 0;
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void exceptionWithOnePriceTest() {
		getMaxProfit(new int[] { 5 });
	}

	@Test(expected = Exception.class)
	public void exceptionWithEmptyPricesTest() {
		getMaxProfit(new int[] {});
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ProfitStocks.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}
