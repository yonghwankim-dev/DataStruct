package Queue.practice.set3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;


public class GFG {
	
	// Java Program to add elements to a Queue
	public static void ex1()
	{
		Queue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("for");
		pq.add("Geeks");
		
		System.out.println(pq); // [Geeks, for, Geeks]
	}
	// Java Program to remove elements from a Queue
	public static void ex2()
	{
		Queue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("for");
		pq.add("Geeks");
		
		System.out.println("Initial Queue " + pq); // Initial Queue [Geeks, for, Geeks]
		
		pq.remove("Geeks");
		
		System.out.println("After Remove " + pq); // After Remove [Geeks, for]
		
		System.out.println("Poll Method " +  pq.poll()); // Poll Method Geeks
		
		System.out.println("Final Queue " + pq); // Final Queue [for]
	}

	// Java program to iterate elements to a Queue
	public static void ex3()
	{
		Queue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("for");
		pq.add("Geeks");
		
		Iterator iterator = pq.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " "); // Geeks for Geeks 
		}
	}
	
	// Java program to demonstrate the creation of queue object using
	// the PriorityQueue class
	public static void ex4()
	{
		// Creating empty priority queue
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		
		// Adding items to the pQueue using add()
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(15);
		
		// Printing the top element of the PriorityQueue
		System.out.println(pQueue.peek()); // 10
		
		// Printing the top element and removing it from the PriorityQueue container
		System.out.println(pQueue.poll());	// 10
		
		// Printing the top element again
		System.out.println(pQueue.peek()); // 15
	}
	
	// Java program to demonstrate the creation of queue object using the LinkedList class
	public static void ex5()
	{
		// Creating empty LinkedList
		Queue<Integer> ll = new LinkedList<Integer>();
		
		// Adding items to the ll using add()
		ll.add(10);
		ll.add(20);
		ll.add(15);
		
		// Printing the top element of the LinkedList
		System.out.println(ll.peek()); // 10
		
		// Printing the top element and removeing it from the LinkedList container
		System.out.println(ll.poll()); // 10
		
		// Printing the top element again
		System.out.println(ll.peek()); // 20

	}
	// Java program to demonstrate the creation of queue
	// object using the PriorityBlockingQueue class
	public static void ex6()
	{
		Queue<Integer> pbq = new PriorityBlockingQueue<Integer>();
		
		// Adding items to the pbq using add()
		pbq.add(10);
		pbq.add(20);
		pbq.add(15);
		
		// Printing the top lement of the PriorityBlockingQueue
		System.out.println(pbq.peek());	// 10
		
		// Printing the top element and removing it from the
		// PriorityBlockingQueue
		System.out.println(pbq.poll());	// 10
		
		// Printing the top element again
		System.out.println(pbq.peek()); // 15
	}
	
	
	public static void main(String[] args) {
//		ex1();
//		ex2();
//		ex3();
//		ex4();
//		ex5();
		ex6();
	}

}
