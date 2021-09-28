package Tree.BST.Implement;

// 이진 탐색 트리의 탐색, 삽입, 삭제를 예제
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
	
	// 이진 탐색 트리에서 존재하는지 키를 제거하기 위한 재귀적인 메서드
	private Node deleteRec(Node root, int key) {
		// Base case : 만약 트리(root)가 비어있는 경우ㅜ
		if(root==null)
		{
			return root;
		}
		
		// Otherwise, 트리의 자식으로 이동
		if(key < root.key)
		{
			root.left = deleteRec(root.left, key);
		}
		else if(key > root.key)
		{
			root.right = deleteRec(root.right, key);
		}
		else	// 만약 삭제할 노드를 찾은 경우
		{
			// 삭제할 노드가 하나의 자식 노드이거나 둘다 자식이 없는경우 검사
			if(root.left==null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left;
			}
			
			// 삭제할 노드가 왼쪽 자식, 오른쪽 자식 모두 있는 경우
			// inorder successor를 탐색한다. (root의 값보다 큰수 중 제일 작은 값)
			root.key = minValue(root.right).key;
			
			// inorder successor 노드를 제거한다.
			root.right = deleteRec(root.right, root.key);
			
		}
		return root;
		
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
			root.left.parent = root;
		}
		else if (key > root.key)	// 오른쪽 서브트리로 이동
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
		// case 1 : 오른쪽 서브트리가 존재하는 경우
		if(n.right!=null)
		{
			return minValue(n.right);
		}
		
		// case 2 : 오른쪽 서브트리가 null인 경우
		Node p = n.parent;
		// root 노드의 경우 p=null이므로 null 반환,
		// n과 p의 관계가 오른쪽 자식과 부모인 관계동안 부모를 타고 올라간다.
		while(p!=null && n==p.right) {
			n = p;
			p = p.parent;
		}
		return p;
	}
	
	// n 트리를 기준으로 제일 작은 수의 노드를 반환
	private Node minValue(Node n)
	{
		Node current = n;
		
		// 노드 n을 기준으로 제일 왼쪽 자식 노드를 탐색한다.
		while(current.left!=null)
		{
			current = current.left;
		}
		return current;
		
	}
}