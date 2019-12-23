
package com.LinkedList.otherProblems;

import java.util.Stack;

import com.LinkedList.ListNode;

/**
 * @author Vinayak Nair$
 *
 */
public class CheckPallindrome {

	public static boolean checkPallindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow, fast;
		slow = fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(head.val);
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			stack.push(slow.val);
		}
		if (fast.next == null)
			stack.pop();
		ListNode secondHalf = slow.next;
		while (secondHalf != null) {
			if (stack.pop() != secondHalf.val) {
				return false;
			} else {
				secondHalf = secondHalf.next;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(99);
		ListNode third = new ListNode(37);
		ListNode fourth = new ListNode(37);
		ListNode fifth = new ListNode(99);
		ListNode sixth = new ListNode(12);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		System.out.println("Is list a pallindrome " + checkPallindrome(head));
	}
}
