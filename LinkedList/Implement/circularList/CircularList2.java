package LinkedList.Implement.circularList;

public class CircularList2<E> implements CircularListI<E> {

	Node tail;
	int numofData;
	
	public CircularList2() {
		tail = null;
		numofData = 0;
	}
	
	/**
	 * 리스트 뒤에 데이터를 추가함
	 * @param data 추가하고자 하는 데이터 값
	 */
	@Override
	public void push(E data) {
		Node<E> newNode = new Node(data);
		
		if(tail == null)	// 리스트가 비어있는 경우
		{
			newNode.next = newNode;
		}
		else	// 리스트가 비어있지 않은 경우
		{
			// 맨 뒤 노드의 next는 맨 앞의 노드를 가리킴
			newNode.next = tail.next;
			// 기존 마지막 노드의 next는 newNode를 가리킴	
			tail.next = newNode;
		}
		
		// tail을 맨 뒤에 노드로 이동시킴
		tail = newNode;
		
		numofData++;
	}
	
	@Override
	public E remove(E data) {
		if(tail == null)
		{
			return null;
		}
		
		Node<E> cur = tail.next;
		Node<E> prev = new Node();

		// 삭제하고자 하는 노드를 탐색
		while(!cur.data.equals(data))
		{
			if(cur.next == tail.next)
			{
				break;	// not found
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		// 노드가 단 한개인 경우
		if(cur == tail && cur.next == tail)
		{
			tail = null;
			numofData--;
			return (E) tail.data;
		}
		
		// 삭제하고자 하는 노드가 첫번째 노드인 경우
		if(cur == tail.next) 
		{
			prev = tail;
			
			prev.next = cur.next;
		}
		else if(cur == tail)	// 삭제 노드가 마지막 노드인 경우 
		{
			prev.next = tail.next;
			tail = prev;
		}
		else
		{
			prev.next = cur.next;
		}

		numofData--;
		return (E) cur.data;
	}

	/**
	 * 리스트의 제일 앞에서부터 요소들을 출력함
	 */
	@Override
	public void printList() {
		Node<E> cur  = tail.next;
		
		for(int i = 0; i < numofData; i++)
		{
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}

	/**
	 * 리스트의 원소 개수를 반환
	 */
	@Override
	public int size() {
		return numofData;
	}
	
	
}
