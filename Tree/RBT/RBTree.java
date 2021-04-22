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
					swap(parent_pt, grand_parent_pt);
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
					swap(parent_pt, grand_parent_pt);
					pt = parent_pt;
				}
			}
		}
		root.color = Color.BLACK;
		return root;
	}

	private void swap(Node x, Node y) {
		// TODO Auto-generated method stub
		Color temp = x.color;
		x.color = y.color;
		y.color = temp;
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
	
	void inorder()
	{
		inorderHelper(root);
		System.out.println();
	}
	
	// 중위 순회
	private void inorderHelper(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		inorderHelper(root.left);
		System.out.print(root.data + " ");
		inorderHelper(root.right);
	}
	
	void levelorder()
	{
		levelorderHelper(root);
		System.out.println();
	}
	
	// 레벨 순회
	private void levelorderHelper(Node root)
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
	
	
}
