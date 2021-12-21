package Tree.BST.Implement.geeks;

// ���� Ž�� Ʈ���� Ž��, ����, ������ ����
public class BinarySearchTree {
	public static class Node 
	{
		int key;
		Node left, right, parent;

		public Node(int item) 
		{
			key = item;
			left = right = parent = null;
		}
	}

	Node root;

	BinarySearchTree() {
		root = null;
	}
	
	
	void delete(int key){
		root = deleteRec(root, key);
	}
	
	// ���� Ž�� Ʈ������ �����ϴ��� Ű�� �����ϱ� ���� ������� �޼���
	private Node deleteRec(Node root, int key) {
		// Base case : ���� Ʈ��(root)�� ����ִ� ����
		if(root==null)
		{
			return root;
		}
		
		// Otherwise, Ʈ���� �ڽ����� �̵�
		if(key < root.key)
		{
			root.left = deleteRec(root.left, key);
		}
		else if(key > root.key)
		{
			root.right = deleteRec(root.right, key);
		}
		else	// ���� ������ ��带 ã�� ���
		{
			// ������ ��尡 �ϳ��� �ڽ� ����̰ų� �Ѵ� �ڽ��� ���°�� �˻�
			if(root.left==null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left;
			}
			
			// ������ ��尡 ���� �ڽ�, ������ �ڽ� ��� �ִ� ���
			// inorder successor�� Ž���Ѵ�. (root�� ������ ū�� �� ���� ���� ��)
			root.key = minValue(root.right).key;
			
			// inorder successor ��带 �����Ѵ�.
			root.right = deleteRec(root.right, root.key);
			
		}
		return root;
		
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
			root.left.parent = root;
		}
		else if (key > root.key)	// ������ ����Ʈ���� �̵�
		{
			root.right = insertRec(root.right, key);
			root.right.parent = root;
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
	
	public Node inorderSuccessor(Node n)
	{
		// case 1 : ������ ����Ʈ���� �����ϴ� ���
		if(n.right!=null)
		{
			return minValue(n.right);
		}
		
		// case 2 : ������ ����Ʈ���� null�� ���
		Node p = n.parent;
		// root ����� ��� p=null�̹Ƿ� null ��ȯ,
		// n�� p�� ���谡 ������ �ڽİ� �θ��� ���赿�� �θ� Ÿ�� �ö󰣴�.
		while(p!=null && n==p.right) {
			n = p;
			p = p.parent;
		}
		return p;
	}
	
	// n Ʈ���� �������� ���� ���� ���� ��带 ��ȯ
	private Node minValue(Node n)
	{
		Node current = n;
		
		// ��� n�� �������� ���� ���� �ڽ� ��带 Ž���Ѵ�.
		while(current.left!=null)
		{
			current = current.left;
		}
		return current;
		
	}
}