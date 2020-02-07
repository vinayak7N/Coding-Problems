package com.binarytee;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @author vinayak.nair
 *
 */

/*	
     10
   2	   5
6	    8	  3
 */
public class BinaryTree {
	Node root;

	public BinaryTree() {
		root = null;
	}

	static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}

	static void iterativePostOrder(Node node) {
		if (node == null)
			return;
		System.out.println("\nIterative PostOrder Traversal...");
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			node = stack1.pop();
			stack2.push(node);
			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
		}
		while (!stack2.isEmpty()) {
			node = stack2.pop();
			System.out.print(node.data + " ");
		}
	}

	static void iterativePreOrder(Node node) {
		if (node == null)
			return;
		System.out.println("\nIterative preorder traversal...");
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}

	}

	static void iterativeInOrder(Node node) {
		if (node == null)
			return;
		System.out.println("\nIterative Inorder traversal...");
		Stack<Node> stack = new Stack<>();

		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty())
					break;
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}

	public static boolean sameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
	}

	public static int sizeOfTree(Node node) {
		if (node == null)
			return 0;
		int leftSize = sizeOfTree(node.left);
		int rightSize = sizeOfTree(node.right);
		return leftSize + rightSize + 1;
	}

	public static boolean rootToLeafSum(Node node, int sum, Stack<Integer> result) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			if (node.data == sum) {
				result.push(node.data);
				return true;
			} else {
				return false;
			}
		}
		if (rootToLeafSum(node.left, sum - node.data, result) || rootToLeafSum(node.right, sum - node.data, result)) {
			result.push(node.data);
			return true;
		}
		return false;
	}

	public static int heightOfTree(Node node) {
		if (node == null)
			return 0;
		int leftHeight = heightOfTree(node.left);
		int rightHeight = heightOfTree(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void levelOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.println("Level Order traversal...");
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public static void reverseLevelOrderTraversal(Node node) {
		if (node == null)
			return;
		System.out.println("\nReverse Level order traversal: ");
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.right != null)
				queue.add(node.right);
			if (node.left != null)
				queue.add(node.left);
			stack.push(node);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().data+" ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(6);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(3);
		System.out.println("Preorder traversal...");
		preOrder(tree.root);
		System.out.println("\nPostorder traversal...");
		postOrder(tree.root);
		System.out.println("\nInorder traversal...");
		inOrder(tree.root);
		iterativePostOrder(tree.root);
		iterativePreOrder(tree.root);
		iterativeInOrder(tree.root);
		BinaryTree firstTree = new BinaryTree();
		firstTree.root = new Node(10);
		firstTree.root.left = new Node(16);
		firstTree.root.right = new Node(15);
		firstTree.root.right.left = new Node(18);
		BinaryTree secondTree = new BinaryTree();
		secondTree.root = new Node(10);
		secondTree.root.left = new Node(16);
		secondTree.root.right = new Node(15);
		secondTree.root.right.left = new Node(18);
		secondTree.root.right.left.right = new Node(25);
		System.out.println("\nIs first and second tree are same " + sameTree(firstTree.root, secondTree.root));
		System.out.println("Size of tree is: " + sizeOfTree(tree.root));
		System.out.println("Height of tree: " + heightOfTree(tree.root));
		Stack<Integer> result = new Stack<>();
		boolean b = rootToLeafSum(tree.root, 23, result);
		if (b) {
			System.out.print("Path for sum " + 23 + "--");
			result.forEach(l -> System.out.print(l + " "));
		} else {
			System.out.println("No path exist...");
		}
		System.out.println();
		levelOrderTraversal(tree.root);
		reverseLevelOrderTraversal(tree.root);
	}

}
