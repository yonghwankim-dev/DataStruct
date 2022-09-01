package Queue.Implement;

class Queue<E> {
	int front, rear, size;
	int capacity;
	E[] arr;

	public Queue(){
		this(10);
	}

	public Queue(int capacity)
	{
		this.capacity = capacity;
		front = 0;
		rear = 0;
		size = 0;
		arr = (E[]) new Object[capacity];
	}

	public boolean isFull() {
		return size >= capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(E item)
	{
		if (isFull()) {
			reSize();
		}
		arr[rear] = item;
		rear = (rear + 1) % capacity;
		size++;
	}

	public E dequeue() {
		if (isEmpty()){
			throw new IllegalStateException();
		}
		E item = arr[front];
		front = (front + 1) % capacity;
		size--;
		return item;
	}

	public E front() {
		if (isEmpty()){
			throw new IllegalStateException();
		}
		return arr[front];
	}

	public E rear()
	{
		if(isEmpty()){
			throw new IllegalStateException();
		}
		return arr[rear];
	}


	private void reSize() {
		E[] dummy = (E[]) new Object[capacity*2];
		System.arraycopy(arr,0,dummy,0,capacity);
		this.capacity *= 2;
		arr = (E[]) new Object[this.capacity];
		System.arraycopy(dummy, 0, arr, 0, dummy.length);
	}
}