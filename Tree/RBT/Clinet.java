package Tree.RBT;



public class Clinet {

	public static void main(String[] args) {
		RBTree tree = new RBTree();
		
		  tree.insert(7);
		  tree.insert(3);
		  tree.insert(18);
		  tree.insert(10);
		  tree.insert(22);
		  tree.insert(8);
		  tree.insert(11);
		  tree.insert(26);
		  tree.insert(2);
		  tree.insert(6);
		  tree.insert(13);
		
		tree.printIninorder();
		tree.printLevelOrder();
		
		System.out.println("Deleting 18, 11, 3, 10, 22");
		tree.deleteByVal(18);
		tree.deleteByVal(11);
		tree.deleteByVal(3);
		tree.deleteByVal(10);
		tree.deleteByVal(22);
		
		tree.printIninorder();
		tree.printLevelOrder();
	}

}
