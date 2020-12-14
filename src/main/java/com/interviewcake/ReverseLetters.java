package com.interviewcake;

public class ReverseLetters {

	public static void main(String[] args) {
		char[] c = new char[] { 'v', 'i', 'c', 't', 'o', 'r' };
		reverseLetters(c);
		System.out.println(c);
		
		c = new char[] { '.', 'a', '-', '%', ' ', '|' , '0'};
		reverseLetters(c);
		System.out.println(c);
	}

	public static void reverseLetters(char[] letters) {
		if (letters == null || letters.length <= 1)
			return;

		char temp = 0;
		for (int i = 0; i < letters.length / 2; i++) {
			temp = letters[i];
			letters[i] = letters[letters.length - 1 - i];
			letters[letters.length - 1 - i] = temp;
		}
	}
}
