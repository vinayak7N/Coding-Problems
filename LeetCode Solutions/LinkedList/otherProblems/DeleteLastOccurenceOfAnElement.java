package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;

public class DeleteLastOccurenceOfAnElement {

	public static ListNode deleteLastOccurenceOfAnElement(ListNode head, int element) {
		if (head == null)
			return head;
		ListNode curr = head, elCurrent = null;
		while (head != null) {
			if (head.val == element) {
				elCurrent = head;
			}
			head = head.next;
		}
		if (elCurrent == curr) {
			return curr.next;
		}
		if (elCurrent == null) {
			return curr;
		}
		if (elCurrent.next == null) {
			head = curr;
			while (head.next.next != null) {
				head = head.next;
			}
			head.next = null;
			return curr;
		}
		elCurrent.val = elCurrent.next.val;
		elCurrent.next = elCurrent.next.next;
		return curr;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(13);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(23);
		ListNode fourth = new ListNode(16);
		ListNode fifth = new ListNode(23);
		ListNode sixth = new ListNode(12);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		head.displayList(deleteLastOccurenceOfAnElement(head, 13));
	}
}
