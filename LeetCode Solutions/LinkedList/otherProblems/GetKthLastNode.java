package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;

public class GetKthLastNode {

	public static int getKthLastNode(ListNode head, int pos) {
		if (head == null || pos <= 0)
			return -1;
		int count = pos - 1;
		ListNode prev = head, curr = head;
		while (count > 0) {
			curr = curr.next;
			if (curr == null) {
				System.out.println("Invalid positon value greater than list size!!!");
				return -1;
			}
			count--;
		}
		while (curr.next != null) {
			prev = prev.next;
			curr = curr.next;
		}

		return prev.val;
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
		System.out.println("Kth last node is: " + getKthLastNode(head, 3));
	}

}
