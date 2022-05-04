package LinkedList.Implement.circularList;

public class CircularList<E> implements CircularListI<E> {

	Node head;
	int numofData;
	
	public CircularList() {
		head = null;
		numofData = 0;
	}
	
	/**
	 * ����Ʈ �Ǿտ� �����͸� �߰���
	 * @param data �����ϰ��� �ϴ� ������ ��
	 */
	@Override
	public void push(E data) {
		Node<E> newNode = new Node(data);
		Node<E> cur = head;
		
		// �Ǿ� ����� next�� head�� ����Ŵ
		newNode.next = head;
		
		if(head == null)	// ����Ʈ�� ����ִ� ���
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
		
		numofData++;
	}
	
	/**
	 * ����Ʈ���� data ���� ���� ��带 ������
	 * 
	 * ���� �����ϰ��� �ϴ� data �� ��尡 2�� �̻��� ���
	 * ���� ���� ��带 ������
	 * 
	 * @param data	�����ϰ��� �ϴ� ������ ��
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
			numofData--;
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

		numofData--;
		return (E) head.data;
	}

	/**
	 * ����Ʈ�� ��ҵ��� �����
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
	 * ����Ʈ�� ��� ������ ��ȯ��
	 * @return ����Ʈ ��� ����
	 */
	@Override
	public int size() {
		return numofData;
	}
	
	
}
