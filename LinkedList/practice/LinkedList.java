package LinkedList.practice;

//연결리스트 삽입 메서드 예제
public class LinkedList
{
	 Node head;  // 리스트의 헤드
	
	 /* 연결리스트를 구성하는 노드 클래스*/
	 static class Node
	 {
	     int data;
	     Node next;
	     Node(int d) {data = d; next = null; }
	 }
	
	 /* 연결리스트 맨 앞에 노드 삽입 */
	 public void push(int new_data)
	 {
	     /* 1 & 2: 노드 할당 및 생성자에 데이터 삽입 */
	     Node new_node = new Node(new_data);
	
	     /* new_node의 next는 head를 가리킵니다. */
	     new_node.next = head;
	
	     /* head는 newNode를 가리킵니다. */
	     head = new_node;
	 }
	
	 /* 주어진 노드(prev_node) 뒤에 새로운 노드를 삽입합니다. */
	 public void insertAfter(Node prev_node, int new_data)
	 {
	     /* 1. 주어진 노드가 null인지 검사합니다. */
	     if (prev_node == null)
	     {
	         System.out.println("The given previous node cannot be null");
	         return;
	     }
	
	     /* 2. 새로운 노드 생성 */
	     Node new_node = new Node(new_data);
	
	     /* 3. 새로운 노드의 next는 주어진 노드의 next를 가리킵니다.*/
	     new_node.next = prev_node.next;
	
	     /* 주어진 노드의 next는 새로운 노드를 가리킵니다. */
	     prev_node.next = new_node;
	 }
	 
	 /* 연결리스트 마지막에 새로운 노드를 추가합니다.*/
	 public void append(int new_data)
	 {
	     /* 1. 새로운 노드 생성 */
	     Node new_node = new Node(new_data);
	
	     /* 2. head의 검사
	         만약 연결리스트가 비어있다면 head는 새로운 노드를 가리키고 종료합니다.*/
	     if (head == null)
	     {
	         head = new Node(new_data);
	         return;
	     }
	
	     /* 3. 새로운 노드는 맨 뒤에 추가하기 때문에 next는 null로 설정합니다.*/
	     new_node.next = null;
	
	     /* 4. 연결리스트의 마지막 노드를 찾기 위한 순회를 수행합니다. */
	     Node last = head;
	     while (last.next != null)
	         last = last.next;
	
	     /* 5. 기존 마지막 노드의 next는 새로운 노드(new_node)를 가리킵니다. */
	     last.next = new_node;
	     return;
	 }
	 
	 /* key가 주어진 경우 해당 key와 동일하고 처음 마주치는 노드를 제거한다.*/
	 void deleteNode(int key)
	 {
		 // temp는 head를 가리도록 한다.
		 Node temp = head, prev = null;
	 
		 // head가 삭제 대상 노드인 경우
		 if (temp != null && temp.data == key) {
			 head = temp.next; // head가 삭제되므로 head를 다음 노드로 가리킨다.
			 return;
		 }
	 
		 // 삭제될 노드(temp)와 그 이전 노드(prev)를 탐색한다.
		 while (temp != null && temp.data != key) {
			 prev = temp;
			 temp = temp.next;
		 }
	 
		 // 연결리스트에서 해당 key값을 못찾은 경우 메서드 종료
		 if (temp == null)
			 return;
	 
		 // 연결리스트로부터 연결해제
		 prev.next = temp.next;	
	 }
	 
	 /* 연결리스트의 position 값에 위치한 노드를 삭제 */
	 void deletePositionNode(int position)
	 {
		 // 연결리스트가 비어있는 경우 삭제연산 중지
		 if (head == null)
			 return;
	 
		 // temp는 head를 가리킴
		 Node temp = head;
	 
		 // 만약 삭제될 노드가 head(맨앞)인 경우
		 if (position == 0)
		 {
			 head = temp.next;   // head 변경
			 return;
		 }
	 
		 // 삭제될 노드의 이전 노드(temp)를 탐색
		 // temp!=null을 하는 이유는 position값이 노드의 개수보다 적을 수 있기 때문
		 for (int i=0; temp!=null && i<position-1; i++)
			 temp = temp.next;
	 
		 // 만약 position값이 노드의 개수보다 많은 경우 삭제연산 종료
		 if (temp == null || temp.next == null)
			 return;
	 
		 // 이전 노드(temp)는 삭제될 노드의 다음 노드를 가리킨다.
		 Node next = temp.next.next;
	 
		 temp.next = next;  // 연결리스트로부터 삭제될 노드 연결 해제 수행
	 }
	
	 /* 연결리스트를 head에서부터 순회 */
	 public void printList()
	 {
	     Node tnode = head;
	     while (tnode != null)
	     {
	         System.out.print(tnode.data+" ");
	         tnode = tnode.next;
	     }
	 }

}