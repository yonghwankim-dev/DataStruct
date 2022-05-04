package LinkedList.Implement.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListI<E>{
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

		// �ӽ� ������(index)�� null�� ����Ű���� ���� Ȯ��
		@Override
		public boolean hasNext() {
			return (index!=null);
		}

		// index�� ����Ű�� ����� �����Ͱ��� ��ȯ �� ��� �̵�
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
	
	public LinkedList(){
		head = null;
		tail = null;
		currentSize = 0;
	}
	
	@Override
	public void addFirst(E data) {
		Node<E> newNode = new Node<E>(data);
		
		// 1. �������, �ڷᱸ���� ����ִ� ���
		if(head==null)
		{
			tail = newNode;
		}
		
		newNode.next = head;
		head = newNode;		
		currentSize++;
	}
	
	@Override
	public void addLast(E data) {
		
		Node<E> newNode = new Node<E>(data);
		// 1. �������, �ڷᱸ���� ����ִ� ���
		if(head==null)
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
		// ������� 1. Empty, �ڷᱸ���� ����ִ� ���
		if(head==null)
		{
			return null;
		}
		
		E delData = head.data;
		
		// ������� 2. Single Element, ������ ��尡 �� �ϳ����� ����� ��� 
		// head, tail�� null�� ����Ű���� ��
		if(head==tail)
		{
			head = tail = null;
		}
		else
		{
			head = head.next;
		}
		
		currentSize--;
		
		return delData;
	}
	
	@Override
	public E removeLast() {
		// ������� 1. Empty, �ڷᱸ���� ����ִ� ���
		if(head==null)
		{
			return null;
		}
		
		// ������� 2. Single Element, �ڷᱸ������ ��Ұ� �ϳ� �ִ� ���
		if(head==tail)
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
		
		// ��� ���� Empty ����
		while(current!=null)
		{
			if(((Comparable<E>)obj).compareTo(current.data)==0) // find
			{
				// ������� Single Element, Beginning
				// ��尡 1�� or ù��° ��� ����
				if(current==head)
				{
					return removeFirst();
				}
				// ������� End
				// ������ ��� ����
				if(current==tail)
				{
					return removeLast();
				}
				previous.next = current.next;	// remove
				currentSize--;
				return current.data;
			}
			// ã���� �ϴ� ��Ұ� �ƴ� ���
			previous = current;
			current = current.next;
		}
	
		return null;
	}
	
	@Override
	public boolean contains(E obj)
	{
		Node<E> current=head;
		
		// ��� ���� Empty ����
		while(current!=null)
		{
			// ã���� �ϴ� ����� ���
			if(((Comparable<E>)obj).compareTo(current.data)==0)
			{
				return true;
			}
			// ã���� �ϴ� ��Ұ� �ƴ� ���
			current = current.next;
		}
		
		// ��Ұ� ���Ե��� ���� ���
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
	
	// Iterator �������̽��� �����ϴ� Ŭ������ ����� �޼���
	public Iterator<E> iterator(){
		return new IteratorHelper();
	}
	
	
}
