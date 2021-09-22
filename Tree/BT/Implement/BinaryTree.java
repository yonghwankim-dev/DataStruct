package Tree.BT.Implement;

class Node
{
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
 
// ����Ʈ���� �Ұ��ϱ� ���� ����
class BinaryTree
{
    Node root;	// ��Ʈ ���
 
    // ������
    BinaryTree(int key)
    {
        root = new Node(key);
    }
 
 	// ����ִ� Ʈ��
    BinaryTree()
    {
        root = null;
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        // ��Ʈ ��� ����
        tree.root = new Node(1);
 
        /* ���� ��ɹ� ���� �Ʒ��� ���� Ʈ�� ����
 
              1
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 1�� �ڽĳ��� 2, 3 ��� ����
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
 
 
        tree.root.left.left = new Node(4);
        /* 4�� 2�� ���� �ڽ� ��尡 �ȴ�.
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}