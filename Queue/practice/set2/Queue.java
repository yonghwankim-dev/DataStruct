package Queue.practice.set2;

// LinkedList ��� ť ����
public class Queue {
	QNode front, rear;
	
	public Queue()
	{
		front = rear = null;
	}
	
	void enQueue(int x)
	{
		// newNode ����
		QNode newNode = new QNode(x);
		
		// ���� queue�� ����ִٸ� front�� rear�� ��� newNode�� ����Ų��.
		if(rear==null) 
		{
			front = rear = newNode;
			return;
		}
		
		// ���� rear�� next�� newNode�� ����Ų��.
		// rear�� newNode�� ����Ų��.
		rear.next = newNode;
		rear = newNode;
	}
	
	// front�� ���� ��ȯ�ϰ� front�� ���� ���� �̵���Ų��.
	int deQueue()
	{
		// ���� queue�� ��������� -1 ��ȯ
		if(front==null)
		{
			return -1;
		}
		int result = front.data;
		
		// front�� ���� ���� �̵���Ų��.
		front = front.next;
		
		// ���� front�� null�� �Ǹ� rear ���� null�� �����ȴ�.
		if(front==null) 
		{
			rear = null;
		}
		return result;
	}
	
}
