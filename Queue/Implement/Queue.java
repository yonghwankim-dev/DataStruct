package Queue.Implement;

//배열기반 큐 구현 실습
public class Queue {
	int front, rear, size;
	int capacity;
	int array[];

	public Queue(int capacity)
	{
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1;
		array = new int[this.capacity];
	}

	// 큐가 가득찼는지 검사
	boolean isFull(Queue queue)
	{
		return (queue.size == queue.capacity);
	}

	// 큐가 비어있는지 검사
	boolean isEmpty(Queue queue)
	{
		return (queue.size == 0);
	}

	// 큐에 데이터를 삽입 (rear와 size 값이 변경됨)
	void enqueue(int item)
	{
		if (isFull(this))
			return;
		this.rear = (this.rear + 1)
					% this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item
						+ " enqueued to queue");
	}

	// 큐에 데이터를 제거 및 반환(front와 size 값이 변경됨)
	int dequeue()
	{
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		int item = this.array[this.front];
		this.front = (this.front + 1)
					% this.capacity;
		this.size = this.size - 1;
		return item;
	}

	// 큐의 제일 앞쪽 데이터 반환
	int front()
	{
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.front];
	}

	// 큐의 제일 뒤쪽 데이터 반환
	int rear()
	{
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.rear];
	}
}