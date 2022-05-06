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
	
	// 큐에 데이터를 삽입
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
	
	// 큐에 데이터를 제거 및 반환
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
	
	// 큐가 비어있는지 검사
	public boolean isEmpty()
	{
		return (numOfData == 0);
	}
	
	// 큐의 제일 앞쪽 데이터 반환
	int front()
	{
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		return head.data;
	}

	// 큐의 제일 뒤쪽 데이터 반환
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
