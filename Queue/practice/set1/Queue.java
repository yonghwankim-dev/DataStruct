package Queue.practice.set1;

// �迭 ��� ť ����
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
	
	// size�� capacity�� ���� ��� Queue�� full�̴�.
	boolean isFull(Queue queue)
	{
		return (queue.size == queue.capacity);
	}
	
	// size==0 �϶� Queue�� ����ִ�.
	boolean isEmpty(Queue queue)
	{
		return (queue.size==0);
	}
	
	// queue�� item �߰��ϴ� �޼���
	// rear�� size�� ����ȴ�.
	void enqueue(int item)
	{
		if(isFull(this))
		{
			return;
		}
		this.rear = (this.rear + 1) % this.capacity;	// rear�� capacity�� �����Ҷ� rear�� 0�̴�.
		this.array[this.rear] = item;	// queue�� rear��ġ�� item �߰�
		this.size = this.size + 1;	// ������ �߰�
		System.out.println(item + " enqueued to queue");
	}
	
	// queue�� item �����ϴ� �޼���
	// front�� size�� ���ܿ����.
	int dequeue()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		
		int item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;	// front�� capacity�� �����Ҷ� 0�� �ȴ�.
		this.size = this.size - 1;
		return item;
	}
	
	// queue�� ���Ͼտ� �ִ� item�� ��ȯ�Ѵ�. ��, ���ŵ����� �ʴ´�.
	int front()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		return this.array[this.front];
	}
	
	// queue�� ���� �ڿ� �ִ� item�� ��ȯ�Ѵ�. ��, ���ŵ����� �ʴ´�.
	int rear()
	{
		if(isEmpty(this))
		{
			return Integer.MIN_VALUE;
		}
		return this.array[this.rear];
	}
}
