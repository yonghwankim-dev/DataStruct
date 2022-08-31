package LinkedList.Implement.circularList;

class CircularList<E> implements List<E> {

	private Node head;
	private int numOfData;
	
	public CircularList() {
		head = null;
		numOfData = 0;
	}

	@Override
	public E remove(E data) {
		if(isEmpty()) {
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
			numOfData--;
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

		numOfData--;
		return (E) head.data;
	}

	@Override
	public int size() {
		return numOfData;
	}

	@Override
	public void addFirst(E data) {
		Node<E> newNode = new Node(data);
		Node<E> cur = head;

		// 맨앞 노드의 next는 head를 가리킴
		newNode.next = head;

		// 1. 자료구조가 비어있는 경우
		if(head == null)
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

		numOfData++;
	}

	@Override
	public void addLast(E data) {
		Node<E> newNode = new Node(data);
		Node<E> cur = head;

		newNode.next = head;

		// 1. 자료구조가 비어있는 경우
		if(head == null){
			newNode.next = newNode;
			head = newNode;
		}else{
			while(cur.next != head){
				cur = cur.next;
			}
			cur.next = newNode;
		}
		numOfData++;
	}

	@Override
	public E removeFirst() {
		Node<E> cur = head;
		E delVal;
		// 1. 자료구조가 비어있는 경우
		if(isEmpty()){
			return null;
		}

		delVal = (E) head.data;

		// 2. 자료구조에 요소가 하나만 있는 경우
		if(head.next == head){
			head = null;
		}else{ // 3. 자료구조의 첫번째 요소를 제거하려고 하는 경우
			while(cur.next != head){
				cur = cur.next;
			}
			cur.next = cur.next.next;
			head = head.next;
		}

		numOfData--;
		return delVal;
	}

	@Override
	public E removeLast() {
		Node<E> prev = null;
		Node<E> cur = head;
		E delVal;

		// 1. 자료구조가 비어있는 경우
		if(isEmpty()){
			return null;
		}

		// 2. 자료구조에 요소가 한개인 경우
		if(head.next == head){
			delVal = (E) head.data;
			head = null;
		}else{ // 4. 자료구조의 마지막 요소를 제거하려고 하는 경우
			while(cur.next != head){
				prev = cur;
				cur = cur.next;
			}
			prev.next = cur.next;
			delVal = cur.data;
		}

		numOfData--;
		return delVal;
	}

	@Override
	public boolean contains(E data) {
		Node<E> cur = head;

		// 1. 자료구조에 요소가 하나도 없을때
		if(isEmpty()){
			return false;
		}

		// 2. 자료구조에 요소가 1개 있는 경우
		if(cur.next == head){
			return cur.data.equals(data);
		}

		while(cur.next != head){
			if(cur.data.equals(data)){
				return true;
			}
			cur = cur.next;
		}
		// 3. 마지막 요소를 찾을려고 하는 경우
		if(cur.data.equals(data)){
			return true;
		}
		return false;
	}

	@Override
	public E peekFirst() {
		return (E) head.data;
	}

	@Override
	public E peekLast() {
		Node<E> cur = head;

		while(cur.next != head){
			cur = cur.next;
		}
		return cur.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> cur = head;

		if(isEmpty()){
			return "";
		}

		while(cur.next != head)
		{
			sb.append(cur.data + " ");
			cur=cur.next;
		}
		sb.append(cur.data+"\n");

		return sb.toString().trim();
	}
}
