package com.amazon;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		
//		System.out.println(s.solution("nice", "niece"));
//		System.out.println(s.solution("nice", "niceW"));
//		System.out.println(s.solution("crow", "cow"));
//		System.out.println(s.solution("crod", "cow"));
//		System.out.println(s.solution("cowR", "cow"));
		System.out.println(s.solution("beans", "banes"));
		System.out.println(s.solution("beans", "beanK"));
		System.out.println(s.solution("beans", "banes"));
		System.out.println(s.solution("o", "odd"));
	}

	// INSERT, REMOVE, MOVE, NOTHING, IMPOSSIBLE 
	public String solution(String S, String T) {

		if (Math.abs(S.length() - T.length()) >= 2) {
			return "IMPOSSIBLE";
		}
		
		if (S.equals(T)) {
			return "NOTHING";
		}
		
		if (S.length() == T.length()) {
			// MOVE case
			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) != T.charAt(i)) {
					if (i == S.length()) {
					 	// It's the last char and there's no way to move
						return "IMPOSSIBLE";
					} else {
						char different = S.charAt(i);
						
						for (int j = i; j < T.length(); j++) {
							if (T.charAt(j) == different) {
								return "MOVE " + S.charAt(i);
							}	
						}
					}
				}
			}
			
		} else if (S.length() < T.length()) {
			// INSERT case
			for (int i = 0; i < S.length(); i++) {
				
				if (S.charAt(i) != T.charAt(i)) {
					String comparison = S.substring(0, i);
					comparison += T.charAt(i);
					comparison += S.substring(i);
					
					if (comparison.equals(T)) {
						return "INSERT " + T.charAt(i);
					}
				}
			}
			
			//Test the last char
			if (T.substring(0, S.length()).equals(S)) {
				return "INSERT " + T.charAt(T.length()-1);
			}
			
			return "IMPOSSIBLE";
			
		} else if (S.length() > T.length()) {
			// REMOVE case
			for (int i = 0; i < T.length(); i++) {
				if (S.charAt(i) != T.charAt(i)) {
					String comparison = S.substring(0, i) + S.substring(i+1);
					if (comparison.equals(T)) {
						return "REMOVE " + S.charAt(i);
					} else {
						return "IMPOSSIBLE";
					}	
				}
			}
			
			//Test the last char
			if (S.substring(0, T.length()).equals(T)) {
				return "REMOVE " + S.charAt(S.length()-1);
			}
			
			return "IMPOSSIBLE";
		}
		
		return "IMPOSSIBLE";
	}
	
}
