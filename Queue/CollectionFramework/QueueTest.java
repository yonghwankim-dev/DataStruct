package Queue.CollectionFramework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void createQueueTest() {
		System.out.println("createQueueTest");
		
		Queue<Integer> q
        = new LinkedList<>();

	    // {0, 1, 2, 3, 4} 데이터를 queue에 추가
	    for (int i = 0; i < 5; i++)
	        q.add(i);
	
	    // 큐의 상태 출력
	    System.out.println("Elements of queue "
	                       + q);	// Expected Output : [0, 1, 2, 3, 4]
	
	    // Queue의 제일 앞쪽 데이터 제거
	    int removedele = q.remove();
	    System.out.println("removed element-"
	                       + removedele);	// Expected Output : 0
	
	    System.out.println(q);	// Expected Output : [1, 2, 3, 4]
	
	    // Queue의 제일 앞쪽 데이터 확인
	    int head = q.peek();
	    System.out.println("head of queue-"
	                       + head);	// Expected Output : 1
	
		// Queue의 사이즈 확인
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
		// PriorityQueue 객체 생성
        Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
  
        // 데이터 추가
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // PriorityQueue의 제일 일순위 요소를 출력한다.
        System.out.println(pQueue.peek());	// Expected Output : 10
  
        // PriorityQueue의 제일 일순위 요소를 제거하고 반환한다.
        System.out.println(pQueue.poll());	// Expected Output : 10
  
        // PriorityQueue의 다시 일순위 요소를 출력한다.
        System.out.println(pQueue.peek());	// Expected Output : 15
		System.out.println("----------------------------------------------\n");
	}
	
	@Test
	void linkedListClassTest()
	{
		System.out.println("linkedListClassTest");
		// LinkedList 기반 큐 객체 생성
        Queue<Integer> ll
            = new LinkedList<Integer>();
  
        ll.add(10);
        ll.add(20);
        ll.add(15);
  
		// 큐의 제일 앞에 있는 값을 출력한다.
        System.out.println(ll.peek());	// Expected Output : 10
  
        // 큐의 제일 앞에 있는 값을 제거하고 반환한다.
        System.out.println(ll.poll());	// Expected Output : 10
  
        // 다시 큐의 제일 앞에 있는 값을 출력한다.
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
	
		// queue의 front 값 출력
	    System.out.println(pbq.peek());	// Expected Output : 10
	
	    // queue의 front 값 제거 및 반환
	    System.out.println(pbq.poll());	// Expected Output : 10
	
	    // 제거 후 queue의 front값 출력
	    System.out.println(pbq.peek());	// Expected Output : 15
		System.out.println("----------------------------------------------\n");
	}

}
