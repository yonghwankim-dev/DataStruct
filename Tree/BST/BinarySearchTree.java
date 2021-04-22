package Tree.BST;

// 이진 탐색 트리, 삽입, 탐색, 삭제 연산 수행
public class BinarySearchTree {
	
	/**
	 *  Class containing left
	 *  and right child of current node
	 *  and key value
	 */
	class Node
	{
		int key;
		Node left, right, parent;
		
		public Node(int item)
		{
			key = item;
			left = right = parent = null;
		}
	}
	
	
	// Root of BST
	Node root;
	
	// Constructor
	BinarySearchTree() {
		root = null;
	}
	
	// A utility function to search a given key in BST
	Node search(Node root, int key)
	{
		// Base Cases: root is null or key is present at root
		if(root==null || root.key==key)
		{
			return root;
		}
		
		// Key is greater than root's key
		if(root.key < key)
		{
			return search(root.right, key);
		}
		
		// Key is smaller than root's key
		return search(root.left, key);
	}
	
	// This method mainly calls insertRec()
	void insert(int key)
	{
		root = insertRec(root, key);
	}
	
	/**
	 * A recursive function to
	 * insert a new key in BST
	 */
	Node insertRec(Node root, int key)
	{
		/* If the tree is empty,
		 * return a new node
		 * */
		if(root==null)
		{
			root = new Node(key);
			return root;
		}
		
		/* Otherwise, recur down the tree*/
		if(key < root.key)
		{
			root.left = insertRec(root.left, key);
		}
		else if(key > root.key)
		{
			root.right = insertRec(root.right, key);
		}
		
		
		/* return the (unchanged) node pointer*/
		return root;
	}
	
	
	// This method mainly calls InorderRec()
	void inorder()
	{
		inorderRec(root);
	}
	
	// A utility function to
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if(root!=null)
		{
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}
	
	void deleteKey(int key)
	{
		root = deleteRec(root, key);
	}
	
	Node deleteRec(Node root, int key)
	{
		/* Base Case: If the tree is empty*/
		if(root==null)
		{
			return root;
		}
		
		/* Otherwise, recur down the tree*/
		if(key <root.key)
		{
			root.left = deleteRec(root.left, key);
		}
		else if(key > root.key)
		{
			root.right = deleteRec(root.right, key);
		}
		// if key is same as root's
		// key, then This is the
		// node to be deleted
		else
		{
			// node with only one child or no child
			if(root.left == null)
			{
				return root.right;
			}
			else if(root.right==null)
			{
				return root.left;
			}
			
			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			root.key = minValue(root.right);
			
			// Delete the inorder successor
			root.right = deleteRec(root.right, root.key);
		}

		
		return root;
	}

	int minValue(Node root)
	{
		int minV = root.key;
		while(root.left != null)
		{
			minV = root.left.key;
			root = root.left;
		}
		return minV;
	}
}
