package com.amazon;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		
//		System.out.println(s.solution("Codility We test  coders", 19));
		System.out.println(s.solution("The quick brown fox jumps over the lazy dog", 39));
	}

	
	public String solution(String message, int K) {
		
		int length = message.trim().length();
		
		if (length <= K) {
			return message.trim();
		}
		
		String cutMessage = message.substring(0, K);
		
		boolean isNextSpace = message.charAt(K) == ' ';
		if (isNextSpace) {
			return cutMessage;
		}
		
		char[] messageChar = cutMessage.toCharArray();
		
		for (int i = K-1; i >= 0; i--) {
			if (messageChar[i] == ' ') {
				return cutMessage.substring(0, i).trim();
			}
		}
		
		return "";
	}
	
}
