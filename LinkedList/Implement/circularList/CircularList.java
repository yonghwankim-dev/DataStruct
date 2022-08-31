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

		// �����ϰ��� �ϴ� ��带 Ž��
		while(!cur.data.equals(data))
		{
			if(cur.next == head)
			{
				break;	// not found
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		// ��尡 �� �Ѱ��� ���
		if(cur == head && cur.next == head)
		{
			head = null;
			numOfData--;
			return (E) head.data;
		}
		
		// �����ϰ��� �ϴ� ��尡 ù��° ����� ���
		if(cur == head) 
		{
			prev = head;
			// prev ��带 ������ ���� �̵�
			while(prev.next != head)
			{
				prev = prev.next;
			}
			head = cur.next;
			prev.next = head;
		}
		else if(cur.next == head)	// ���� ��尡 ������ ����� ��� 
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

		// �Ǿ� ����� next�� head�� ����Ŵ
		newNode.next = head;

		// 1. �ڷᱸ���� ����ִ� ���
		if(head == null)
		{
			newNode.next = newNode;
		}
		else	// ����Ʈ�� ������� ���� ���
		{
			// cur ��带 ������ ���� �̵���Ŵ
			while(cur.next != head)
			{
				cur = cur.next;
			}
			// cur ����� next�� �Ǿ��� newNode�� ����Ŵ
			cur.next = newNode;
		}

		// head�� �� ���� ���� �̵���Ŵ
		head = newNode;

		numOfData++;
	}

	@Override
	public void addLast(E data) {
		Node<E> newNode = new Node(data);
		Node<E> cur = head;

		newNode.next = head;

		// 1. �ڷᱸ���� ����ִ� ���
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
		// 1. �ڷᱸ���� ����ִ� ���
		if(isEmpty()){
			return null;
		}

		delVal = (E) head.data;

		// 2. �ڷᱸ���� ��Ұ� �ϳ��� �ִ� ���
		if(head.next == head){
			head = null;
		}else{ // 3. �ڷᱸ���� ù��° ��Ҹ� �����Ϸ��� �ϴ� ���
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

		// 1. �ڷᱸ���� ����ִ� ���
		if(isEmpty()){
			return null;
		}

		// 2. �ڷᱸ���� ��Ұ� �Ѱ��� ���
		if(head.next == head){
			delVal = (E) head.data;
			head = null;
		}else{ // 4. �ڷᱸ���� ������ ��Ҹ� �����Ϸ��� �ϴ� ���
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

		// 1. �ڷᱸ���� ��Ұ� �ϳ��� ������
		if(isEmpty()){
			return false;
		}

		// 2. �ڷᱸ���� ��Ұ� 1�� �ִ� ���
		if(cur.next == head){
			return cur.data.equals(data);
		}

		while(cur.next != head){
			if(cur.data.equals(data)){
				return true;
			}
			cur = cur.next;
		}
		// 3. ������ ��Ҹ� ã������ �ϴ� ���
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
