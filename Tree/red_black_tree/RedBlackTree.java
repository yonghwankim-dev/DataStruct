package Tree.red_black_tree;

public class RedBlackTree<K, V> {
	Node<K,V> root;
	int size;
	
	private class Node<K,V>{
		K key;
		V value;
		Node<K,V> left, right, parent;
		boolean isLeftChild, black;
		
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
			left = right = parent = null;
			black = false;
			isLeftChild = false;
		}
	}
}
