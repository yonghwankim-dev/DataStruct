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
		if(((Comparable<T>)newNode).compareTo(root.data)<=0)
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

	private void checkBalance(Node<T> newNode) {
		return;
	}
}
