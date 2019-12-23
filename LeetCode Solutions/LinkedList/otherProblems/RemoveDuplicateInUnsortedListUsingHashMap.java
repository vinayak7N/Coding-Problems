package com.LinkedList.otherProblems;

import java.util.HashMap;

import com.LinkedList.ListNode;

public class RemoveDuplicateInUnsortedListUsingHashMap {

	public static ListNode removeDuplicate(ListNode head) {
		if (head == null)
			return head;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ListNode prev = null, curr = head;
		while (curr != null) {
			if (!map.containsKey(curr.val)) {
				map.put(curr.val, 1);
				prev = curr;
				curr = curr.next;
			} else {
				prev.next = curr.next;
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(12);
		ListNode b = new ListNode(99);
		ListNode c = new ListNode(12);
		ListNode d = new ListNode(8);
		ListNode e = new ListNode(8);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		a.displayList(removeDuplicate(a));
	}

}
