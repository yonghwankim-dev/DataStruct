package Heap.Implement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MinHeapTest {

	@Test
	void minHeapTest() {
		MinHeap heap = new MinHeap(11);
		
		heap.insertKey(3);
		heap.insertKey(2);
		heap.deleteKey(1);	// value 3 Á¦°Å
		heap.insertKey(15);
		heap.insertKey(5);
		heap.insertKey(4);
		heap.insertKey(45);
		
		System.out.println(heap.extractMin()); // Expected Output : 2
		System.out.println(heap.getMin());	// Expected Output : 4 
		heap.decreaseKey(2, 1);				
		System.out.println(heap.getMin());	// Expected Output : 1
		System.out.println(heap);
		
	}

}
