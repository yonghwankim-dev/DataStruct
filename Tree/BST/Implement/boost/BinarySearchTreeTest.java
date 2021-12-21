package Tree.BST.Implement.boost;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void addTest() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		
		bst.inorderTraversal();
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

}
