package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public void displayList(ListNode head) {
		if (head == null)
			return;
		System.out.print("List-> ");
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}