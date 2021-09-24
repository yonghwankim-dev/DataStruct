package Tree.BT.Implement;


import org.junit.jupiter.api.Test;
import Tree.BT.Implement.BinaryTree.Node;

class BinaryTreeTest {

	// 이진트리 생성 테스트
	@Test
	void createTest() {
		BinaryTree tree = new BinaryTree();
		 
        // 루트 노드 생성
        tree.root = new Node(1);
 
        /* 위의 명령문 이후 아래와 같이 트리 생성
 
              1
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 1의 자식노드로 2, 3 노드 생성
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
 
 
        tree.root.left.left = new Node(4);
        /* 4는 2의 왼쪽 자식 노드가 된다.
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
        System.out.print("이진 트리 초기 설정 : ");
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
		
		System.out.print("삽입이전 중위 순회 : ");
		bt.inorderTraversal();	// Expected Output : 9 11 15 10 8 7
		
		int key = 12;
		bt.insert(key);
		
		System.out.print("삽입이후 중위 순회 : ");
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
		
		System.out.print("삭제 이전 중위 순회 : ");
		bt.inorderTraversal();
		
		int key = 11;
		bt.delete(key);
		
		System.out.print("삭제 이후 중위 순회 : ");
		bt.inorderTraversal();
	}

}
