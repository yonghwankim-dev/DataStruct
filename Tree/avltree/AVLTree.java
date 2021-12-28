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
		
		// Ʈ���� ����� ���
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
		// newNode�� data�� root�� data���� ���� ���
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
		// newNode�� data�� root�� data���� ū ���
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
		// AVL Ʈ���� ��Ģ�� �°� �� �Ǿ����� �˻��մϴ�.
		checkBalance(newNode);
	}

	private void checkBalance(Node<T> node) {
		// ���� ���̰� 1 �ʰ� Ȥ�� -1 �̸� (AVL Ʈ�� ��Ģ ����)
		if((height(node.left)-height(node.right) > 1) || 
				(height(node.left)-height(node.right) < -1))
		{
			rebalance(node);
		}
		
		// �θ� ��带 �Լ� Ȯ���ؼ� ��Ʈ���� �ö󰩴ϴ�.
		if(node.parent==null)
		{
			return;
		}
		checkBalance(node.parent);
	}
	
	private void rebalance(Node<T> node) {
		if(height(node.left) - height(node.right) > 1)	// ���� �ڽ� > ������ �ڽ�
		{
			
			if(height(node.left.left) > height(node.left.right)) // ���� ���� Ʈ�� > ������ ���� Ʈ��
			{
				node = rightRotate(node);		// ���� ȸ��
			}
			else	// ���� ���� Ʈ�� < ������ ���� Ʈ��
			{
				node = leftRightRotate(node);	// ����-���� ȸ��
			}
		}
		else	// ���� �ڽ� < ������ �ڽ�
		{
			if(height(node.right.left) > height(node.right.right))	// ���� ���� Ʈ�� > ������ ���� Ʈ��
			{
				node = rightLeftRotate(node);	// ����-���� ȸ��
			}
			else	// ���� ���� Ʈ�� < ������ ���� Ʈ��
			{
				node = leftRotate(node);	// ���� ȸ��
			}
		}
		
		// ��Ʈ�� �ö����� �ݺ�
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
	
	// root ��带 �������� ���� ȸ��
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
	
	// root ��带 �������� ������ ȸ��
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

	// root ��带 �������� ����-������ ȸ��
	private Node<T> leftRightRotate(Node<T> root)
	{
		root.left = leftRotate(root.left);
		
		return rightRotate(root);
	}
	
	// root ��带 �������� ������-���� ȸ��
	private Node<T> rightLeftRotate(Node<T> root)
	{
		root.right = rightRotate(root.right);
		return leftRotate(root);
	}
	
	// ���� ��ȸ
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
