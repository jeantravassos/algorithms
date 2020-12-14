package com.interviewcake;

import java.util.Random;

/*
 * You have a method rand7() that generates a random integer from 1 to 7. 
 * Use it to write a method rand5() that generates a random integer from 1 to 5.
 * rand7() returns each integer with equal probability. rand5() must also return each integer with equal probability.
 */
public class GenerateRandomUpTo5From7 {

	private static final Random rnd = new Random();

	private static int rand7() {
		return rnd.nextInt(7) + 1;
	}

	public static int rand5() {

		// implement rand5() using rand7()

		int result = 7; // arbitrarily large
		while (result > 5) {
			result = rand7();
		}

		return result;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%d ", rand5());
		}
		System.out.println();
	}
}