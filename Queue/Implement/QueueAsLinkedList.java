package Queue.Implement;

class QueueAsLinkedList<E> {
	Node head, tail;
	int size;
	
	private static class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public QueueAsLinkedList()
	{
		head = tail = null;
		size = 0;
	}

	public void enqueue(E item)
	{
		Node newNode = new Node(item);

		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		tail.next = newNode;
		tail = newNode;
	}

	public E dequeue()
	{
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		
		E item = (E) head.data;

		if(size == 1) {
			head = tail = null;
			size--;
			return item;
		}
		head = head.next;
		size--;
		return item;
	}
	

	public boolean isEmpty()
	{
		return size == 0;
	}

	public E front()
	{
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return (E) head.data;
	}

	public E rear()
	{
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return (E) tail.data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		while(cur != null)
		{
			sb.append(cur.data+" ");
			cur = cur.next;
		}
		return sb.toString().trim();
	}
	
	
}
