package Tree.avltree;


import org.junit.Test;

class AVLTreeTest {

	@Test
	void addTest() {
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		int[] inputs = {43,18,22,9,21,6,8,20,63,50,62,51};
		
		for(int i=0; i<inputs.length;i++)
		{
			System.out.print(inputs[i] + " add after : ");
			avlTree.add(inputs[i]);
			avlTree.inorderTraversal();
		}	
	}

}
