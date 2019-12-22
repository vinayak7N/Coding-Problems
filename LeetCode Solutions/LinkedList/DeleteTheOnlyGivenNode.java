package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

public class DeleteTheOnlyGivenNode {

	public static void deleteTheOnlyGivenNode(ListNode node) {
		if (node == null || node.next == null)
			return;
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		ListNode fifth = new ListNode(50);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		DeleteTheOnlyGivenNode.deleteTheOnlyGivenNode(head);
		head.displayList(head);
	}

}
