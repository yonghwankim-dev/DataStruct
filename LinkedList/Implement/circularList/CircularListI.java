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
	 * data를 리스트에 추가함
	 * @param data 추가하고자 하는 데이터값
	 */
	public void push(E data);
	
	/**
	 * data값을 가진 노드를 리스트에서 제거함
	 * 중복 노드가 있는 경우 제일 앞의 노드를 제거함
	 * @param data	제거하고자 하는 데이터 값
	 * @return 제거한 노드의 값
	 */
	public E remove(E data);
	

	/**
	 * 리스트의 원소들을 출력함
	 */
	public void printList();
	
	/**
	 * 리스트의 요소 개수를 반환
	 * @return numofData 리스트 요소 개수
	 */
	public int size();
	
	
}
