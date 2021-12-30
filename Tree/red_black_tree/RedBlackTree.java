package Tree.red_black_tree;

public class RedBlackTree<K, V> {
	Node<K,V> root;
	int size;
	
	private class Node<K,V>{
		K key;
		V value;
		Node<K,V> left, right, parent;
		boolean isLeftChild, black;
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			left = right = parent = null;
			black = false;
			isLeftChild = false;
		}
	}
	
	public void add(K key, V value)
	{
		Node<K,V> newNode = new Node<K,V>(key,value);
		
		// 트리가 비었을 경우
		if(root==null)
		{
			root = newNode;
			root.black = true;
			size++;
			return;
		}
		
		// 트리에 노드가 있을 경우 재귀 메서드 사용
		add(root, newNode);
		size++;
	}
	
	// add 재귀함수
	private void add(Node<K,V> parent, Node<K,V> newNode)
	{
		// newNode.data < parent.data
		if(((Comparable<K>)newNode.key).compareTo(parent.key)<=0)
		{
			if(parent.left==null)
			{
				parent.left = newNode;
				newNode.parent = parent;
				newNode.isLeftChild = true;
				return;
			}
			add(parent.left, newNode);
			return;
		}
		// newNode.data > parent.data
		else if(((Comparable<K>)newNode.key).compareTo(parent.key)>0)
		{
			if(parent.right==null)
			{
				parent.right = newNode;
				newNode.parent = parent;
				newNode.isLeftChild = false;
				return;
			}
			add(parent.right, newNode);
			return;
		}
		
		checkColor(newNode);
	
	}

	private void checkColor(Node<K, V> node) {
		// 루트는 항상 검은색이므로 색을 확인할 필요가 없음
		if(node==root)
		{
			return;
		}
		// Red 노드가 2개가 연속으로 나오는 경우(레드 블랙 트리 규칙 위반)
		if(!node.black && !!node.parent.black)
		{
			correctTree(node);
		}
		// 부모 노드를 계속 확인합니다.
		checkColor(node.parent);
		
	}

	private void correctTree(Node<K, V> node) {
		// node의 부모 노드 = 왼쪽 자식, node의 이모 노드 = 오른쪽 자식
		if(node.parent.isLeftChild)
		{
			// 이모 노드가 검은색(이모 노드가 null인 경우도 포함)
			if(node.parent.parent.right == null || node.parent.parent.right.black)
			{
				//회전
				rotate(node);
				return;
			}
			// 이모 노드가 빨간색
			if(node.parent.parent.right!=null)
			{
				// 색상 변환
				node.parent.parent.right.black = true;
			}
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		}
		// node의 부모 노드 = 오른쪽 자식, node의 이모 노드 = 왼쪽 자식
		else
		{
			// 이모 노드가 검은색(이모 노드가 null인 경우 포함)
			if(node.parent.parent.left==null || node.parent.parent.left.black)
			{
				rotate(node);
				return;
			}
			// 이모 노드가 빨간색
			if(node.parent.parent.left!=null)
			{
				// 색상 변환
				node.parent.parent.black = true;
			}
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		}
	}

	private void rotate(Node<K, V> node) {
		// 현재 노드가 왼쪽 자식
		if(node.isLeftChild)
		{
			// 부모 노드가 왼쪽 자식
			if(node.parent.isLeftChild)
			{
				// 조부모 노드를 우측 회전
				rightRotate(node.parent.parent);
				node.black = false;
				node.parent.black = true;
				if(node.parent.right!=null)
				{
					node.parent.right.black = false;
				}
				return;
			}
			// 부모 노드가 오른쪽 자식
			else
			{
				rightLeftRotate(node.parent.parent);
				node.black = true;
				node.right.black = false;
				node.left.black = false;
				return;
			}
		}
		// 현재 노드가 오른쪽 자식
		else
		{
			// 부모 노드가 왼쪽 자식
			if(node.parent.isLeftChild)
			{
				leftRightRotate(node.parent.parent);
				node.black = true;
				node.right.black = false;
				node.left.black = false;
			}
			// 부모 노드가 오른쪽 자식
			else
			{
				leftRotate(node.parent.parent);
				node.black = false;
				node.parent.black = true;
				if(node.parent.left!=null)
				{
					node.parent.left.black = false;
				}
				return;
			}
		}
	}
}
