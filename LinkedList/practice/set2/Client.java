package LinkedList.practice.set2;

public class Client {
    /* Driver program to test above functions. Ideally this function
    should be in a separate user class.  It is kept here to keep
    code compact */
	public static void ex1()
	{
		/* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
 
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
 
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
 
        System.out.print("Created Linked list is: ");
        llist.printList();
	}
	public static void main(String[] args) {
		
		ex1();
	}

}
