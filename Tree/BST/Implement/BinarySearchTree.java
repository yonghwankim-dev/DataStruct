package Tree.BST.Implement;

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
	// E ���� ���� ��ü�� Ž��
	public Node<E> search(E data)
	{
		return search(root, data);
	}
	
	// root ��带 �������� data ���� ���� ��ü Ž��
	private Node<E> search(Node<E> root, E data)
	{
		if(root==null)
		{
			return null;
		}
		
		if(((Comparable<E>)data).compareTo(root.data)<0)
		{
			return search(root.left, data);
		}
		else if(((Comparable<E>)data).compareTo(root.data)>0)
		{
			return search(root.right, data);
		}
		else
		{
			return root;
		}
	}
	
	// obj ��ü�� ���� Ž�� Ʈ���� �߰�
	public void add(E obj){
		if(root==null)
		{
			root = new Node<E>(obj);
		}
		else
		{
			add(root, obj);
		}
		currentSize++;
	}
	
	private void add(Node<E> root, E obj)
	{	
		if(((Comparable<E>)obj).compareTo(root.data)>0)		// go to the right
		{
			if(root.right==null)
			{
				root.right = new Node<E>(obj);
			}
			else
			{
				add(root.right, obj);
			}
		}
		else if(((Comparable<E>)obj).compareTo(root.data)<0)	// go to the left
		{
			if(root.left==null)
			{
				root.left = new Node<E>(obj);
			}else
			{
				add(root.left, obj);
			}
		}
		return;	
	}
	
	// obj ��ü�� �����ϴ��� �˻�
	public boolean contains(E obj)
	{
		return contains(root, obj);
	}
	
	private boolean contains(Node<E> root,E obj)
	{
		if(root==null)
		{
			// tree is empty
			return false;
		}
		
		if(((Comparable<E>)obj).compareTo(root.data)<0)
		{
			// go to the left
			return contains(root.left, obj);
		}
		else if(((Comparable<E>)obj).compareTo(root.data)>0)
		{
			// go to the right
			return contains(root.right, obj);
		}
		else
		{
			// equals
			return true;
		}
		
		
	}
	
	public void remove(E obj)
	{
		root = remove(root, obj);
	}
	
	private Node<E> remove(Node<E> root, E obj)
	{
		// base case : tree is empty
		if(root==null)
		{
			return root;
		}

		// go to the left
		if(((Comparable<E>)obj).compareTo(root.data)<0)
		{
			root.left = remove(root.left, obj);			
		}
		// go to the right		
		else if(((Comparable<E>)obj).compareTo(root.data)>0)
		{
			root.right = remove(root.right, obj);
		}
		// equals root's data
		else if(((Comparable<E>)obj).compareTo(root.data)==0)
		{
			// ������ ��尡 �ϳ��� �ڽ� ����̰ų� �Ѵ� �ڽ��� ���� ���
			if(root.left==null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left;
			}
			
			// ������ ��尡 ���� �ڽ�, ������ �ڽ� ��� �ִ� ���
			// inorder successor Ž�� (node�� ������ ū�� �� ���� ���� ��)
			// inorder successor ����� ���� �����Ͽ� ����
			root.data = minValue(root.right).data;
			
			// inorder successor ��带 ����
			root.right = remove(root.right, root.data);	
		}	
		return root;
	}
	
	// root ��带 �������� ���� �������� ���� ��� ��ȯ
	private Node<E> minValue(Node<E> root) {
		Node<E> current = root;
		
		while(current.left!=null)
		{
			current = current.left;
		}
		
		return current;
	}

	// root ��带 �������� ���� ȸ��
	public Node<E> leftRotate(Node<E> root)
	{
		Node<E> temp = root.right;
		
		root.right = temp.left;
		temp.left = root;
		
		return temp;	
	}
	
	// root ��带 �������� ������ ȸ��
	public Node<E> rightRotate(Node<E> root)
	{
		Node<E> temp = root.left;
		
		root.left = temp.right;
		temp.right = root;
		
		return temp;
	}

	// root ��带 �������� ����-������ ȸ��
	public Node<E> leftRightRotate(Node<E> root)
	{
		root.left = leftRotate(root.left);
		return rightRotate(root);
	}
	
	// root ��带 �������� ������-���� ȸ��
	public Node<E> rightLeftRotate(Node<E> root)
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
