package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/*
 * Suppose we had an array ↴ of nn integers sorted in ascending order. 
 * How quickly could we check if a given integer is in the array?
 */
public class FindNumberAscendingOrder {

	public static boolean contains(int[] a, int n) {

		// check if an integer is present in the array

		// we think of floorIndex (left) and ceilingIndex (right) as "walls" around
		// the possible positions of our target, so by -1 below we mean
		// to start our wall "to the left" of the 0th index
		// (we "don't" mean "the last index")
		int left = -1;
		int right = a.length;

		// if there isn't at least 1 index between left/floor and rigth/ceiling,
		// we've run out of guesses and the number must not be present
		while (left + 1 < right) {

			// find the index halfway between the floor/left and ceiling/right
			// we use integer division, so we'll never get a "half index"
			int middle = left + ((right - left) / 2);

			if (a[middle] == n) {
				return true;
			}

			if (a[middle] < n) {
				left = middle;
			} else {
				right = middle;
			}
		}

		return false;
	}

	// tests

	@Test
	public void emptyArrayTest() {
		final boolean result = contains(new int[] {}, 1);
		assertFalse(result);
	}

	@Test
	public void oneItemArrayNumberPresentTest() {
		final boolean result = contains(new int[] { 1 }, 1);
		assertTrue(result);
	}

	@Test
	public void oneItemArrayNumberAbsentTest() {
		final boolean result = contains(new int[] { 1 }, 2);
		assertFalse(result);
	}

	@Test
	public void smallArrayNumberPresentTest() {
		final boolean result = contains(new int[] { 2, 4, 6 }, 4);
		assertTrue(result);
	}

	@Test
	public void smallArrayNumberAbsentTest() {
		final boolean result = contains(new int[] { 2, 4, 6 }, 5);
		assertFalse(result);
	}

	@Test
	public void largeArrayNumberPresentTest() {
		final boolean result = contains(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 8);
		assertTrue(result);
	}

	@Test
	public void largeArrayNumberAbsentTest() {
		final boolean result = contains(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0);
		assertFalse(result);
	}

	@Test
	public void largeArrayNumberFirstTest() {
		final boolean result = contains(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1);
		assertTrue(result);
	}

	@Test
	public void largeArrayNumberLastTest() {
		final boolean result = contains(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 10);
		assertTrue(result);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FindNumberAscendingOrder.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}