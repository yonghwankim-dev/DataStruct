package LinkedList.Implement.circularList;

public interface CircularListI<E> {
	class Node<E>{
		E data;
		Node<E> next;
		
		public Node() {
			this(null);
		}
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}	
	}
	
	/**
	 * data�� ����Ʈ�� �߰���
	 * @param data �߰��ϰ��� �ϴ� �����Ͱ�
	 */
	public void push(E data);
	
	/**
	 * data���� ���� ��带 ����Ʈ���� ������
	 * �ߺ� ��尡 �ִ� ��� ���� ���� ��带 ������
	 * @param data	�����ϰ��� �ϴ� ������ ��
	 * @return ������ ����� ��
	 */
	public E remove(E data);
	

	/**
	 * ����Ʈ�� ���ҵ��� �����
	 */
	public void printList();
	
	/**
	 * ����Ʈ�� ��� ������ ��ȯ
	 * @return numofData ����Ʈ ��� ����
	 */
	public int size();
	
	
}
