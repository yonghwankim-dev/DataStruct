package LinkedList.Implement.circularList;

public class CircularList<E> implements CircularListI<E> {

	Node head;
	int numofData;
	
	public CircularList() {
		head = null;
		numofData = 0;
	}
	
	/**
	 * 리스트 맨앞에 데이터를 추가함
	 * @param data 삽입하고자 하는 데이터 값
	 */
	@Override
	public void push(E data) {
		Node<E> newNode = new Node(data);
		Node<E> cur = head;
		
		// 맨앞 노드의 next는 head를 가리킴
		newNode.next = head;
		
		if(head == null)	// 리스트가 비어있는 경우
		{
			newNode.next = newNode;
		}
		else	// 리스트가 비어있지 않은 경우
		{
			// cur 노드를 마지막 노드로 이동시킴
			while(cur.next != head)
			{
				cur = cur.next;
			}
			// cur 노드의 next를 맨앞의 newNode를 가리킴
			cur.next = newNode;
		}
		
		// head를 맨 앞의 노드로 이동시킴
		head = newNode;
		
		numofData++;
	}
	
	/**
	 * 리스트에서 data 값을 가진 노드를 제거함
	 * 
	 * 만약 제거하고자 하는 data 값 노드가 2개 이상인 경우
	 * 제일 앞의 노드를 제거함
	 * 
	 * @param data	제거하고자 하는 데이터 값
	 * @return
	 */
	@Override
	public E remove(E data) {
		if(head == null)
		{
			return null;
		}
		
		Node<E> cur = head;
		Node<E> prev = new Node();

		// 삭제하고자 하는 노드를 탐색
		while(!cur.data.equals(data))
		{
			if(cur.next == head)
			{
				break;	// not found
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		// 노드가 단 한개인 경우
		if(cur == head && cur.next == head)
		{
			head = null;
			numofData--;
			return (E) head.data;
		}
		
		// 삭제하고자 하는 노드가 첫번째 노드인 경우
		if(cur == head) 
		{
			prev = head;
			// prev 노드를 마지막 노드로 이동
			while(prev.next != head)
			{
				prev = prev.next;
			}
			head = cur.next;
			prev.next = head;
		}
		else if(cur.next == head)	// 삭제 노드가 마지막 노드인 경우 
		{
			prev.next = head;
		}
		else
		{
			prev.next = cur.next;
		}

		numofData--;
		return (E) head.data;
	}

	/**
	 * 리스트의 요소들을 출력함
	 */
	@Override
	public void printList() {
		Node<E> cur  = head;
		
		for(int i = 0; i < numofData && cur != null; i++)
		{
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	/**
	 * 리스트의 요소 개수를 반환함
	 * @return 리스트 요소 개수
	 */
	@Override
	public int size() {
		return numofData;
	}
	
	
}
