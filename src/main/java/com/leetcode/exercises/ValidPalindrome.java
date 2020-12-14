package com.leetcode.exercises;

public class ValidPalindrome {

	public static void main(String[] args) {

		ValidPalindrome vp = new ValidPalindrome();
		String pal = "   ";
		System.out.println(vp.isPalindrome(pal));
	}

	
	public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head < tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
	
	public boolean isPalindromeLento(String s) {
		if (s == null) return false;
		s = s.toLowerCase().trim().replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "");
		if (s.isEmpty()) return true;
		
		String reverted = new StringBuilder(s).reverse().toString();
		return s.equalsIgnoreCase(reverted);
	}
	
	String reverse(String original) {
	    String reversed = "";
	    for (int i = original.length() - 1;  0 <= i; i--) {
	        reversed += original.charAt(i);
	    }
	    return reversed;
	}
}
