package LinkedList.Implement.doubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DoubleLinkedList<E> implements List<E> {
	class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		public Node(E data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	class IteratorHelper implements Iterator<E>{
		Node<E> index;
			
		public IteratorHelper() {
			index = head;
		}

		@Override
		public boolean hasNext() {
			return (index!=null);
		}

		@Override
		public E next() {
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			E val = index.data;
			index = index.next;
			return val;
		}
		
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int currentSize;
	
	public DoubleLinkedList(){
		head = null;
		tail = null;
		currentSize = 0;
	}
	
	@Override
	public void addFirst(E data) {
		Node<E> newNode = new Node<E>(data);

		if(head == null)
		{
			tail = newNode;
		}
		else
		{
			head.prev = newNode;
		}
		
		newNode.next = head;
		head = newNode;
		currentSize++;
	}
	
	@Override
	public void addLast(E data) {
		
		Node<E> newNode = new Node<E>(data);

		if(head==null)
		{
			head = tail = newNode;
			currentSize++;
			return;
		}
		else
		{
			newNode.prev = tail;
		}
		
		tail.next = newNode;		
		tail = newNode;
		
		currentSize++;
	}
	
	@Override
	public E removeFirst() {
		if(head==null)
		{
			return null;
		}
		
		E delData = head.data;

		if(head==tail)
		{
			head = tail = null;
		}
		else
		{
			head = head.next;
			head.prev = null;
		}
		
		currentSize--;
		
		return delData;
	}
	
	@Override
	public E removeLast() {
		if(head==null)
		{
			return null;
		}

		if(head==tail)
		{
			return removeFirst();
		}
		
		E delVal = tail.data;
		tail.prev.next = null;
		tail = tail.prev;
		
		currentSize--;
		
		return delVal;
		
	}
	
	@Override
	public E remove(E obj) {
		Node<E> current=head, previous=null;

		while(current!=null)
		{
			if(((Comparable<E>)obj).compareTo(current.data)==0) // find
			{
				if(current==head)
				{
					return removeFirst();
				}

				if(current==tail)
				{
					return removeLast();
				}
				
				previous.next = current.next;	// remove
				current.next.prev = previous;
				
				currentSize--;
				return current.data;
			}

			previous = current;
			current = current.next;
		}
	
		return null;
	}
	
	@Override
	public boolean contains(E obj)
	{
		Node<E> current=head;
		

		while(current!=null)
		{
			if(((Comparable<E>)obj).compareTo(current.data)==0)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	@Override
	public E peekFirst() {
		if(head==null)
		{
			return null;
		}
		return head.data;
	}
	
	@Override
	public E peekLast() {
		if(tail==null)
		{
			return null;
		}
		return tail.data;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> cur = head;
		
		while(cur!=null)
		{
			sb.append(cur.data + " ");
			cur=cur.next;
		}
		sb.append("\n");
		
		return sb.toString().trim();
	}

	public Iterator<E> iterator(){
		return new IteratorHelper();
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}
}
