package LinkedList.Implement.dll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {

	@Test
	void addFirstTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		System.out.println(list);	// Expected Output : C B A
	}
	
	@Test
	void addLastTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		System.out.println(list);	// Expected Output : A B C	
	}
	
	@Test
	void removeFirstTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		System.out.print(list.removeFirst());
		System.out.print(list.removeFirst());
		System.out.print(list.removeFirst()+"\n");
	}
	
	@Test
	void removeLastTest() {
		DoubleLinkedList<String> list = new DoubleLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		System.out.print(list.removeLast());
		System.out.print(list.removeLast());
		System.out.print(list.removeLast()+"\n");
	}
	

}
