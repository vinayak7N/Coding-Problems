package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

public class AddTwoNumbers {

	private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current = null, head = null;
		int sum = 0, carry = 0;
		while (l1 != null || l2 != null) {
			sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			ListNode n = new ListNode(sum % 10);
			if (current == null) {
				current = n;
				head = n;
			} else {
				current.next = n;
				current = current.next;
			}
			carry = sum / 10;
		}
		if (carry == 1) {
			current.next = new ListNode(1);
		}
		return head != null ? head : new ListNode(0);
	}

	public static void main(String[] args) {
		AddTwoNumbers singlyLinkedList = new AddTwoNumbers();
		ListNode l11 = new ListNode(7);
		ListNode l12 = new ListNode(5);
		ListNode l13 = new ListNode(8);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(9);
		ListNode l23 = new ListNode(2);
		ListNode l24 = new ListNode(4);
		l11.next = l12;
		l12.next = l13;
		l21.next = l22;
		l22.next = l23;
		l23.next = l24;
		l11.displayList(singlyLinkedList.addTwoNumbers(l11, l21));
	}

}
