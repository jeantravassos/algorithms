package com.leetcode.exercises;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n4;

		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(4);
		n5.next = n6;
		n6.next = n7;

		mtsl.mergeTwoLists(n1, n5);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}

	public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoListsRecursive(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRecursive(l1, l2.next);
			return l2;
		}
	}
}
