package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class HighPossibleScore {

	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {
		// array of 0s at indices 0..highestPossibleScore
		int[] scoreCounts = new int[highestPossibleScore + 1];

		// populate scoreCounts
		for (int score : unorderedScores) {
			scoreCounts[score]++;
		}

		// populate the final sorted array
		int[] sortedScores = new int[unorderedScores.length];
		int currentSortedIndex = 0;

		// for each item in scoreCounts
		for (int score = highestPossibleScore; score >= 0; score--) {
			int count = scoreCounts[score];

			// for the number of times the item occurs
			for (int occurrence = 0; occurrence < count; occurrence++) {

				// add it to the sorted array
				sortedScores[currentSortedIndex] = score;
				currentSortedIndex++;
			}
		}

		return sortedScores;
	}

	// Tests

	@Test
	public void noScoresTest() {
		final int[] scores = {};
		final int[] expected = {};
		final int[] actual = sortScores(scores, 100);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneScoreTest() {
		final int[] scores = { 55 };
		final int[] expected = { 55 };
		final int[] actual = sortScores(scores, 100);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoScoresTest() {
		final int[] scores = { 30, 60 };
		final int[] expected = { 60, 30 };
		final int[] actual = sortScores(scores, 100);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void manyScoresTest() {
		final int[] scores = { 37, 89, 41, 65, 91, 53 };
		final int[] expected = { 91, 89, 65, 53, 41, 37 };
		final int[] actual = sortScores(scores, 100);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void repeatedScoresTest() {
		final int[] scores = { 20, 10, 30, 30, 10, 20 };
		final int[] expected = { 30, 30, 20, 20, 10, 10 };
		final int[] actual = sortScores(scores, 100);
		assertArrayEquals(expected, actual);
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(HighPossibleScore.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All testes successfuly passed");
		}

	}

}
