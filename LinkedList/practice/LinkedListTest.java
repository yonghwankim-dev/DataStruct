package LinkedList.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void insertTest() {
		/* Start with the empty list */
	     LinkedList llist = new LinkedList();
	
	     // 6->Nullist
	     llist.append(6);
	
	     // 7->6->NUllist
	     llist.push(7);
	
	     // 1->7->6->NUllist
	     llist.push(1);
	
	     // 1->7->6->4->NUllist
	     llist.append(4);
	
	     // 1->7->8->6->4->NUllist
	     llist.insertAfter(llist.head.next, 8);
	
	     System.out.println("���Ḯ��Ʈ ���� ���� ����");
	     System.out.println("Created Linked list is: ");	
	     llist.printList();	// Expected Output : 1 7 8 6 4
	     System.out.println("---------------------------------------\n\n");
	}
	
	@Test
	void deleteTest() {
		LinkedList llist = new LinkedList();
		 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("���Ḯ��Ʈ ���� ���� ����");
        System.out.println("Created Linked list is:");
        llist.printList();	// Expected Output : 2 3 1 7
 
        llist.deleteNode(1); // ��� data�� 1 ����
 
        System.out.println(
            "\nLinked List after Deletion of 1:");
        llist.printList(); // Expected Output : 2 3 7
        System.out.println("\n---------------------------------------\n\n");
	}
	
	@Test
	void deletePositionTest() {
		LinkedList llist = new LinkedList();
		 
		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);
		llist.push(8);
        
        
        System.out.println("���Ḯ��Ʈ Position ���� ���� ����");
        System.out.println("Created Linked list is:");
        llist.printList();	// Expected Output : 8 2 3 1 7
 
        llist.deletePositionNode(4); // position 4 ��ġ ���� ��û
 
        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList(); // Expected Output : 8 2 3 1
        System.out.println("\n---------------------------------------\n\n");
	}

}
