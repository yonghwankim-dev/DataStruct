package Queue.practice.set1;

// 배열 기반 큐 구현
public class Queue {
	int front, rear, size;
	int capacity;
	int array[];
	
	public Queue(int capacity)
	{
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity-1;
		array = new int[this.capacity];
	}
	
	// size가 capacity와 같을 경우 Queue는 full이다.
	boolean isFull(Queue queue)
	{
		return (queue.size == queue.capacity);
	}
	
	// size==0 일때 Queue는 비어있다.
	boolean isEmpty(Queue queue)
	{
		return (queue.size==0);
	}
	
	// queue에 item 추가하는 메서드
	// rear와 size가 변경된다.
	void enqueue(int item)
	{
		if(isFull(this))
		{
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;	// rear가 capacity와 동일할때 rear는 0이다.
		this.array[this.rear] = item;	// queue의 rear위치에 item 추가
		this.size = this.size + 1;	// 사이즈 추가
		System.out.println(item + " enqueued to queue");
	}
	
	// queue에 item 제거하는 메서드
	// front와 size가 변겨오딘다.
	int dequeue()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		
		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;	// front와 capacity와 동일할때 0이 된다.
		this.size = this.size - 1;
		return item;
	}
	
	// queue의 제일앞에 있는 item을 반환한다. 단, 제거되지는 않는다.
	int front()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		return this.array[this.front];
	}
	
	// queue의 제일 뒤에 있는 item을 반환한다. 단, 제거되지는 않는다.
	int rear()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		return this.array[this.rear];
	}
}
