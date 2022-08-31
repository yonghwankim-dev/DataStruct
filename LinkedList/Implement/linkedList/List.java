package LinkedList.Implement.linkedList;

interface List<E> {
	void addFirst(E obj);
	void addLast(E obj);
	E removeFirst();
	E removeLast();
	E remove(E obj);
	boolean contains(E obj);
	boolean isEmpty();
	E peekFirst();
	E peekLast();
}
