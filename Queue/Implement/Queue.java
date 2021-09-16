package Queue.Implement;

//�迭��� ť ���� �ǽ�
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

 // ť�� ����á���� �˻�
	boolean isFull(Queue queue)
	{
		return (queue.size == queue.capacity);
	}

 // ť�� ����ִ��� �˻�
	boolean isEmpty(Queue queue)
	{
		return (queue.size == 0);
	}

 // ť�� �����͸� ���� (rear�� size ���� �����)
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

 // ť�� �����͸� ���� �� ��ȯ(front�� size ���� �����)
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

 // ť�� ���� ���� ������ ��ȯ
	int front()
	{
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.front];
	}

 // ť�� ���� ���� ������ ��ȯ
	int rear()
	{
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.array[this.rear];
	}
}