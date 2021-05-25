package LinkedList.practice.set1;

//A simple Java program to introduce a linked list
public class LinkedList {
	Node head;	// head of the list
	
	/*Linked List Node*/
	static class Node{
		int data;
		Node next;
		
	    /* Linked list Node.  This inner class is made static so that
	       main() can access it */
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	/*This function prints content of linked list starting from head*/
	public void printList()
	{
		Node n = head;
		while(n!=null)
		{
			System.out.println(n.data + " ");
			n = n.next;
		}
	}
}
