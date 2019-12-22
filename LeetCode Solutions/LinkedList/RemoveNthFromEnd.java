package com.LinkedList;

/**
 * @author Vinayak Nair$
 *
 */

public class RemoveNthFromEnd {

	
	private ListNode removeNthFromEnd(ListNode head,int n) {
		if(head==null)
			return head;
		int size=length(head);
		if(n==size) {
			System.out.println("deleted node "+head.val);
			head=head.next;
			return head;
		}
		int pos=size-n;
		int i=0;
		ListNode prev=null,current=head;
		while(i<pos) {
			prev=current;
			current=current.next;
			i++;
		}
		System.out.println("Deleted node "+current.val);
		prev.next=current.next;
		current.next=null;
		return head;
	}
	
	private int length(ListNode head) {
		if(head==null)
			return 0;
		int count=0;
		while(head!=null) {
			head=head.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		RemoveNthFromEnd singlyLinkedList=new RemoveNthFromEnd();
		ListNode head=new ListNode(10);
		ListNode second=new ListNode(20);
		ListNode third=new ListNode(30);
		ListNode fourth=new ListNode(40);
		ListNode fifth=new ListNode(50);
		head.next=second;
		second.next=third;
		third.next=fourth;
		fourth.next=fifth;
		head.displayList(singlyLinkedList.removeNthFromEnd(head, 5));
	}

}
