
package com.LinkedList.otherProblems;

import com.LinkedList.ListNode;

/*
 * @author Vinayak Nair$
 *
 */
public class DeleteAlternateNodes {

	public static ListNode deleteAlternateNodes(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
		while (current != null && current.next != null) {
			current.next = current.next.next;
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(99);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(39);
		ListNode fifth = new ListNode(45);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		head.displayList(DeleteAlternateNodes.deleteAlternateNodes(head));
	}

}
