package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ProductOfAllButIndex {

	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

		if (intArray.length < 2) {
			throw new IllegalArgumentException("No product available");
		}

		// make an array of the products
		int[] productsOfAllExceptAtIndex = new int[intArray.length];

		// Calculate the product of everything before index
		int productSoFar = 1;
		for (int i = 0; i < intArray.length; i++) {
			productsOfAllExceptAtIndex[i] = productSoFar;
			productSoFar *= intArray[i];
		}

		// Calculate the product of everything after index and add to previous
		productSoFar = 1;
		for (int i = intArray.length - 1; i >= 0; i--) {
			productsOfAllExceptAtIndex[i] *= productSoFar;
			productSoFar *= intArray[i];
		}

		return productsOfAllExceptAtIndex;
	}

	// tests

	@Test
	public void smallArrayTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { 1, 2, 3 });
		final int[] expected = new int[] { 6, 3, 2 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { 8, 2, 4, 3, 1, 5 });
		final int[] expected = new int[] { 120, 480, 240, 320, 960, 192 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arrayHasOneZeroTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { 6, 2, 0, 3 });
		final int[] expected = new int[] { 0, 0, 36, 0 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arrayHasTwoZerosTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { 4, 0, 9, 1, 0 });
		final int[] expected = new int[] { 0, 0, 0, 0, 0 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneNegativeNumberTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { -3, 8, 4 });
		final int[] expected = new int[] { 32, -12, -24 };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void allNegativeNumbersTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] { -7, -1, -4, -2 });
		final int[] expected = new int[] { -8, -56, -14, -28 };
		assertArrayEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void exceptionWithEmptyArrayTest() {
		getProductsOfAllIntsExceptAtIndex(new int[] {});
	}

	@Test(expected = Exception.class)
	public void exceptionWithOneNumberTest() {
		getProductsOfAllIntsExceptAtIndex(new int[] { 1 });
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ProductOfAllButIndex.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}