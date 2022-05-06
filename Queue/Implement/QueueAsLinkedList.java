package Queue.Implement;

public class QueueAsLinkedList {
	Node head, tail;
	int numOfData;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public QueueAsLinkedList()
	{
		head = tail = null;
		numOfData = 0;
	}
	
	// ť�� �����͸� ����
	public void enqueue(int item)
	{
		Node newNode = new Node(item);
		
		if(head == null) {
			head = tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
		
		numOfData++;
	}
	
	// ť�� �����͸� ���� �� ��ȯ
	int dequeue()
	{
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		int item = head.data;
		
		if(numOfData == 1) {
			head = tail = null;
		}
		else{
			head = head.next;
		}
		
		numOfData--;
				
		return item;
	}
	
	// ť�� ����ִ��� �˻�
	public boolean isEmpty()
	{
		return (numOfData == 0);
	}
	
	// ť�� ���� ���� ������ ��ȯ
	int front()
	{
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return head.data;
	}

	// ť�� ���� ���� ������ ��ȯ
	int rear()
	{
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return tail.data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node cur = head;
		while(cur != null)
		{
			sb.append(cur.data+" ");
			cur = cur.next;
		}
		return sb.toString().trim();
	}
	
	
}
