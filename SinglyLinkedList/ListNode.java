package com.SinglyLinkedList;

public class ListNode {
	private int iData;
	private double dData;
	private ListNode next;
	
	public ListNode(int iData,double dData) {
		this.iData=iData;
		this.dData=dData;
	}
	
	public int getiData() {
		return iData;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}

	public double getdData() {
		return dData;
	}

	public void setdData(double dData) {
		this.dData = dData;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "{"+iData+", "+dData+"}";
	}
}
