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
    		temp = q.remove();
    		
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
    
    // 가장 깊고 오른쪽에 위치한 노드를 삭제
    public void deleteDeepest(Node delNode)
    {
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	
    	Node temp = null;
    	
    	// 오른쪽 자식 노드만을 계속 참조하면서 delNode를 탐색하고 삭제
    	while(!q.isEmpty())
    	{
    		temp = q.remove();
    		
    		if(temp==delNode)
    		{
    			temp = null;
    			return;
    		}
    		if(temp.right!=null)
    		{
    			if(temp.right==delNode)
    			{
    				temp.right=null;
    				return;
    			}
    			else {
    				q.add(temp.right);
        		}
    		}
    	}
    	
    	if(temp.left!=null)
    	{
    		if(temp.left==delNode)
    		{
    			temp.left = null;
    			return;
    		}
    		else
    		{
    			q.add(temp.left);
    		}
    	}
    }
    
    // 주어진 key값을 이진트리에서 탐색하여 제거
    public void delete(int key)
    {
    	// 이진 트리가 비어있는 경우
    	if(root==null)
    	{
    		return;
    	}
    	
    	// 이진트리가 노드가 1개인 경우
    	if(root.left==null && root.right==null)
    	{
    		if(root.key==key)	// 루트노드가 삭제하고자 하는 값인 경우
    		{
    			root=null;
    			return;
    		}
    		else
    		{
    			return;
    		}
    	}
    	
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	Node temp = null, keyNode = null;
    	
    	// 레벨 순회 수행
    	// 삭제할 노드와 가장 오른쪽에 있는 노드를 탐색
    	// 삭제할 노드는 keyNode에 저장, 가장 오른쪽에 있는 노드는 temp에 저장됨
    	while(!q.isEmpty())
    	{
    		temp = q.remove();
    		
    		if(temp.key==key)
    		{
    			keyNode = temp;
    		}
    		
    		if(temp.left!=null)
    		{
    			q.add(temp.left);
    		}
    		if(temp.right!=null)
    		{
    			q.add(temp.right);
    		}
    	}
    	
    	if(keyNode != null)	// 삭제하고자 하는 노드를 찾은 경우
    	{
    		int x = temp.key;	// 가장 깊고 오른쪽에 존재하는 노드가 있음
    		deleteDeepest(temp);
    		keyNode.key = x;
    	}
    	
    }

}