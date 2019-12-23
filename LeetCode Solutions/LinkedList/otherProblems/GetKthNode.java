package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;

public class GetKthNode {

	public static int getKthNode(ListNode head, int pos) {
		if (head == null || pos <= 0)
			return -1;
		int count = pos - 1;
		while (head != null && count > 0) {
			head = head.next;
			count--;
		}
		if (head == null) {
			System.out.println("Given position greater than list size!!!!");
			return -1;
		}
		return head.val;

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
		System.out.println("kth node value is: " + getKthNode(head, 4));
	}

}
