package Queue.Implement;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueAsLinkedListTest {
	// enqueue, dequeue, isempty, front, rear
	
	private QueueAsLinkedList queue;
	
	@Before
	void setup() {
		queue = new QueueAsLinkedList();
	}
	
	void setupEnqueue() {
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
	}
	
	@Test
	void enqueueTest() {
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		Assert.assertEquals("10 20 30", queue.toString());
	}
	
	@Test
	void dequeueTest() {
		setupEnqueue();
		
		Assert.assertEquals(10, queue.dequeue());
		Assert.assertEquals(20, queue.dequeue());
		Assert.assertEquals(30, queue.dequeue());
		Assert.assertEquals(Integer.MIN_VALUE, queue.dequeue());
	}
	
	@Test
	void isEmptyTest() {
		Assert.assertEquals(true, queue.isEmpty());
	}
	
	@Test
	void frontTest() {
		setupEnqueue();
		
		Assert.assertEquals(10, queue.front());
	}
	
	@Test
	void rearTest() {
		setupEnqueue();		
		Assert.assertEquals(30, queue.rear());
	}

}
