package LinkedList.Implement.circularList;

interface List<E> {
	class Node<E>{
		E data;
		Node<E> next;
		
		public Node() {
			this(null);
		}
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}	
	}

	void addFirst(E obj);
	void addLast(E obj);
	E removeFirst();
	E removeLast();
	E remove(E obj);
	boolean contains(E obj);
	E peekFirst();
	E peekLast();
	boolean isEmpty();
	int size();
	
	
}
