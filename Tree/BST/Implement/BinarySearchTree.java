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
	// E 값을 가진 객체를 탐색
	public Node<E> search(E data)
	{
		return search(root, data);
	}
	
	// root 노드를 기준으로 data 값을 가진 객체 탐색
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
	
	// obj 객체를 이진 탐색 트리에 추가
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
	
	// obj 객체가 포함하는지 검사
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
			// 삭제할 노드가 하나의 자식 노드이거나 둘다 자식이 없는 경우
			if(root.left==null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left;
			}
			
			// 삭제할 노드가 왼쪽 자식, 오른쪽 자식 모두 있는 경우
			// inorder successor 탐색 (node의 값보다 큰수 중 제일 작은 값)
			// inorder successor 노드의 값을 복사하여 저장
			root.data = minValue(root.right).data;
			
			// inorder successor 노드를 제거
			root.right = remove(root.right, root.data);	
		}	
		return root;
	}
	
	// root 노드를 기준으로 제일 작은값을 가진 노드 반환
	private Node<E> minValue(Node<E> root) {
		Node<E> current = root;
		
		while(current.left!=null)
		{
			current = current.left;
		}
		
		return current;
	}

	// root 노드를 기준으로 왼쪽 회전
	public Node<E> leftRotate(Node<E> root)
	{
		Node<E> temp = root.right;
		
		root.right = temp.left;
		temp.left = root;
		
		return temp;	
	}
	
	// root 노드를 기준으로 오른쪽 회전
	public Node<E> rightRotate(Node<E> root)
	{
		Node<E> temp = root.left;
		
		root.left = temp.right;
		temp.right = root;
		
		return temp;
	}

	// root 노드를 기준으로 왼쪽-오른쪽 회전
	public Node<E> leftRightRotate(Node<E> root)
	{
		root.left = leftRotate(root.left);
		return rightRotate(root);
	}
	
	// root 노드를 기준으로 오른쪽-왼쪽 회전
	public Node<E> rightLeftRotate(Node<E> root)
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
