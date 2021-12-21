package Tree.BST.Implement.boost;

public class BinarySearchTree<E> {
	Node<E> root;
	int currentSize;
		
	public BinarySearchTree() {
		this.root = null;
		this.currentSize = 0;
	}

	class Node<E>{
		E data;
		Node<E> left, right;
		
		Node(E obj)
		{
			this.data = obj;
			left = right = null;
		}
	}
	
	public void add(E obj){
		if(root==null)
		{
			root = new Node<E>(obj);
		}
		else
		{
			add(obj, root);
		}
		currentSize++;
	}
	
	private void add(E obj, Node<E> node)
	{
		// go to the right
		if(((Comparable<E>)obj).compareTo(node.data)>0)
		{
			if(node.right==null)
			{
				node.right = new Node<E>(obj);
				return;
			}
			add(obj, node.right);
			return;
		}
		
		// go to the left
		if(node.left==null)
		{
			node.left = new Node<E>(obj);
			return;
		}
		add(obj, node.left);
		return;
	}
	
	public boolean contains(E obj)
	{
		return contains(obj,root);
	}
	private boolean contains(E obj, Node<E> node)
	{
		if(node==null)
		{
			// tree is empty
			return false;
		}
		
		if(((Comparable<E>)obj).compareTo(node.data)==0)
		{
			// equals node's data
			return true;
		}
		if(((Comparable<E>)obj).compareTo(node.data)>0)
		{
			// go to the right
			return contains(obj,node.right);
		}
		// go to the left
		return contains(obj, node.left);
	}
	
	public void inorderTraversal()
	{		
		inorderTraversal(this.root);
		System.out.println();
	}
	private void inorderTraversal(Node<E> root)
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
