package Tree.BT.Implement;

import java.util.LinkedList;
import java.util.Queue;

// ���� Ʈ�� ���� �� ���� ����

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
    
    // ����ִ� Ʈ��
    public BinaryTree()
    {
        root = null;
    }
    
    // ������
    public BinaryTree(int key)
    {
        root = new Node(key);
    }
    
    // ���� Ʈ���� ���� ��ȸ
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
    
    // ���� Ʈ�� �ߺ���ȸ ȣ��
    public void inorderTraversal()
    {
    	inorder(this.root);
    	System.out.println();
    }
    
    // ���� Ʈ���� key���� ���� �����Ͽ� ����
    public void insert(int key)
    {
    	if(root==null) 
    	{
    		root = new Node(key);
    		return;
    	}
    	
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	
    	// ����Ʈ���� ������� ã�������� level order ��ȸ ����
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