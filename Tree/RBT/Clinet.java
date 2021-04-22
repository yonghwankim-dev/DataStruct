package Tree.RBT;



public class Clinet {

	public static void main(String[] args) {
		RBTree tree = new RBTree();
		
		tree.insert(7);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		
        
		System.out.println("Inorder Traversal of Created Tree");
		tree.inorder();
		
		System.out.println("Level Order Traversal of Created Tree");
		tree.levelorder();
		
	}

}
