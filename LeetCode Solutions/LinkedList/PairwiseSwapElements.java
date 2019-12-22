package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

public class PairwiseSwapElements {

	// List Before: 12 34 9 45 15
	// List After: 34 12 45 9 15

	public static ListNode pairwiseSwapElements(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			int temp = curr.val;
			curr.val = curr.next.val;
			curr.next.val = temp;
			curr = curr.next.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(34);
		ListNode third = new ListNode(9);
		ListNode fourth = new ListNode(45);
		ListNode fifth = new ListNode(15);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		head.displayList(PairwiseSwapElements.pairwiseSwapElements(head));
	}

}
