package Queue.practice.set2;

// LinkedList 기반 큐 구현
public class Queue {
	QNode front, rear;
	
	public Queue()
	{
		front = rear = null;
	}
	
	void enQueue(int x)
	{
		// newNode 생성
		QNode newNode = new QNode(x);
		
		// 만약 queue가 비어있다면 front와 rear는 모두 newNode를 가리킨다.
		if(rear==null) 
		{
			front = rear = newNode;
			return;
		}
		
		// 현재 rear의 next로 newNode를 가리킨다.
		// rear는 newNode를 가리킨다.
		rear.next = newNode;
		rear = newNode;
	}
	
	// front의 값을 반환하고 front를 다음 노드로 이동시킨다.
	int deQueue()
	{
		// 만약 queue가 비어있으면 -1 반환
		if(front==null)
		{
			return -1;
		}
		int result = front.data;
		
		// front를 다음 노드로 이동시킨다.
		front = front.next;
		
		// 만약 front가 null이 되면 rear 또한 null로 수정된다.
		if(front==null) 
		{
			rear = null;
		}
		return result;
	}
	
}
