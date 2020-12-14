package com.interviewcake;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class HighestProductOf3 {

    public static int highestProductOf3(int[] intArray) {

        if (intArray.length < 3) {
            throw new IllegalArgumentException("Less than 3 elements.");
        }

        // calculate the highest product of three numbers
        int highest = Math.max(intArray[0], intArray[1]);
        int lowest = Math.min(intArray[0], intArray[1]);
        
        int highestProductOf2 = intArray[0] * intArray[1];
        int lowestProductOf2 = intArray[0] * intArray[1];
        
        int highestProductOf3 = intArray[0] * intArray[1] * intArray[2];
        
        for (int i = 2; i < intArray.length; i++) {
            
            int current = intArray[i];
            
            highestProductOf3 = Math.max(
                highestProductOf3, 
                Math.max(current * highestProductOf2, current * lowestProductOf2));

            highestProductOf2 = Math.max(
                highestProductOf2, 
                Math.max(highest * current, lowest * current));

            lowestProductOf2 = Math.min(
                lowestProductOf2, 
                Math.min(highest * current, lowest * current));
    
            highest = Math.max(highest, current);
            
            lowest = Math.min(lowest, current);
        }
        
        return highestProductOf3;
    }   


















    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HighestProductOf3.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}