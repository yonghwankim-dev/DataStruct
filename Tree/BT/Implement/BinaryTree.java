package Tree.BT.Implement;

import java.util.LinkedList;
import java.util.Queue;

// 이진 트리 삽입 및 삭제 예제

public class BinaryTree
{
    public static class Node
    {
        int key;
        Node left, right;
     
        public Node(int key)
        {
            this.key = key;
            left = right = null;
        }
    }
    
    Node root;
    Node temp = root;
    
    // 비어있는 트리
    public BinaryTree()
    {
        root = null;
    }
    
    // 생성자
    public BinaryTree(int key)
    {
        root = new Node(key);
    }
    
    // 이진 트리의 중위 순회
    private void inorder(Node node)
    {
    	if(node==null)
    	{
    		return;
    	}
    	
    	inorder(node.left);
    	System.out.print(node.key+" ");
    	inorder(node.right);
    }
    
    // 이진 트리 중복순회 호출
    public void inorderTraversal()
    {
    	inorder(this.root);
    	System.out.println();
    }
    
    // 이진 트리에 key값을 노드로 생성하여 삽입
    public void insert(int key)
    {
    	if(root==null) 
    	{
    		root = new Node(key);
    		return;
    	}
    	
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	
    	// 이진트리의 빈공간을 찾을때까지 level order 순회 수행
    	while(!q.isEmpty()) {
    		temp = q.peek();	// temp = q.remove();
    		q.remove();
    		
    		if(temp.left==null)
    		{
    			temp.left = new Node(key);
    			break;
    		}
    		else
    		{
    			q.add(temp.left);
    		}
    		
    		if(temp.right==null)
    		{
    			temp.right = new Node(key);
    			break;
    		}
    		else
    		{
    			q.add(temp.right);
    		}
    	}
    	
    }

}