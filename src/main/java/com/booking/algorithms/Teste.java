package com.booking.algorithms;

import java.util.Arrays;
import java.util.Stack;


public class Teste {

	public static void main(String[] args) {

		String s = "sfs dfsg rgw tgh ref 5g 4 re";
		
		//replaceFun(s.toCharArray(), s.length());
		
//		System.out.println(anagram("cab", "abc"));
		//System.out.println(isUniqueChars2("abcdefghijkl"));

		System.out.println("Problema String : " + newString());
	}
	
	static String newString() {
		
		String reception = "#ABCD##EF#";
		StringBuilder result = new StringBuilder();
		
		int indexLastValidChar = -1;
		char[] charArray = reception.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			
			if(charArray[i] == '#') {
				if (indexLastValidChar > -1 && 
						indexLastValidChar <= result.length()) {
				 	result.deleteCharAt(indexLastValidChar);
					indexLastValidChar--;
				}
			} else {
				result.append(charArray[i]);
				indexLastValidChar++;
			}
			
		}
		
		return result.toString();
		
	}
	
	
	
	static Stack<Integer> sort(Stack<Integer> s) {
		
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			int tmp = s.pop();
			
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		return r;
		
	}
	
	static void replaceFun(char[] str, int length) {
		int spaceCount = 0;
		int newLength;
		int i = 0;
		
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2;
		char[] newChar = new char[newLength];
		newChar[newLength-1] = '\0';
		
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newChar[newLength - 1] = '0';
				newChar[newLength - 2] = '2';
				newChar[newLength - 3] = '%';
				newLength = newLength -3;
			} else {
				newChar[newLength - 1]  = str[i];
				newLength = newLength -1;
			}
		}
		System.out.println(Arrays.toString(newChar));
	}
	
	
	static boolean anagram (String s1, String s2) {
		
//		return sort(s1) == sort(s2);
		return sort(s1).equals(sort(s2));
	}
	
	static String sort(String str) {
		char[] arrayChar = str.toCharArray();
		Arrays.sort(arrayChar);
		
		System.out.println(Arrays.toString(arrayChar));
		return Arrays.toString(arrayChar);
	}
	
	void removeDuplicatesEff (char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		boolean[] hit= new boolean[256];
		for (int i =0; i< 256; i++) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 0; i < len; i++) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		System.out.println("removeDuplicatesEff : " + str );
	}
	
	void removeDuplicate (char[] str) {
		
		if (str == null) return;
		int len = str.length;
		if (len < 2) return;
		
		int tail = 1;
		
		for (int i = 0; i < len; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
	}
	

	public static boolean isUniqueChars2(String str) {

		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}

		return true;
	}

}
