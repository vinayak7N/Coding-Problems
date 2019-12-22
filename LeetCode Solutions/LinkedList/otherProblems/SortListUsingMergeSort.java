package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */

import com.LinkedList.ListNode;

public class SortListUsingMergeSort {

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode middle = middle(head);
		ListNode secondHalf = middle.next;
		middle.next = null;
		return merge(mergeSort(head), mergeSort(secondHalf));
	}

	private ListNode merge(ListNode first, ListNode second) {
		if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}
		ListNode current = null, head = null;
		while (first != null && second != null) {
			if (first.val < second.val) {
				if (current == null) {
					current = first;
					head = current;
					first = first.next;
				} else {
					current.next = first;
					first = first.next;
					current = current.next;
				}
			} else {
				if (current == null) {
					current = second;
					head = current;
					second = second.next;
				} else {
					current.next = second;
					second = second.next;
					current = current.next;
				}
			}
		}
		current.next = (first == null) ? second : first;
		return head;
	}

	private ListNode middle(ListNode node) {
		if (node == null)
			return node;
		ListNode slow = node;
		ListNode fast = node.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SortListUsingMergeSort mergeSortList = new SortListUsingMergeSort();
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(99);
		ListNode third = new ListNode(37);
		ListNode fourth = new ListNode(7);
		ListNode fifth = new ListNode(45);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		head.displayList(mergeSortList.mergeSort(head));

	}

}
