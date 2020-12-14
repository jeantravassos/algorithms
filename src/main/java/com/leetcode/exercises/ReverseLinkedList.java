package com.leetcode.exercises;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		ListNode ln2 = new ListNode(2);
		head.next = ln2;
		ListNode ln3 = new ListNode(3);
		ln2.next = ln3;
		ListNode ln4 = new ListNode(4);
		ln3.next = ln4;
		ListNode ln5 = new ListNode(5);
		ln4.next = ln5;
		
		//printLinkedList(head);
		
		ReverseLinkedList rll = new ReverseLinkedList();
		printLinkedList(rll.reverseList(head));
	}
	
	public ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
}
