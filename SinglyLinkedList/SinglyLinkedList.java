package com.SinglyLinkedList;

public class SinglyLinkedList {

	private ListNode head;

	public SinglyLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertFirst(int id, double dd) {
		ListNode newNode = new ListNode(id, dd);
		newNode.setNext(head);
		head = newNode;
	}

	public void insert(int id, double dd) {
		if (head == null) {
			insertFirst(id, dd);
			return;
		} else {
			ListNode current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			ListNode newNode = new ListNode(id, dd);
			current.setNext(newNode);
		}
	}

	public void insertAtPosition(int id, double dd, int pos) {
		if (isEmpty() || pos == 1) {
			insertFirst(id, dd);
			return;
		} else if (pos > length() + 1 || pos < 1) {
			System.out.println("Invalid Position for insertion!!!");
			return;
		} else {
			int size = length();
			int count = 2;
			ListNode newNode = new ListNode(id, dd);
			ListNode current = head;
			while (count <= size + 1) {
				if (count == pos) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					break;
				} else {
					current = current.getNext();
					count++;
				}
			}
		}
	}

	public void insertAfterGivenNode(int key, int id, double dd) {
		if (isEmpty()) {
			System.out.println("List does not exist!!!");
			return;
		} else {
			ListNode current = head;
			while (current.getiData() != key) {
				if (current.getNext() == null) {
					System.out.println("Key does not exist.Insertion not possible!!!");
					return;
				} else {
					current = current.getNext();
				}
			}
			ListNode newNode = new ListNode(id, dd);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}

	public ListNode deleteFirst() {
		if (isEmpty())
			return null;
		ListNode temp = head;
		head = head.getNext();
		temp.setNext(null);
		return temp;
	}

	public void displayList() {
		System.out.println("---------------Displaying List------------------");
		if (isEmpty())
			return;
		ListNode current = head;
		while (current != null) {
			System.out.print(current + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	public ListNode deleteLast() {
		if (isEmpty()) {
			System.out.println("Empty list.Deletion not possible!!!");
			return null;
		} else {
			ListNode current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			ListNode temp = current.getNext();
			current.setNext(null);
			return temp;
		}
	}

	public ListNode find(int key) {
		if (isEmpty())
			return null;
		ListNode current = head;
		while (current.getiData() != key) {
			if (current.getNext() == null) {
				System.out.println("Key not found!!!");
				return null;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}

	public ListNode delete(int key) {
		if (isEmpty())
			return null;
		ListNode current = head;
		ListNode previous = null;
		while (current.getiData() != key) {
			if (current.getNext() == null) {
				System.out.println("Key not found!!!");
				return null;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		if (current == head) {
			head = head.getNext();
		} else {
			previous.setNext(current.getNext());
			current.setNext(null);
		}
		return current;
	}

	public int length() {
		if (isEmpty()) {
			System.out.println("List is empty!!!");
			return -1;
		}
		ListNode current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public ListNode deleteAtGivenPosition(int pos) {
		if (isEmpty()) {
			System.out.println("List empty.Deletion not possible!!!");
			return null;
		} else if (pos == 1) {
			return deleteFirst();
		} else if (pos == length()) {
			return deleteLast();
		} else if (pos < 1 || pos > length() + 1) {
			System.out.println("Invalid position.Deletion not possible!!!");
			return null;
		} else {
			int count = 1;
			int size = length();
			ListNode current = head;
			ListNode previous = null;
			while (count <= size) {
				if (count == pos) {
					previous.setNext(current.getNext());
					current.setNext(null);
					break;
				} else {
					previous = current;
					current = current.getNext();
					count++;
				}
			}
			return current;
		}
	}

	public ListNode nthNodeFromEnd(int pos) {
		if (isEmpty()) {
			System.out.println("List is empty.Operation not allowed!!!");
			return null;
		} else if (pos < 1 || pos > length()) {
			System.out.println("Invalid position.");
			return null;
		} else {
			int size = length();
			ListNode current = head;
			int count = 1;
			while (current != null) {
				if (count <= size - pos) {
					current = current.getNext();
					count++;
				} else {
					break;
				}
			}
			return current;
		}
	}

	public void sortList() {
		//Currently sorting based on Integer data only
		if (isEmpty()) {
			System.out.println("Empty list.Operation not possible!!!");
			return;
		}
		ListNode current = head;
		while (current != null) {
			ListNode temp = current.getNext();
			while (temp != null) {
				if (temp.getiData() < current.getiData()) {
					int value = temp.getiData();
					temp.setiData(current.getiData());
					current.setiData(value);
				} else {
					temp = temp.getNext();
				}
			}
			current = current.getNext();
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.insertFirst(22, 2.99);
		singlyLinkedList.insertFirst(44, 4.99);
		singlyLinkedList.insertFirst(66, 6.99);
		singlyLinkedList.insertFirst(88, 8.99);
		singlyLinkedList.displayList();
		// System.out.println("Deleted first node: " + singlyLinkedList.deleteFirst());
		System.out.println("Finding element: " + singlyLinkedList.find(88));
		// System.out.println("Deleting element: " + singlyLinkedList.delete(22));
		System.out.println("Length: " + singlyLinkedList.length());
		singlyLinkedList.insert(99, 9.99);
		singlyLinkedList.displayList();
		singlyLinkedList.insertAtPosition(100, 10.99, 6);
		singlyLinkedList.insertAfterGivenNode(100, 11, 1.11);
		singlyLinkedList.displayList();
		// System.out.println("Deleted last node: " + singlyLinkedList.deleteLast());
		// System.out.println("Delete at given position: " +
		// singlyLinkedList.deleteAtGivenPosition(8));
		System.out.println("Nth node from end: " + singlyLinkedList.nthNodeFromEnd(6));
		System.out.println("Before Sorting......");
		singlyLinkedList.displayList();
		singlyLinkedList.sortList();
		System.out.println("After Sorting.....");
		singlyLinkedList.displayList();
	}
}
