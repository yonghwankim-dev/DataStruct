package Queue.practice.set2;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.deQueue();
		
		System.out.println("Queue Front : " + queue.front.data);	// 40
		System.out.println("Queue Rear : " + queue.rear.data);		// 50
	}

}
