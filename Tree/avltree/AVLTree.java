package Tree.avltree;


public class AVLTree<T> {
	private Node<T> root;
	int currentSize;
	
	private class Node<T>{
		T data;
		Node<T> left, right, parent;
		
		public Node(T obj)
		{
			this.data = obj;
			left = right = parent = null;
		}
	}
	
	public AVLTree() {
		root = null;
		currentSize = 0;
	}
	
	public void add(T obj) {
		Node<T> node = new Node<T>(obj);
		
		// 트리가 비었을 경우
		if(root==null)
		{
			root = node;
			currentSize++;
			return;
		}
		else
		{
			add(root, node);
		}
	}
	private void add(Node<T> root, Node<T> newNode)
	{
		// newNode의 data가 root의 data보다 작은 경우
		if(((Comparable<T>)newNode.data).compareTo(root.data)<=0)	
		{
			if(root.left==null)
			{
				root.left = newNode;
				newNode.parent = root;
				currentSize++;
			}
			else
			{
				add(root.left, newNode);
			}
		}
		// newNode의 data가 root의 data보다 큰 경우
		else	
		{
			if(root.right==null)
			{
				root.right = newNode;
				newNode.parent = root;
				currentSize++;
			}
			else
			{
				add(root.right, newNode);
			}
		}
		// AVL 트리가 규칙에 맞게 잘 되었는지 검사합니다.
		checkBalance(newNode);
	}

	private void checkBalance(Node<T> node) {
		// 높이 차이가 1 초과 혹은 -1 미만 (AVL 트리 규칙 위반)
		if((height(node.left)-height(node.right) > 1) || 
				(height(node.left)-height(node.right) < -1))
		{
			rebalance(node);
		}
		
		// 부모 노드를 게속 확인해서 루트까지 올라갑니다.
		if(node.parent==null)
		{
			return;
		}
		checkBalance(node.parent);
	}
	
	private void rebalance(Node<T> node) {
		if(height(node.left) - height(node.right) > 1)	// 왼쪽 자식 > 오른쪽 자식
		{
			
			if(height(node.left.left) > height(node.left.right)) // 왼쪽 서브 트리 > 오른쪽 서브 트리
			{
				node = rightRotate(node);		// 우측 회전
			}
			else	// 왼쪽 서브 트리 < 오른쪽 서브 트리
			{
				node = leftRightRotate(node);	// 좌측-우측 회전
			}
		}
		else	// 왼쪽 자식 < 오른쪽 자식
		{
			if(height(node.right.left) > height(node.right.right))	// 왼쪽 서브 트리 > 오른쪽 서브 트리
			{
				node = rightLeftRotate(node);	// 우측-좌측 회전
			}
			else	// 왼쪽 서브 트리 < 오른쪽 서브 트리
			{
				node = leftRotate(node);	// 좌측 회전
			}
		}
		
		// 루트로 올때까지 반복
		if(node.parent==null)
		{
			root = node;
		}
	}

	private int height(Node<T> node)
	{
		if(node==null)
		{
			return 0;
		}
		else
		{
			return Math.max(height(node.left), height(node.right))+1;
		}	
	}
	
	// root 노드를 기준으로 왼쪽 회전
	private Node<T> leftRotate(Node<T> root)
	{
		Node<T> temp = root.right;
		
		root.right = temp.left;
		temp.left = root;
		
		temp.parent = root.parent;
		
		if(root.parent!=null && root.parent.left==root)
		{
			root.parent.left = temp;
		}
		else if(root.parent!=null && root.parent.right==root)
		{
			root.parent.right = temp;
		}
		
		root.parent = temp;
		return temp;	
	}
	
	// root 노드를 기준으로 오른쪽 회전
	private Node<T> rightRotate(Node<T> root)
	{
		Node<T> temp = root.left;
		
		root.left = temp.right;
		temp.right = root;
		
		temp.parent = root.parent;
		
		if(root.parent!=null && root.parent.left==root)
		{
			root.parent.left = temp;
		}
		else if(root.parent!=null && root.parent.right==root)
		{
			root.parent.right = temp;
		}
		
		root.parent = temp;
		
		return temp;
	}

	// root 노드를 기준으로 왼쪽-오른쪽 회전
	private Node<T> leftRightRotate(Node<T> root)
	{
		root.left = leftRotate(root.left);
		
		return rightRotate(root);
	}
	
	// root 노드를 기준으로 오른쪽-왼쪽 회전
	private Node<T> rightLeftRotate(Node<T> root)
	{
		root.right = rightRotate(root.right);
		return leftRotate(root);
	}
	
	// 중위 순회
	public void inorderTraversal()
	{		
		inorderTraversal(this.root);
		System.out.println();
	}
	
	private void inorderTraversal(Node<T> root)
	{
		if(root==null)
		{
			return;
		}
		
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}
}
