package Tree.BST;

// 이진 탐색 트리의 탐색, 삽입, 삭제를 예제
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

		// 루트 노드가 비어있는 경우 생성
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)	// 왼쪽 서브트리로 이동
		{
			root.left = insertRec(root.left, key);
		}
		else if (key > root.key)	// 오른쪽 서브트리로 이동
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