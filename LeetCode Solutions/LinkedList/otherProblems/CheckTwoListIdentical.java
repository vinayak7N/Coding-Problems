
package com.LinkedList.otherProblems;

import com.LinkedList.ListNode;

/*
 * @author Vinayak Nair$
 *
 */
public class CheckTwoListIdentical {

	public static boolean checkTwoListIdentical(ListNode first, ListNode second) {
		if (first == null || second == null)
			return false;
		while(first!=null && second!=null) {
			if(first.val!=second.val)
				return false;
			else {
				first=first.next;
				second=second.next;
			}
		}
		return (first==null && second==null);
	}

	public static void main(String[] args) {
		ListNode firsta = new ListNode(3);
		ListNode firstb = new ListNode(6);
		ListNode firstc = new ListNode(7);
		ListNode firstd = new ListNode(9);
		ListNode firste = new ListNode(11);
	//	ListNode firstf = new ListNode(14);
		firsta.next = firstb;
		firstb.next = firstc;
		firstc.next = firstd;
		firstd.next = firste;
	//	firste.next = firstf;
		ListNode seconda = new ListNode(3);
		ListNode secondb = new ListNode(6);
		ListNode secondc = new ListNode(7);
		ListNode secondd = new ListNode(9);
		seconda.next = secondb;
		secondb.next = secondc;
		secondc.next = secondd;
		System.out.println("Is two list are identical: "+checkTwoListIdentical(firsta, seconda));
	}

}
