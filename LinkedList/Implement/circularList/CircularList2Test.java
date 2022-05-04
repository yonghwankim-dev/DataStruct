package LinkedList.Implement.circularList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import LinkedList.Implement.linkedList.LinkedList;

class CircularList2Test {

	@Test
	void pushTest() {
		CircularList2<Integer> list = new CircularList2<Integer>();
		
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		
		list.printList();
	}
	
	@Test
	void removeTest() {
		CircularList2<Integer> list = new CircularList2<Integer>();
		
		// 12 -> 56 -> 2 -> 11
		list.push(12);
		list.push(56);
		list.push(2);
		list.push(11);
	
		// 12 -> 56 -> 2 -> 11, before
		// 56 -> 2 -> 11 after
		list.remove(12);	// 제일 앞의 노드 제거
		list.printList();

		// 56 -> 2 -> 11, before
		// 56 -> 2, after
		list.remove(11);	// 제일 뒤 노드 제거
		list.printList();
		
		// 56 -> 2 -> 10, before
		// 56 -> 10, after
		list.push(10);
		list.remove(2);		// 중간 노드 제거
		list.printList();
	}
}
