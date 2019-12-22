
package com.LinkedList.otherProblems;

import com.LinkedList.ListNode;

/**
 * @author Vinayak Nair$
 *
 */
public class MatchingFirstHalfAndSecondHalf {

	public static boolean isFirstHalfMatchesSecondHalf(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow, fast;
		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHalf = slow.next;
		while (secondHalf != null) {
			if (head.val != secondHalf.val) {
				return false;
			} else {
				head = head.next;
				secondHalf = secondHalf.next;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(99);
		ListNode third = new ListNode(37);
		ListNode fourth = new ListNode(12);
		ListNode fifth = new ListNode(99);
		ListNode sixth = new ListNode(37);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		System.out.println("Is First half matches with second half "
				+ MatchingFirstHalfAndSecondHalf.isFirstHalfMatchesSecondHalf(head));
	}
}
