import java.util.Stack;

/*
 * @author vinayak.nair
 *
 */

/*	
     10
   2	  5
6	   8	  3
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
	}

}

class Node {
	int data;
	Node left, right;

	Node() {
		left = right = null;
	}

	Node(int data) {
		super();
		this.data = data;
	}

}
