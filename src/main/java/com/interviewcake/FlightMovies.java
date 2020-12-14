package com.interviewcake;

import java.util.Set;
import java.util.HashSet;

public class FlightMovies {

	public static void main(String[] args) {
		int[] movieLengths = {1, 2, 4, 6, 5, 3};
		
		System.out.println(canTwoMoviesInFlight(movieLengths, 14));
	}

	public static boolean canTwoMoviesInFlight(int[] movieLengths, int flightLength) {
		Set<Integer> movieSet = new HashSet<>();
		for (int mLength : movieLengths) {
			int secondMovie = flightLength - mLength;
			if (movieSet.contains(secondMovie)) {
				return true;
			}
			movieSet.add(mLength);
		}
		return false;
	}
}
