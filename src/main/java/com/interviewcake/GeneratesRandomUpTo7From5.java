package com.interviewcake;

import java.util.Random;

/*
 * You have a method rand5() that generates a random integer from 1 to 5. 
 * Use it to write a method rand7() that generates a random integer from 1 to 7.
 * rand5() returns each integer with equal probability. rand7() must also return each integer with equal probability.
 */
class GeneratesRandomUpTo7From5 {

	private static final Random rnd = new Random();

	private static int rand5() {
		return rnd.nextInt(5) + 1;
	}

	public static int rand7() {

		// implement rand7() using rand5()
		int[][] results = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 1, 2, 3 }, { 4, 5, 6, 7, 1 }, { 2, 3, 4, 5, 6 },
				{ 7, 0, 0, 0, 0 }, };

		while (true) {
			// do our die rolls
			int row = rand5() - 1;
			int column = rand5() - 1;

			// case: we hit an extraneous outcome
			// so we need to re-roll
			if (row == 4 && column > 0) {
				continue;
			}

			// our outcome was fine. Return it!
			return results[row][column];
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			System.out.printf("%d ", rand7());
		}
		System.out.println();
	}
}