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

	private void checkBalance(Node<T> newNode) {
		return;
	}
}
