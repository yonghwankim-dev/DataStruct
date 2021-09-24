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
    
    // ���� ��� �����ʿ� ��ġ�� ��带 ����
    public void deleteDeepest(Node delNode)
    {
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	
    	Node temp = null;
    	
    	// ������ �ڽ� ��常�� ��� �����ϸ鼭 delNode�� Ž���ϰ� ����
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
    
    // �־��� key���� ����Ʈ������ Ž���Ͽ� ����
    public void delete(int key)
    {
    	// ���� Ʈ���� ����ִ� ���
    	if(root==null)
    	{
    		return;
    	}
    	
    	// ����Ʈ���� ��尡 1���� ���
    	if(root.left==null && root.right==null)
    	{
    		if(root.key==key)	// ��Ʈ��尡 �����ϰ��� �ϴ� ���� ���
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
    	
    	// ���� ��ȸ ����
    	// ������ ���� ���� �����ʿ� �ִ� ��带 Ž��
    	// ������ ���� keyNode�� ����, ���� �����ʿ� �ִ� ���� temp�� �����
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
    	
    	if(keyNode != null)	// �����ϰ��� �ϴ� ��带 ã�� ���
    	{
    		int x = temp.key;	// ���� ��� �����ʿ� �����ϴ� ��尡 ����
    		deleteDeepest(temp);
    		keyNode.key = x;
    	}
    	
    }

}