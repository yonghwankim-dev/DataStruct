package LinkedList.Implement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test 
	void pushTest(){
		/* Start with the empty list */
		LinkedList list = new LinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		
		list.printList();	// Expected Output : [3,2,1]
	}
	
	@Test
	void insertTest() {
		/* Start with the empty list */
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		
		
		
		System.out.println("연결리스트 insert 메서드 예제");
		System.out.println("before 연결리스트 : ");
	    list.printList();	// Expected Output : [1,2,3]
	    
	    list.insert(0, 4);	// Expected Output : [4,1,2,3]
	    //list.insert(list.size(), 4);	// Expected Output : [1,2,3,4]
	    //list.insert(1, 4);		// Expeted Output : [1,4,2,3]
	    //list.insert(-1, 4);	// Expected Output : Error, IndexOutOfBoundsException
	    //list.insert(4, 4);	// Expected Output : Error, IndexOutOfBoundsException
	    list.printList();
	    System.out.println("---------------------------------------\n\n");
	}
	
	@Test
	void appendTest() {
		/* Start with the empty list */
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		
		list.printList();	// Expected Output : [1,2,3]	
	}
	
	@Test
	void deleteTest() {
		LinkedList list = new LinkedList();
		 
        list.push(7);
        list.push(1);
        list.push(3);
        list.push(2);
 
        System.out.println("before Linked List :");
        list.printList();	// Expected Output : [2,3,1,7]
 
        list.deleteKeyNode(1); // 값이 1인 노드 삭제
 
        System.out.println("\nafter Linked List :");
        list.printList(); // Expected Output : [2,3,7]
	}
	
	@Test
	void deletePositionTest() {
		LinkedList list = new LinkedList();
		 
		list.push(7);
		list.push(1);
		list.push(3);
		list.push(2);
		list.push(8);
        

        System.out.println("before Linked List :");
        list.printList();	// Expected Output : [8,2,3,1,7]
 
        list.deletePositionNode(4); // 4번째 노드 삭제 요청
 
        System.out.println("\nafter Linked List : ");
        list.printList(); // Expected Output : [8,2,3,1]
	}
}
