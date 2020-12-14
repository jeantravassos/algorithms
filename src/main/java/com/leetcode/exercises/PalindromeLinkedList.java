package com.leetcode.exercises;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		PalindromeLinkedList pll = new PalindromeLinkedList();
		
		ListNode head = new ListNode(1);
		
		pll.isPalindrome(head);
	}

    public boolean isPalindrome(ListNode head) {
    	if (head == null) return true;
    	
    	//Find the end of the first half and reverse the second
    	ListNode firstHalfEnd = endOfFirstHalf(head);
    	ListNode secondHalfStart = reverseList(firstHalfEnd.next);
    	
    	//Check wether or not there is a palindrome
    	ListNode p1 = head;
    	ListNode p2 = secondHalfStart;
    	boolean result = true;
    	while (result && p2 != null) {
    		if (p1.val != p2.val) result = false;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	//Restore the list and return the result
    	firstHalfEnd.next = reverseList(secondHalfStart);
    	return result;
    }
    private ListNode endOfFirstHalf(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	while (fast.next != null && fast.next.next != null)
    	{
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	return slow;
    }
    private ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	ListNode curr = head;
    	while (curr != null) {
    		ListNode nextTemp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = nextTemp;
    	}
    	return prev;
    }

    	
	
	private ListNode frontPointer;
	private boolean recursivelyCheck(ListNode currentNode) {
		if (currentNode != null) {
			if (!recursivelyCheck(currentNode.next)) return false;
			if (currentNode.val != frontPointer.val) return false;
			frontPointer = frontPointer.next;
		}
		return true;
	}
	
	
	public boolean isPalindrome2(ListNode head) {
		frontPointer = head;
		return recursivelyCheck(head);
	}
	
	public boolean isPalindrome1(ListNode head) {
		if (head == null) return true;
		
		List<Integer> vals = new ArrayList<>();
		
		//Convert LinkedList into array
		ListNode currentNode = head;
		while (currentNode != null) {
			vals.add(currentNode.val);
			currentNode = currentNode.next;
		}
		
		// Use two-pointer technique to check for palindrome
		int front = 0;
		int back = vals.size() -1;
		while (front < back) {
			if (!vals.get(front).equals(vals.get(back))) {
				return false;
			}
			++front;
			--back;
		}
		
		return true;
	}
}
