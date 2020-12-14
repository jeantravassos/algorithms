package com.leetcode.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(3);
		ListNode ln1 = new ListNode(2);
		ListNode ln2 = new ListNode(0);
		ListNode ln3 = new ListNode(-4);
		
		head.next = ln1;
		ln1.next = ln2;
		ln2.next = ln3;
//		ln3.next = ln1;
		
		LinkedListCycle llc = new LinkedListCycle();
		System.out.println(llc.hasCycle(head));
	}
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return true;
	}


    public boolean hasCycleSimple(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
        	if (nodesSeen.contains(head)) {
        		return true;
        	} else {
        		nodesSeen.add(head);
        	}
        	head = head.next;
        }
    	
    	return false;
    }
	
}
