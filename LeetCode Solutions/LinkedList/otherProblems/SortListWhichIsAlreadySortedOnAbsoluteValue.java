package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;

public class SortListWhichIsAlreadySortedOnAbsoluteValue {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head, prev = null, temp = null;
		if (head.val < 0) {
			prev = curr;
			curr = curr.next;
		}
		while (curr != null) {
			if (curr.val < 0) {
				prev.next = curr.next;
				temp = curr.next;
				curr.next = head;
				head = curr;
				curr = temp;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {

		// The list is already sorted on absolute values(i.e. without negative symbol)
		ListNode head = new ListNode(-3);
		ListNode second = new ListNode(10);
		ListNode third = new ListNode(-13);
		ListNode fourth = new ListNode(-23);
		ListNode fifth = new ListNode(16);
		ListNode sixth = new ListNode(-45);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		head.displayList(sortList(head));
	}
}
