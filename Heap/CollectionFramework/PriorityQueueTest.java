package Heap.CollectionFramework;

import org.junit.Test;

import java.util.Iterator;
import java.util.PriorityQueue;

class PriorityQueueTest {

	@Test
	void test() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(10);
		pq.add(20);
		pq.add(15);
		
		
		System.out.println(pq.peek()); // Expected Output : 10
		
		System.out.println(pq.poll());	// Expected Output : 10
		
		System.out.println(pq.peek()); // Expected Output : 15
		
		
	}
	
	@Test
	void addTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		System.out.println(pq);	// Expected Output : [For, Geeks, Geeks]
	}
	
	@Test
	void removeTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		System.out.println("Initial PriorityQueue " + pq);	// Expected Output : [For, Geeks, Geeks]
		
		pq.remove("Geeks");
		
		System.out.println("After Remove - " + pq);	// Expected Output : [For, Geeks]
		
		System.out.println("Poll Method - " + pq.poll());	// Expected Output : For
		
		System.out.println("Final PriorityQueue - " + pq);	// Expected Output : [Geeks]
	}
	
	@Test
	void accessTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		System.out.println("PriorityQueue: " + pq);	// Expected Output : [For, Geeks, Geeks]
		
		
		System.out.println("Accessed Element: " + pq.peek());	// Expected Output : For
	}
	
	@Test
	void iterateTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		Iterator<String> iterator = pq.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");	// Expected Output : For Geeks Geeks
		}
	}
	

}
