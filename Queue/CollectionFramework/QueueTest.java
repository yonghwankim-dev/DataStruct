package Queue.CollectionFramework;



import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueTest {

	@Test
	void createQueueTest() {
		System.out.println("createQueueTest");
		
		Queue<Integer> q
        = new LinkedList<>();

	    // {0, 1, 2, 3, 4} �����͸� queue�� �߰�
	    for (int i = 0; i < 5; i++)
	        q.add(i);
	
	    // ť�� ���� ���
	    System.out.println("Elements of queue "
	                       + q);	// Expected Output : [0, 1, 2, 3, 4]
	
	    // Queue�� ���� ���� ������ ����
	    int removedele = q.remove();
	    System.out.println("removed element-"
	                       + removedele);	// Expected Output : 0
	
	    System.out.println(q);	// Expected Output : [1, 2, 3, 4]
	
	    // Queue�� ���� ���� ������ Ȯ��
	    int head = q.peek();
	    System.out.println("head of queue-"
	                       + head);	// Expected Output : 1
	
		// Queue�� ������ Ȯ��
	    int size = q.size();
	    System.out.println("Size of queue-"
	                       + size);	// Expected Output : 4
	    
	    System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void addQueueTest()
	{
		System.out.println("addQueueTest");
		Queue<String> pq = new PriorityQueue<>();
		  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        System.out.println(pq);	// Expected Output : [For, Geeks, Geeks]
        System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void removeAndPollQueueTest()
	{
		System.out.println("removeAndPollQueueTest");
		Queue<String> pq = new PriorityQueue<>();
		  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        System.out.println("Initial Queue " + pq);	// Expected Output : [For, Geeks, Geeks]
  
        pq.remove("Geeks");
  
        System.out.println("After Remove " + pq);	// Expected Output : [For, Geeks]
  
        System.out.println("Poll Method " + pq.poll());	// Expected Output : For
  
        System.out.println("Final Queue " + pq); // Expected Output : [Geeks]
        System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void iteratorQueueTest()
	{
		System.out.println("iteratorQueueTest");
		Queue<String> pq = new PriorityQueue<>();
		  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        Iterator<String> iterator = pq.iterator();
  
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // Expected Output : For Geeks Geeks
        }
		System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void priorityQueueClassTest()
	{
		System.out.println("priorityQueueClassTest");
		// PriorityQueue ��ü ����
        Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
  
        // ������ �߰�
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // PriorityQueue�� ���� �ϼ��� ��Ҹ� ����Ѵ�.
        System.out.println(pQueue.peek());	// Expected Output : 10
  
        // PriorityQueue�� ���� �ϼ��� ��Ҹ� �����ϰ� ��ȯ�Ѵ�.
        System.out.println(pQueue.poll());	// Expected Output : 10
  
        // PriorityQueue�� �ٽ� �ϼ��� ��Ҹ� ����Ѵ�.
        System.out.println(pQueue.peek());	// Expected Output : 15
		System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void linkedListClassTest()
	{
		System.out.println("linkedListClassTest");
		// LinkedList ��� ť ��ü ����
        Queue<Integer> ll
            = new LinkedList<Integer>();
  
        ll.add(10);
        ll.add(20);
        ll.add(15);
  
		// ť�� ���� �տ� �ִ� ���� ����Ѵ�.
        System.out.println(ll.peek());	// Expected Output : 10
  
        // ť�� ���� �տ� �ִ� ���� �����ϰ� ��ȯ�Ѵ�.
        System.out.println(ll.poll());	// Expected Output : 10
  
        // �ٽ� ť�� ���� �տ� �ִ� ���� ����Ѵ�.
        System.out.println(ll.peek());	// Expected Output : 20
		System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void priorityBlockingQueueClassTest()
	{
		System.out.println("priorityBlockingQueueClassTest");
		Queue<Integer> pbq
        = new PriorityBlockingQueue<Integer>();

	    pbq.add(10);
	    pbq.add(20);
	    pbq.add(15);
	
		// queue�� front �� ���
	    System.out.println(pbq.peek());	// Expected Output : 10
	
	    // queue�� front �� ���� �� ��ȯ
	    System.out.println(pbq.poll());	// Expected Output : 10
	
	    // ���� �� queue�� front�� ���
	    System.out.println(pbq.peek());	// Expected Output : 15
		System.out.println("----------------------------------------------\n");
	}

}
