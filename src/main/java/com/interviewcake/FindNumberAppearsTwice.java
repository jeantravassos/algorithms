package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/*
 * I have an array of n + 1n+1 numbers. Every number in the range 1..n1..n appears once except for one number that appears twice.
 * Write a method for finding the number that appears twice.
 */
public class FindNumberAppearsTwice {

	public static int findRepeat(int[] numbers) {

		// find the number that appears twice
		if (numbers.length < 2) {
			throw new IllegalArgumentException("Finding duplicate requires at least 2 numbers");
		}

		int n = numbers.length - 1;
		int sumWithoutDuplicate = (n * n + n) / 2;

		int actualSum = 0;
		for (int number : numbers) {
			actualSum += number;
		}

		return actualSum - sumWithoutDuplicate;
	}

	// tests

	@Test
	public void shortArrayTest() {
		final int[] numbers = { 1, 2, 1 };
		final int expected = 1;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int[] numbers = { 4, 1, 3, 4, 2 };
		final int expected = 4;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] numbers = { 1, 5, 9, 7, 2, 6, 3, 8, 2, 4 };
		final int expected = 2;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FindNumberAppearsTwice.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}