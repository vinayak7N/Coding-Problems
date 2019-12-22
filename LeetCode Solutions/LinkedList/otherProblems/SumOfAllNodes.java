package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;
import com.LinkedList.RemoveNthFromEnd;

public class SumOfAllNodes {

	public int sumOfAllNodes(ListNode head) {
		if (head == null)
			return 0;
		if (head.next == null)
			return head.val;
		int sum = 0;
		while (head != null) {
			sum += head.val;
			head = head.next;
		}
		return sum;
	}

	public static void main(String[] args) {
		SumOfAllNodes sum = new SumOfAllNodes();
		ListNode head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		ListNode fifth = new ListNode(50);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		System.out.println("Sum of all nodes: " + sum.sumOfAllNodes(head));
	}

}
