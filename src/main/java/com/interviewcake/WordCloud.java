package com.interviewcake;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class WordCloud {

	public static class WordCloudData {

		private Map<String, Integer> wordsToCounts = new HashMap<>();

		private void populateWordsToCounts(String inputString) {

			int currentWordStartIndex = 0;
			int currentWordLength = 0;

			for (int i = 0; i < inputString.length(); i++) {
				char c = inputString.charAt(i);

				if (i == inputString.length() - 1) {
					if (Character.isLetter(c)) {
						currentWordLength++;
					}
					if (currentWordLength > 0) {
						String currentWord = inputString.substring(currentWordStartIndex,
								currentWordStartIndex + currentWordLength);
						addWordToHashMap(currentWord);
					}
				} else if (c == ' ' || c == '\u2014') {
					if (currentWordLength > 0) {
						String currentWord = inputString.substring(currentWordStartIndex,
								currentWordStartIndex + currentWordLength);
						addWordToHashMap(currentWord);
						currentWordLength = 0;
					}
				} else if (c == '.') {
					if (i < inputString.length() - 1 && inputString.charAt(i) == '.') {
						if (currentWordLength > 0) {
							String currentWord = inputString.substring(currentWordStartIndex,
									currentWordStartIndex + currentWordLength);
							addWordToHashMap(currentWord);
							currentWordLength = 0;
						}
					}
				} else if (Character.isLetter(c) || c == '\'') {
					if (currentWordLength == 0) {
						currentWordStartIndex = i;
					}
					currentWordLength++;
				} else if (c == '-') {
					if (i > 0 && Character.isLetter(inputString.charAt(i - 1))
							&& Character.isLetter(inputString.charAt(i + 1))) {
						if (currentWordLength == 0) {
							currentWordStartIndex = i;
						}
						currentWordLength++;
					} else {
						if (currentWordLength > 0) {
							String currentWord = inputString.substring(currentWordStartIndex,
									currentWordStartIndex + currentWordLength);
							addWordToHashMap(currentWord);
							currentWordLength = 0;
						}
					}
				}
			}
		}

		public WordCloudData(String inputString) {
			populateWordsToCounts(inputString);
		}

		public Map<String, Integer> getWordsToCounts() {
			return wordsToCounts;
		}

		public void addWordToHashMap(String word) {
			if (wordsToCounts.containsKey(word)) {
				wordsToCounts.put(word, wordsToCounts.get(word) + 1);
			} else if (wordsToCounts.containsKey(word.toLowerCase())) {
				int lowerCaseCount = wordsToCounts.get(word.toLowerCase());
				wordsToCounts.put(word.toLowerCase(), lowerCaseCount + 1);
			} else if (wordsToCounts.containsKey(capitalize(word))) {
				int capitalizedCount = wordsToCounts.get(capitalize(word));
				wordsToCounts.put(word, capitalizedCount + 1);
				wordsToCounts.remove(capitalize(word));
			} else {
				wordsToCounts.put(word, 1);
			}
		}

		private String capitalize(String word) {
			return word.substring(0, 1).toUpperCase() + word.substring(1);
		}

	}

	// tests

	// There are lots of valid solutions for this one. You
	// might have to edit some of these tests if you made
	// different design decisions in your solution.

	@Test
	public void simpleSentenceTest() {
		final String text = "I like cake";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("I", 1);
				put("like", 1);
				put("cake", 1);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	@Test
	public void longerSentenceTest() {
		final String text = "Chocolate cake for dinner and pound cake for dessert";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("and", 1);
				put("pound", 1);
				put("for", 2);
				put("dessert", 1);
				put("Chocolate", 1);
				put("dinner", 1);
				put("cake", 2);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	@Test
	public void punctuationTest() {
		final String text = "Strawberry short cake? Yum!";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("cake", 1);
				put("Strawberry", 1);
				put("short", 1);
				put("Yum", 1);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	@Test
	public void hyphenatedWordsTest() {
		final String text = "Dessert - mille-feuille cake";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("cake", 1);
				put("Dessert", 1);
				put("mille-feuille", 1);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	@Test
	public void ellipsesBetweenWordsTest() {
		final String text = "Mmm...mmm...decisions...decisions";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("mmm", 2);
				put("decisions", 2);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	@Test
	public void apostrophesTest() {
		final String text = "Allie's Bakery: Sasha's Cakes";
		final Map<String, Integer> expected = new HashMap<String, Integer>() {
			{
				put("Bakery", 1);
				put("Cakes", 1);
				put("Allie's", 1);
				put("Sasha's", 1);
			}
		};
		final WordCloudData actual = new WordCloudData(text);
		assertEquals(expected, actual.getWordsToCounts());
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(WordCloud.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}