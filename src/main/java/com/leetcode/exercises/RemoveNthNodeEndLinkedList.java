package com.leetcode.exercises;

public class RemoveNthNodeEndLinkedList {

	public RemoveNthNodeEndLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new RemoveNthNodeEndLinkedList();
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		//Copy the original linkedlist
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode first = dummy;
		ListNode second = dummy;
		
		//Advances with the first until the N received
		for (int i = 1; i <= n +1; i++) {
			first = first.next;
		}
		
		//when first comes to the end, the second will be right before the node 
		//that needs to be removed
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		
		//remove the link 
		second.next = second.next.next;
		
		//return the manipulated linkelist
		return dummy.next;
	}
}
