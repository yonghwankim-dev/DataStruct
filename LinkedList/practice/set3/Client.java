package LinkedList.practice.set3;

public class Client {
    /* Driver program to test above functions. Ideally this
    function should be in a separate user class. It is kept
    here to keep code compact */
	public static void ex1()
	{
        LinkedList llist = new LinkedList();
        
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("\nCreated Linked list is:");
        llist.printList(); // 2 3 1 7
 
        llist.deleteNode(1); // Delete node with data 1
 
        System.out.println(
            "\nLinked List after Deletion of 1:"); // 2 3 7
        llist.printList();
	}
	public static void main(String[] args) {
		
		ex1();
	}

}
