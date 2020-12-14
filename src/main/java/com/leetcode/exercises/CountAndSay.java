package com.leetcode.exercises;

import java.util.LinkedList;
import java.util.List;

public class CountAndSay {

	public static void main(String[] args) {
		
		CountAndSay ca = new CountAndSay();
		System.out.println(ca.countAndSay(10));
	}

	
	
	public String countAndSay(int n) {
        LinkedList<Integer> prevSeq = new LinkedList<>();
        prevSeq.add(1);
        prevSeq.add(-1);
        
        List<Integer> finalSeq = this.nextSequence(n, prevSeq);
        
        StringBuffer seqStr = new StringBuffer();
        for (Integer digit : finalSeq) {
        	seqStr.append(String.valueOf(digit));
        }
        
        return seqStr.toString();
    }
	
	public LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
		if (n <= 1) {
			prevSeq.pollLast();
			return prevSeq;
		}
		
		LinkedList<Integer> nextSeq = new LinkedList<>();
		Integer prevDigit = null;
		Integer digitCnt = 0;
		
		for (Integer digit : prevSeq) {
			if (prevDigit == null) {
				prevDigit = digit;
				digitCnt +=1;
			} else if (digit == prevDigit) {
				digitCnt += 1;
			} else {
				nextSeq.add(digitCnt);
				nextSeq.add(prevDigit);
				prevDigit = digit;
				digitCnt = 1;
			}
		}
		
		nextSeq.add(-1);
		
		return this.nextSequence(n - 1, nextSeq);
	}

}
