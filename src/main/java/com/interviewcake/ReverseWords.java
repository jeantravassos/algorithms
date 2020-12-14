package com.interviewcake;

public class ReverseWords {

	public static void main(String[] args) {
		char[] message = { 'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l' };

		reverseWords(message);
		System.out.println(message);
	}

	public static void reverseWords(char[] message) {

		reverseCharacters(message, 0, message.length - 1);

		int leftIndex = 0;

		for (int i = 0; i <= message.length; i++) {
			if (message[i] == ' ' || i == message.length) {
				reverseCharacters(message, leftIndex, i - 1);
				leftIndex = i + 1;
			}
		}
	}

	private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

		while (leftIndex < rightIndex) {
			char temp = message[leftIndex];
			message[leftIndex] = message[rightIndex];
			message[rightIndex] = temp;

			leftIndex++;
			rightIndex--;
		}
	}

}
