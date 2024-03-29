package Heap.Implement;


import org.junit.Test;

class MinHeapTest {

	@Test
	void minHeapAddTest() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		
		heap.printHeap(); // Expected Output : 1 2 4 5 3
	}
	
	@Test
	void minHeapRemoveTest() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		
		// Expected Output : 1 2 3 4 5
		System.out.print(heap.remove() + " ");	 
		System.out.print(heap.remove() + " ");
		System.out.print(heap.remove() + " ");
		System.out.print(heap.remove() + " ");
		System.out.print(heap.remove() + " ");
		System.out.println();
	}

	@Test
	void minHeapSetTest() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		
		heap.add(50);
		heap.add(40);
		heap.add(30);
		heap.add(20);
		heap.add(10);
	
		heap.printHeap(); // Expected Output : 10 20 40 50 30
		heap.set(3, 5);
		heap.printHeap(); // Expected Output : 5 10 40 20 30
		
	}
	
	@Test
	void minHeapSortTest() {
		MinHeap<Integer> heap = new MinHeap<Integer>(5);
		
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		
		heap.printHeap(); // Expected Output : 1 2 4 5 3
		
		heap.sort();	// 최소힙의 오름차순 정렬
		
		heap.printHeap(); // Expected Output : 1 2 3 4 5
			
	}
}
