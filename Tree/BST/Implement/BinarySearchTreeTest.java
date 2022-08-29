package Tree.BST.Implement;


import org.junit.Test;

class BinarySearchTreeTest {

	@Test
	void addTest() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(10);
		bst.add(8);
		bst.add(20);
		bst.add(17);
		bst.add(9);
		
		bst.inorderTraversal();	// Expected Output : 8 9 10 17 20
	}
	
	@Test
	void containsTest() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		
		System.out.println(bst.contains(5));
	}
	
	@Test
	void removeTest() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(10);
		bst.add(8);
		bst.add(20);
		bst.add(17);
		bst.add(9);
		
		bst.inorderTraversal();	// Expected Output : 8 9 10 17 20
		bst.remove(17);
		bst.inorderTraversal(); // Expected Output : 8 9 10 20
	}	

}
