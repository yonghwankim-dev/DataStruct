### 1\. 큐(Queue) 데이터구조란 무엇인가?

스택(Stack) 데이터 구조와 비슷하게 큐(Queue) 구조는 FIFO(First In First Out) 순서로 데이터를 저장하는 선형 데이터 구조입니다. 큐의 좋은 예시로는 계산대에서 물건을 계산하기 위해서 한 줄로 줄을 서는 손님들이 좋은 예시입니다. 

스택과 큐의 차이점은 제거하는 방식이 차이가 존재합니다. 스택 구조같은 경우 가장 최근에 추가된 데이터가 제거되는 방식에 비해 큐 구조는 가장 빨리 추가된 데이터가 제거되는 방식입니다. 이것은 마치 먼저 음식을 주문한 손님이 먼저 음식을 받아가는 것과 마찬가지입니다.

### 2\. 큐의 연산

-   Enqueue : 큐에 데이터를 추가합니다. 만약 큐가 가득차있다면 추가되지 않습니다.
-   Dequeue : 큐에 데이터를 제거합니다. 제거되는 순서는 들어온 순서대로 제거됩니다. 만약 큐가 비어있다면 제거되지 않습니다.
-   Front : 큐의 제일 앞쪽의 데이터(제일 빨리 추가된 데이터)값을 가져와 반환합니다.
-   Rear : 큐의 제일 뒤쪽의 데이터(제일 최근에 추가된 데이터)값을 가져와 반환합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Queue/img/01_queue.png)

### 큐(Queue)의 응용 프로그램(Applications)

큐는 즉시 처리할 필요가 없을때 사용됩니다. 그러나 BFS(Breadth First Search)와 같이 FIFO(First-In-First-Out) 순서로 처리되어야 합니다. 큐의 속성은 또한 다음과 같은 시나리오에서 유용합니다.

-   여러 사용자들 사이에서 자원을 공유할때, 예를 들어 CPU 스케줄링, 디스크 스케줄링이 해당됩니다.
-   동기화된 데이터 전송할때, 예를 들어 IO Buffers, pipes, file IO, etc이 해당됩니다.

### 배열(Array) 기반 큐의 구현

큐를 구현하기 위해서는 front, rear라는 두가지 index를 추적 및 관리해야 합니다. 큐는 rear에 요소를 추가(Enqueue)하고 front에서 요소를 제거(Dequeue)합니다. 만약 단순하게 front와 rear 인덱스를 증가시킨다면 문제가 발생할 것입니다. front 인덱스는 배열의 끝에 닿을 수 있기 때문입니다. 이러한 문제를 해결하기 위해서는 front와 rear를 순환적으로 해결해야 합니다.

```
// 배열기반 큐 구현 실습
class Queue {
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

public class Test {
	public static void main(String[] args)
	{
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
	}
}
```

```
Output

10 enqueued to queue
20 enqueued to queue
30 enqueued to queue
40 enqueued to queue
10 dequeued from queue
Front item is 20
Rear item is 40
```

### 큐의 복잡도 분석(Complexity Analysis)

-   시간 복잡도(Time Complexity)

```
Operations              Complexity
Enque(insertion)           O(1)
Deque(deletion)            O(1)
Front(Get front)           O(1)
Rear(Get Rear)             O(1)
```

-   공간 복잡도(Auxiliary Space) : O(N), 배열의 사이즈

### 배열기반 큐의 장점

1.  구현이 쉬움

### 배열기반 큐의 단점

1.  크기가 정해진 정적인 구조
2.  큐에 많은 수의 데이터가 삽입되거나 삭제되어 데이터를 삽입하지 못하는 경우 문제가 발생할 수 있음. (이러한 문제는 순환 큐를 사용하여 회피가 가능하다)

### References

> https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
