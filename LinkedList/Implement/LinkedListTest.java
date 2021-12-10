package LinkedList.Implement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void addFirstTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		System.out.println(list);	// Expected Output : C B A
	}
	
	@Test
	void removeFirstTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		System.out.println(list.removeFirst());	// Expected Output : C
	}
	
	@Test
	void removeLastTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		System.out.println(list.removeLast());	// Expected Output : A
	}
	
	@Test
	void removeTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		System.out.println(list.remove("B"));	// Expected Output : B
		System.out.println(list);				// Expected Output : C A
	}
	
	@Test
	void containsTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		System.out.println(list.contains("B"));	// Expected Output : true
	}

}
