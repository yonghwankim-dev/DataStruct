package LinkedList.Implement.linkedList;



import org.junit.Test;

import java.util.Iterator;

public class LinkedListTest {

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
	
	@Test
	void peekFirstTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		System.out.println(list.peekFirst());	// Expected Output : C
	}
	
	@Test
	void peekLastTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		System.out.println(list.peekLast());	// Expected Output : A
	}
	
	@Test
	void iteratorTest() {
		LinkedList<String> list = new LinkedList<String>();
		
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		
		Iterator<String> itor = list.iterator(); 
		while(itor.hasNext())
		{
			System.out.print(itor.next()+" ");	// Expected Output : C B A
		}
	}

}
