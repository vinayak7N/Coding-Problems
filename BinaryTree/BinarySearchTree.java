package com.binarytee;

/*
 * @author vinayak.nair
 *
 */

/*		  10
	-5			25
-10		5		   36
 */
public class BinarySearchTree {
	Node root;

	public static Node searchInBST(Node root, int key) {
		if (root == null)
			return root;
		if (root.data == key)
			return root;
		else if (key < root.data)
			return searchInBST(root.left, key);
		else
			return searchInBST(root.right, key);
	}

	public static Node insertionInBST(Node root, int data) {
		Node newNode = new Node(data);
		if (root == null)
			return newNode;
		Node parent = null, current = root;
		while (current != null) {
			parent = current;
			if (current.data <= data) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		if (parent.data <= data) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		return root;
	}

	public static Node minimum(Node node) {
		if (node == null)
			return node;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static Node maximum(Node node) {
		if (node == null)
			return node;
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new Node(10);
		bst.root.left = new Node(-5);
		bst.root.left.left = new Node(-10);
		bst.root.left.right = new Node(5);
		bst.root.right = new Node(25);
		bst.root.right.right = new Node(36);
		Node node = searchInBST(bst.root, 36);
		if (node != null) {
			System.out.println("Found: " + node.data);
		} else {
			System.out.println("Not found...");
		}
		System.out.println("Minimum value in BST: " + minimum(bst.root).data);
		System.out.println("Maximum value in BST: " + maximum(bst.root).data);
	}

}
