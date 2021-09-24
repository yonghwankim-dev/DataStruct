package Tree.BST;

// ���� Ž�� Ʈ���� Ž��, ����, ������ ����
public class BinarySearchTree {
	static class Node 
	{
		int key;
		Node left, right;

		public Node(int item) 
		{
			key = item;
			left = right = null;
		}
	}

	Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {

		// ��Ʈ ��尡 ����ִ� ��� ����
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)	// ���� ����Ʈ���� �̵�
		{
			root.left = insertRec(root.left, key);
		}
		else if (key > root.key)	// ������ ����Ʈ���� �̵�
		{
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	void inorder() {
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {
		
	}
}