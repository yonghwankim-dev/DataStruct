package Queue.Implement;


import org.junit.Test;

public class QueueTest {

	@Test
	void testQueue() {
		System.out.println("testQueue");
		Queue queue = new Queue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		
		System.out.println(queue.dequeue()
						+ " dequeued from queue\n");	// Expected Output : 10

		System.out.println("Front item is "
						+ queue.front());				// Expected Output : 20

		System.out.println("Rear item is "
						+ queue.rear());				// Expected Output : 40

		System.out.println("----------------------------------------------\n");
	}

}
