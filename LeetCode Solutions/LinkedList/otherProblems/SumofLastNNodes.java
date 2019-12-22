package com.LinkedList.otherProblems;

/**
 * @author Vinayak Nair$
 *
 */
import com.LinkedList.ListNode;
import com.LinkedList.RemoveNthFromEnd;

public class SumofLastNNodes {

	public static int sumOfLastNNodes(ListNode head, int pos) {
		if (head == null || pos <= 0)
			return 0;
		int sum = 0;
		ListNode current = head;
		while (head != null && pos > 0) {
			sum += head.val;
			head=head.next;
			pos--;
		}
		if (head == null) {
			if (pos != 0) {
				System.out.println("Invalid position");
				return 0;
			} else {
				return sum;
			}
		}
		while (head.next != null) {
			head = head.next;
			current = current.next;
		}
		current = current.next;
		sum = 0;
		while (current != null) {
			sum += current.val;
			current = current.next;
		} 
		return sum;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		ListNode fourth=new ListNode(40);
		ListNode fifth=new ListNode(50);
		head.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		System.out.println("Sum of Last N Nodes: "+SumofLastNNodes.sumOfLastNNodes(head, 2));
	}

}
