package Queue.practice.set3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// Adds elements {0,1,2,3,4} to the queue
		for(int i=0;i<5;i++)
		{
			q.add(i);
		}
		
		// Display contents of the queue
		System.out.println("Elements of queue " + q); // Elements of queue [0, 1, 2, 3, 4]

		// To remove the head of queue
		int removedele = q.remove();
		System.out.println("removed element-" + removedele); // removed element-0
		
		System.out.println(q); // [1, 2, 3, 4]
		
		// To view the head of queue
		int head = q.peek();
		System.out.println("head of queue-"+head); // head of queue-1
		
		// Rest all methods of collection
		// interface like size and contains can be used with this implementation
		int size = q.size();
		System.out.println("Size of queue-"+size); // Size of queue-4

		
		
		
		
		
	}

}
