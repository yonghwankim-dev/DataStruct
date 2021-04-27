package Tree.RBT;

import java.util.LinkedList;
import java.util.Queue;

import Tree.RBT.Color;

public class RBTree {
	Node root;
	
	private class Node
	{
		int data;
		Color color;
		Node left, right, parent;
		
		Node(int data)
		{
			this.data = data;
			left = right = parent = null;
			color = Color.RED;
		}
		
		// returns instance to uncle
		Node uncle()
		{
			// if no parent or grandparent, then no uncle
			if(parent==null || parent.parent==null)
			{
				return null;
			}
			
			if(parent.isOnLeft())
			{
				// uncle on right
				return parent.parent.right;
			}
			else
			{
				return parent.parent.left;
			}
		}
		
		// check if node is left child of parent
		boolean isOnLeft()
		{
			return this == parent.left;
		}
		
		// returns instance to sibling
		Node sibling()
		{
			// sibling null if no parent
			if(parent==null)
			{
				return null;
			}
			
			if(isOnLeft())
			{
				return parent.right;
			}
			return parent.left;
		}
		
		// moves node down and moves given node in its place
		void moveDown(Node nParent)
		{
			if(parent!=null)
			{
				if(isOnLeft())
				{
					parent.left = nParent;
				}
				else
				{
					parent.right = nParent;
				}
			}
			nParent.parent = parent;
			parent = nParent;
		}
		
		boolean hasRedChild()
		{
			return (left!=null && left.color==Color.RED) ||
					(right!=null && right.color==Color.RED);
		}
	}
	
	RBTree() {
		this.root = null;
	}
	

	// x 기준 왼쪽 회전
	private Node rotateLeft(Node root, Node pt)
	{
		Node pt_right = pt.right;
		
		pt.right = pt_right.left;
		
		if(pt.right != null)
		{
			pt.right.parent = pt;
		}
		
		pt_right.parent = pt.parent;
		
		if(pt.parent==null)
		{
			root = pt_right;
		}
		else if(pt==pt.parent.left)
		{
			pt.parent.left = pt_right;
		}
		else
		{
			pt.parent.right = pt_right;
		}
		
		pt_right.left = pt;
		pt.parent = pt_right;
		
		return root;
	}
	
	// x 기준 오른쪽 회전
	private Node rotateRight(Node root, Node pt)
	{
		Node pt_left = pt.left;
		
		pt.left = pt_left.right;
		
		if(pt.left != null)
		{
			pt.left.parent = pt;
		}
		
		pt_left.parent = pt.parent;
		
		if(pt.parent==null)
		{
			root = pt_left;
		}
		else if(pt==pt.parent.left)
		{
			pt.parent.left = pt_left;
		}
		else
		{
			pt.parent.right = pt_left;
		}
		
		pt_left.right = pt;
		pt.parent = pt_left;
		
		return root;
	}
	
	// This function fixes violations
	// caused by BST insertion
	Node fixViolation(Node root, Node pt)
	{
		Node parent_pt = null;
		Node grand_parent_pt = null;
		
		while((pt!=root) && (pt.color != Color.BLACK)
				&& (pt.parent.color==Color.RED))
		{
			parent_pt = pt.parent;
			grand_parent_pt = pt.parent.parent;
			
			/*
			 * Case : A
			 * Parent of pt is left child
			 * of Grand-parent of pt
			 * */
			if(parent_pt == grand_parent_pt.left)
			{
				Node uncle_pt = grand_parent_pt.right;
				
				/* Case : 1
				 * The uncle of pt is also red
				 * Only Recoloring required
				 * */
				if(uncle_pt != null && uncle_pt.color==Color.RED)
				{
					grand_parent_pt.color = Color.RED;
					parent_pt.color = Color.BLACK;
					uncle_pt.color = Color.BLACK;
					pt = grand_parent_pt;
				}
				else
				{
					/* Case : 2
					 * pt is right child of its parent
					 * Left-rotation required
					 * */
					if(pt==parent_pt.right)
					{
						root = rotateLeft(root,parent_pt);
						pt = parent_pt;
						parent_pt = pt.parent;
					}
					
					/* Case : 3
					 * pt is left child of its parent
					 * Right-rotation required
					 * */
					root = rotateRight(root, grand_parent_pt);
					swapColors(parent_pt, grand_parent_pt);
					pt = parent_pt;
				}
			}
			/* Case : B
			 * Parent of pt is right child
			 * of Grand-parent of pt
			 * */
			else
			{
				Node uncle_pt = grand_parent_pt.left;
				
				/* Case : 1
				 * The uncle of pt is also red
				 * Only Recoloring required
				 * */
				if((uncle_pt != null) && (uncle_pt.color==Color.RED))
				{
					grand_parent_pt.color = Color.RED;
					parent_pt.color = Color.BLACK;
					uncle_pt.color = Color.BLACK;
					pt = grand_parent_pt;
				}
				else
				{
					/* Case : 2
					 * pt is left child of its parent
					 * Right-rotation required
					 * */
					if(pt==parent_pt.left)
					{
						root = rotateRight(root,parent_pt);
						pt = parent_pt;
						parent_pt = pt.parent;
					}
					
					/* Case : 3
					 * pt is right child of its parent
					 * Left-rotation required
					 * */
					root = rotateLeft(root, grand_parent_pt);
					swapColors(parent_pt, grand_parent_pt);
					pt = parent_pt;
				}
			}
		}
		root.color = Color.BLACK;
		return root;
	}

	private void swapColors(Node x, Node y) {
		// TODO Auto-generated method stub
		Color temp = x.color;
		x.color = y.color;
		y.color = temp;
	}
	
	private void swapValues(Node u, Node v)
	{
		int temp = u.data;
		u.data = v.data;
		v.data = temp;
	}
	
	// find node that do not have a left child
	// in the subtree of the given node
	Node successor(Node x)
	{
		Node temp = x;
		while(temp.left!=null)
		{
			temp = temp.left;
		}
		return temp;
	}

	// 트리에 노드 삽입
	void insert(final int data)
	{
		Node pt = new Node(data);
		
		// Do a normal BST insert
		root = BSTInsert(root, pt);
		
		// fix Red Black Tree violation
		root = fixViolation(root, pt);
	}
	
	/**
	 * A utility function to insert
	 * a new node with given key
	 * in BST
	 */
	private Node BSTInsert(Node root, Node pt)
	{
		/* If the tree is empty, return a new node*/
		if(root==null)
		{
			return pt;
		}
		
		/* Otherwise, recur down the tree*/
		if(pt.data < root.data)
		{
			root.left = BSTInsert(root.left, pt);
			root.left.parent = root;
		}
		else if(pt.data > root.data)
		{
			root.right = BSTInsert(root.right, pt);
			root.right.parent = root;
		}
		/* return the (unchanged) node pointer*/
		return root;
	}
	
	void printIninorder()
	{
		System.out.println("Inorder: ");
		if(root==null)
		{
			System.out.println("Tree is empty");
		}
		else
		{
			inorder(root);
		}
		
		System.out.println();
	}
	
	// 중위 순회
	private void inorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	void printLevelOrder()
	{
		System.out.println("Level order: ");
		if(root==null)
		{
			System.out.println("Tree is empty");
		}
		else
		{
			levelorder(root);
		}
		System.out.println();
	}
	
	// 레벨 순회
	private void levelorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node temp = q.peek();
			System.out.print(temp.data + " ");
			q.poll();
			
			if(temp.left != null)
			{
				q.add(temp.left);
			}
			if(temp.right != null)
			{
				q.add(temp.right);
			}	
		}
	}

	// utility function that deletes the node with given value
	void deleteByVal(int n) {
		if(root==null)
		{
			// Tree is empty
			return;
		}
		
		Node v = search(n);
		Node u = null;
		
		if(v.data!=n)
		{
			System.out.println("No node found to delete with value:");
			return;
		}
		deleteNode(v);
	}

	// deletes the given node
	void deleteNode(Node v) {
		Node u = BSTreplace(v);
		
		// True when u and v are both black
		boolean uvBlack = ((u==null || u.color==Color.BLACK) && (v.color==Color.BLACK));
		Node parent = v.parent;
		
		if(u==null)
		{
			// u is null therefore v is leaf
			if(v==root)
			{
				// v is root, making root null
				root = null;
			}
			else
			{
				if(uvBlack) 
				{
					// u and v both black
					// v is leaf, fix double black at v
					fixDoubleBlack(v);
				}
				else
				{
					// u or v is red
					if(v.sibling()!=null)
					{
						// sibling is not null, make it red
						v.sibling().color = Color.RED;
					}
				}
				
				// delete v from the ree
				if(v.isOnLeft())
				{
					parent.left = null;
				}
				else
				{
					parent.right = null;
				}
			}
			v = null;
			return;
		}
		
		if(v.left==null || v.right==null)
		{
			// v has 1 child
			if(v==root)
			{
				// v is root, assign the value of u to v, and delete u
				v.data = u.data;
				v.left = v.right = null;
				u = null;
			}
			else
			{
				// detach v from tree and move u up
				if(v.isOnLeft())
				{
					parent.left = u;
				}
				else
				{
					parent.right = u;
				}
				v = null;
				u.parent = parent;
				if(uvBlack)
				{
					// u and v both black, fix double black at u
					fixDoubleBlack(u);
				}
				else
				{
					// u or v red, color u black
					u.color = Color.BLACK;
				}
			}
			return;
		}
		// v has 2 children, swap values with successor and recurse
		swapValues(u, v);
		deleteNode(u);
	}

	void fixDoubleBlack(Node x) {
		if(x==root)
		{
			// Reached root
			return;
		}
		
		Node sibling = x.sibling();
		Node parent = x.parent;
		
		if(sibling==null)
		{
			// No sibiling, double black pushed up
			fixDoubleBlack(parent);
		}
		else
		{
			if(sibling.color==Color.RED)
			{
				// Sibling red
				parent.color = Color.RED;
				sibling.color = Color.BLACK;
				if(sibling.isOnLeft())
				{
					// left case
					rotateRight(root, parent);
				}
				else
				{
					rotateLeft(root, parent);
				}
				fixDoubleBlack(x);
			}
			else
			{
				// Sibling black
				if(sibling.hasRedChild())
				{
					// at least 1 red children
					if(sibling.left!=null && sibling.left.color==Color.RED)
					{
						if(sibling.isOnLeft())
						{
							// left left
							sibling.left.color = sibling.color;
							sibling.color = parent.color;
							rotateRight(root, parent);
						}
						else
						{
							// right left
							sibling.left.color = parent.color;
							rotateRight(root, sibling);
							rotateLeft(root, parent);
						}
					}
					else
					{
						if(sibling.isOnLeft())
						{
							// left right
							sibling.right.color = parent.color;
							rotateLeft(root, sibling);
							rotateRight(root, parent);
						}
						else
						{
							// right right
							sibling.right.color = sibling.color;
							sibling.color = parent.color;
							rotateLeft(root, parent);
						}
					}
					parent.color = Color.BLACK;
				}
				else
				{
					// 2 black children
					sibling.color = Color.RED;
					if(parent.color==Color.BLACK)
					{
						fixDoubleBlack(parent);
					}
					else
					{
						parent.color = Color.BLACK;
					}
				}
			}
		}
	}


	// find node that replaces a deleted node in BST
	private Node BSTreplace(Node x) {
		// when node have 2 children
		if(x.left!=null && x.right!=null)
		{
			return successor(x.right);
		}
		
		// when leaf
		if(x.left==null && x.right==null)
		{
			return null;
		}
		
		// when single child
		if(x.left!=null)
		{
			return x.left;
		}
		else
		{
			return x.right;
		}
	}


	// searches for given value
	// if ound returns the node (used for delete)
	// else returns the last node while traversing (used in insert)
	Node search(int n) {
		Node temp = root;
		while(temp!=null)
		{
			if(n < temp.data)
			{
				if(temp.left==null)
				{
					break;
				}
				else
				{
					temp = temp.left;
				}
			}
			else if(n==temp.data)
			{
				break;
			}
			else
			{
				if(temp.right==null)
				{
					break;
				}
				else
				{
					temp=temp.right;
				}
			}
		}
		
		return temp;
	}
	
	
}
