import java.util.Scanner;

public class HeightOfBinaryTree {

	static Node root;
	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		System.out.println("Create a binary tree...");
		root = createTree();

		System.out.println("Height of tree: " + heightOfTree(root));
	}

	public static Node createTree() {

		Node node = null;
		System.out.println("Enter data:");
		int data = sc.nextInt();
		if (data == -1)
			return null;

		node = new Node(data);
		System.out.println("Enter left child: " + data);
		node.left = createTree();
		System.out.println("Enter right child " + data);
		node.right = createTree();

		return node;
	}

	private static int heightOfTree(Node root) {

		if (root == null) {
			return 0;
		}

		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);

		return 1 + Math.max(leftHeight, rightHeight);
	}

}
