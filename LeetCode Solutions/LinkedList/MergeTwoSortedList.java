package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

/*
 * List1 3 -> 6 -> 7 -> 9->11->14 
 * List2 1 -> 2 -> 5 -> 8
 */
public class MergeTwoSortedList {

	private ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode merged = null, head = null;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				merged.next = l2;
				return head;
			} else if (l2 == null) {
				merged.next = l1;
				return head;
			}
			if (l1.val < l2.val) {
				if (merged == null) {
					merged = l1;
					head = merged;
					l1 = l1.next;
				} else {
					merged.next = l1;
					merged = merged.next;
					l1 = l1.next;
				}
			} else {
				if (merged == null) {
					merged = l2;
					head = merged;
					l2 = l2.next;
				} else {
					merged.next = l2;
					merged = merged.next;
					l2 = l2.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();
		ListNode firsta = new ListNode(3);
		ListNode firstb = new ListNode(6);
		ListNode firstc = new ListNode(7);
		ListNode firstd = new ListNode(9);
		ListNode firste = new ListNode(11);
		ListNode firstf = new ListNode(14);
		firsta.next = firstb;
		firstb.next = firstc;
		firstc.next = firstd;
		firstd.next = firste;
		firste.next = firstf;
		ListNode seconda = new ListNode(1);
		ListNode secondb = new ListNode(2);
		ListNode secondc = new ListNode(5);
		ListNode secondd = new ListNode(8);
		seconda.next = secondb;
		secondb.next = secondc;
		secondc.next = secondd;
		firsta.displayList(list.mergeTwoList(firsta, seconda));

	}

}
