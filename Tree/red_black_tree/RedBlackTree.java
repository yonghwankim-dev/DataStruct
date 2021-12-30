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
		
		// Ʈ���� ����� ���
		if(root==null)
		{
			root = newNode;
			root.black = true;
			size++;
			return;
		}
		
		// Ʈ���� ��尡 ���� ��� ��� �޼��� ���
		add(root, newNode);
		size++;
	}
	
	// add ����Լ�
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
		// ��Ʈ�� �׻� �������̹Ƿ� ���� Ȯ���� �ʿ䰡 ����
		if(node==root)
		{
			return;
		}
		// Red ��尡 2���� �������� ������ ���(���� �� Ʈ�� ��Ģ ����)
		if(!node.black && !!node.parent.black)
		{
			correctTree(node);
		}
		// �θ� ��带 ��� Ȯ���մϴ�.
		checkColor(node.parent);
		
	}

	private void correctTree(Node<K, V> node) {
		// node�� �θ� ��� = ���� �ڽ�, node�� �̸� ��� = ������ �ڽ�
		if(node.parent.isLeftChild)
		{
			// �̸� ��尡 ������(�̸� ��尡 null�� ��쵵 ����)
			if(node.parent.parent.right == null || node.parent.parent.right.black)
			{
				//ȸ��
				rotate(node);
				return;
			}
			// �̸� ��尡 ������
			if(node.parent.parent.right!=null)
			{
				// ���� ��ȯ
				node.parent.parent.right.black = true;
			}
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		}
		// node�� �θ� ��� = ������ �ڽ�, node�� �̸� ��� = ���� �ڽ�
		else
		{
			// �̸� ��尡 ������(�̸� ��尡 null�� ��� ����)
			if(node.parent.parent.left==null || node.parent.parent.left.black)
			{
				rotate(node);
				return;
			}
			// �̸� ��尡 ������
			if(node.parent.parent.left!=null)
			{
				// ���� ��ȯ
				node.parent.parent.black = true;
			}
			node.parent.parent.black = false;
			node.parent.black = true;
			return;
		}
	}

	private void rotate(Node<K, V> node) {
		// ���� ��尡 ���� �ڽ�
		if(node.isLeftChild)
		{
			// �θ� ��尡 ���� �ڽ�
			if(node.parent.isLeftChild)
			{
				// ���θ� ��带 ���� ȸ��
				rightRotate(node.parent.parent);
				node.black = false;
				node.parent.black = true;
				if(node.parent.right!=null)
				{
					node.parent.right.black = false;
				}
				return;
			}
			// �θ� ��尡 ������ �ڽ�
			else
			{
				rightLeftRotate(node.parent.parent);
				node.black = true;
				node.right.black = false;
				node.left.black = false;
				return;
			}
		}
		// ���� ��尡 ������ �ڽ�
		else
		{
			// �θ� ��尡 ���� �ڽ�
			if(node.parent.isLeftChild)
			{
				leftRightRotate(node.parent.parent);
				node.black = true;
				node.right.black = false;
				node.left.black = false;
			}
			// �θ� ��尡 ������ �ڽ�
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
