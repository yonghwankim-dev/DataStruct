package Tree.BT.Implement;



import Tree.BT.Implement.BinaryTree.Node;
import org.junit.Test;

class BinaryTreeTest {

	// ����Ʈ�� ���� �׽�Ʈ
	@Test
	void createTest() {
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
        System.out.print("���� Ʈ�� �ʱ� ���� : ");
        tree.inorderTraversal(); // Expected Output : 4 2 1 3
	}
	
	@Test
	void insertTest() {
		BinaryTree bt = new BinaryTree();
		
		bt.insert(10);
		bt.insert(11);
		bt.insert(7);
		bt.insert(9);
		bt.insert(15);
		bt.insert(8);
		
		System.out.print("�������� ���� ��ȸ : ");
		bt.inorderTraversal();	// Expected Output : 9 11 15 10 8 7
		
		int key = 12;
		bt.insert(key);
		
		System.out.print("�������� ���� ��ȸ : ");
		bt.inorderTraversal();	// Expected Output : 9 11 15 10 8 7 12
	}
	
	@Test
	void deleteTest()
	{
		BinaryTree bt = new BinaryTree();
		bt.insert(10);
		bt.insert(11);
		bt.insert(7);
		bt.insert(9);
		bt.insert(15);
		bt.insert(8);
		bt.insert(12);
		
		System.out.print("���� ���� ���� ��ȸ : ");
		bt.inorderTraversal();
		
		int key = 11;
		bt.delete(key);
		
		System.out.print("���� ���� ���� ��ȸ : ");
		bt.inorderTraversal();
	}

}
