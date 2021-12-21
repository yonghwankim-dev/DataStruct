package Tree.BST.Implement.geeks;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.event.TreeExpansionEvent;

import org.junit.jupiter.api.Test;

import Tree.BST.Implement.geeks.BinarySearchTree.Node;



class BinarySearchTreeTest {

	@Test
	void insertTest() {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();	// Expected output : 20 30 40 50 60 70 80
	}
	
	@Test
	void inorderSuccessorTest() {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);

		Node temp = tree.root.left.right.right;	// 14
		System.out.println(tree.inorderSuccessor(temp).key);	// Expected Output : 20
	}
	
	@Test
	void deleteTest() {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		System.out.println("Inorder traversal of the given tree");
		tree.inorder();
		
		System.out.println("Delete 20");
		tree.delete(20);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();	// Expected Output : 30 40 50 60 70 80
		
		System.out.println("Delete 30");
		tree.delete(30);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();	// 40 50 60 70 80
		
		System.out.println("Delete 50");
		tree.delete(50);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder(); // 40 60 70 80
	}

}
