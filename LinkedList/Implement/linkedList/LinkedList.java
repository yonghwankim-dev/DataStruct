package LinkedList.Implement.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<E> implements List<E> {
	class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}	
	}
	
	class IteratorHelper implements Iterator<E>{
		Node<E> index;
			
		public IteratorHelper() {
			index = head;
		}

		// 임시 포인터(index)가 null을 가리키는지 여부 확인
		@Override
		public boolean hasNext() {
			return (index!=null);
		}

		// index가 가리키는 노드의 데이터값을 반환 및 노드 이동
		@Override
		public E next() {
			if(!hasNext()) {
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
	
	public LinkedList(){
		head = null;
		tail = null;
		currentSize = 0;
	}
	
	@Override
	public void addFirst(E data) {
		Node<E> newNode = new Node<>(data);
		
		// 1. 경계조건, 자료구조가 비어있는 경우
		if(head == null)
		{
			tail = newNode;
		}
		
		newNode.next = head;
		head = newNode;		
		currentSize++;
	}
	
	@Override
	public void addLast(E data) {
		Node<E> newNode = new Node<>(data);
		// 1. 경계조건, 자료구조가 비어있는 경우
		if(head == null)
		{
			head = tail = newNode;
			currentSize++;
			return;
		}
		
		tail.next = newNode;		
		tail = newNode;
		currentSize++;
	}
	
	@Override
	public E removeFirst() {
		// 경계조건 1. Empty, 자료구조가 비어있는 경우
		if(isEmpty()) {
			return null;
		}
		
		E delData = head.data;
		
		// 경계조건 2. Single Element, 삭제할 노드가 단 하나남은 노드인 경우 
		// head, tail은 null을 가리키도록 함
		if(head == tail) {
			head = tail = null;
			currentSize--;
			return delData;
		}

		head = head.next;
		currentSize--;
		return delData;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public E removeLast() {
		// 경계조건 1. Empty, 자료구조가 비어있는 경우
		if(isEmpty()) {
			return null;
		}

		// 경계조건 2. Single Element, 자료구조에서 요소가 하나 있는 경우
		if(head == tail)
		{
			return removeFirst();
		}
		
		Node<E> current = head;
		Node<E> previous = null;
		
		while(current!=tail)
		{
			previous = current;
			current = current.next;		 
		}
		
		previous.next = null;
		tail = previous;
		
		currentSize--;
		
		return current.data;
		
	}
	
	@Override
	public E remove(E obj) {
		Node<E> current=head, previous=null;
		
		// 경계 조건 Empty 포함
		while(current!=null)
		{
			if(((Comparable<E>)obj).compareTo(current.data)==0) // find
			{
				// 경계조건 Single Element, Beginning
				// 노드가 1개 or 첫번째 노드 제거
				if(current==head)
				{
					return removeFirst();
				}
				// 경계조건 End
				// 마지막 노드 제거
				if(current==tail)
				{
					return removeLast();
				}
				previous.next = current.next;	// remove
				currentSize--;
				return current.data;
			}
			// 찾고자 하는 요소가 아닌 경우
			previous = current;
			current = current.next;
		}
	
		return null;
	}
	
	@Override
	public boolean contains(E obj)
	{
		Node<E> current = head;
		
		// 경계 조건 Empty 포함
		while(current!=null)
		{
			// 찾고자 하는 요소인 경우
			if(((Comparable<E>)obj).compareTo(current.data)==0)
			{
				return true;
			}
			// 찾고자 하는 요소가 아닌 경우
			current = current.next;
		}
		
		// 요소가 포함되지 않은 경우
		return false;
	}
	
	@Override
	public E peekFirst() {
		if(isEmpty())
		{
			return null;
		}
		return head.data;
	}
	
	@Override
	public E peekLast() {
		if(tail == null)
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
	
	// Iterator 인터페이스를 구현하는 클래스를 만드는 메서드
	public Iterator<E> iterator(){
		return new IteratorHelper();
	}
	
	
}
