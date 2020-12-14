package com.interviewcake;

import java.util.Random;
import java.util.Arrays;

public class RandomShuffleInPlace {

	private static Random random = new Random();
	
	private static int randomize (int ceiling, int floor) {
		return random.nextInt((ceiling - floor) + 1) + floor;
	}
	
	public static void suffle(int[] array) {
		
		if (array.length <= 1) { 
			return;
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			int randomIndex = randomize(array.length, i);
			if (randomIndex != i) {
				int temp = array[randomIndex];
				array[randomIndex] = array[i];
				array[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        suffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}
