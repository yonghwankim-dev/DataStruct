package LinkedList.Implement.circularList;

public class CircularList2<E> implements CircularListI<E> {

	Node tail;
	int numofData;
	
	public CircularList2() {
		tail = null;
		numofData = 0;
	}
	
	/**
	 * ����Ʈ �ڿ� �����͸� �߰���
	 * @param data �߰��ϰ��� �ϴ� ������ ��
	 */
	@Override
	public void push(E data) {
		Node<E> newNode = new Node(data);
		
		if(tail == null)	// ����Ʈ�� ����ִ� ���
		{
			newNode.next = newNode;
		}
		else	// ����Ʈ�� ������� ���� ���
		{
			// �� �� ����� next�� �� ���� ��带 ����Ŵ
			newNode.next = tail.next;
			// ���� ������ ����� next�� newNode�� ����Ŵ	
			tail.next = newNode;
		}
		
		// tail�� �� �ڿ� ���� �̵���Ŵ
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

		// �����ϰ��� �ϴ� ��带 Ž��
		while(!cur.data.equals(data))
		{
			if(cur.next == tail.next)
			{
				break;	// not found
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		// ��尡 �� �Ѱ��� ���
		if(cur == tail && cur.next == tail)
		{
			tail = null;
			numofData--;
			return (E) tail.data;
		}
		
		// �����ϰ��� �ϴ� ��尡 ù��° ����� ���
		if(cur == tail.next) 
		{
			prev = tail;
			
			prev.next = cur.next;
		}
		else if(cur == tail)	// ���� ��尡 ������ ����� ��� 
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
	 * ����Ʈ�� ���� �տ������� ��ҵ��� �����
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
	 * ����Ʈ�� ���� ������ ��ȯ
	 */
	@Override
	public int size() {
		return numofData;
	}
	
	
}
