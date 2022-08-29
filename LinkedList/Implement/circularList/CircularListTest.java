package LinkedList.Implement.circularList;

import org.junit.Test;



public class CircularListTest {

	@Test
	void pushTest() {
		CircularList<Integer> list = new CircularList<Integer>();
		
		list.push(12);
		list.push(56);
		list.push(2);
		list.push(11);
		
		list.printList();
	}
	
	@Test
	void removeTest() {
		CircularList<Integer> list = new CircularList<Integer>();
		
		list.push(12);
		list.push(56);
		list.push(2);
		list.push(11);
	
		// 11 -> 2 -> 56 -> 12, before
		// 2 -> 56 -> 12 after
		list.remove(11);	// 제일 앞의 노드 제거
		list.printList();

		// 2 -> 56 -> 12, before
		// 2 -> 56, after
		list.remove(12);	// 마지막 노드 제거
		list.printList();
		
		// 10 -> 2 -> 56, before
		// 10 -> 56, after
		list.push(10);
		list.remove(2);		// 중간 노드 제거
		list.printList();
	}
	
	@Test
	void sizeTest() {
		CircularList<Integer> list = new CircularList<Integer>();
		
		list.push(12);
		list.push(56);
		list.push(2);
		list.push(11);
		
		System.out.println(list.size());
	}

}
