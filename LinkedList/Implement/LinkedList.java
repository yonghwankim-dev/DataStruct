package LinkedList.Implement;

//���Ḯ��Ʈ ���� �޼��� ����
public class LinkedList
{
	 Node head;  // ����Ʈ�� ���
	
	 /* ���Ḯ��Ʈ�� �����ϴ� ��� Ŭ����*/
	 static class Node
	 {
	     int data;
	     Node next;
	     Node(int d) {data = d; next = null; }
	 }
	
	 /* ���Ḯ��Ʈ �� �տ� ��� ���� */
	 public void push(int new_data)
	 {
	     /* 1 & 2: ��� �Ҵ� �� �����ڿ� ������ ���� */
	     Node new_node = new Node(new_data);
	
	     /* new_node�� next�� head�� ����ŵ�ϴ�. */
	     new_node.next = head;
	
	     /* head�� newNode�� ����ŵ�ϴ�. */
	     head = new_node;
	 }
	
	 /* �־��� ���(prev_node) �ڿ� ���ο� ��带 �����մϴ�. */
	 public void insertAfter(Node prev_node, int new_data)
	 {
	     /* 1. �־��� ��尡 null���� �˻��մϴ�. */
	     if (prev_node == null)
	     {
	         System.out.println("The given previous node cannot be null");
	         return;
	     }
	
	     /* 2. ���ο� ��� ���� */
	     Node new_node = new Node(new_data);
	
	     /* 3. ���ο� ����� next�� �־��� ����� next�� ����ŵ�ϴ�.*/
	     new_node.next = prev_node.next;
	
	     /* �־��� ����� next�� ���ο� ��带 ����ŵ�ϴ�. */
	     prev_node.next = new_node;
	 }
	 
	 /* ���Ḯ��Ʈ �������� ���ο� ��带 �߰��մϴ�.*/
	 public void append(int new_data)
	 {
	     /* 1. ���ο� ��� ���� */
	     Node new_node = new Node(new_data);
	
	     /* 2. head�� �˻�
	         ���� ���Ḯ��Ʈ�� ����ִٸ� head�� ���ο� ��带 ����Ű�� �����մϴ�.*/
	     if (head == null)
	     {
	         head = new Node(new_data);
	         return;
	     }
	
	     /* 3. ���ο� ���� �� �ڿ� �߰��ϱ� ������ next�� null�� �����մϴ�.*/
	     new_node.next = null;
	
	     /* 4. ���Ḯ��Ʈ�� ������ ��带 ã�� ���� ��ȸ�� �����մϴ�. */
	     Node last = head;
	     while (last.next != null)
	         last = last.next;
	
	     /* 5. ���� ������ ����� next�� ���ο� ���(new_node)�� ����ŵ�ϴ�. */
	     last.next = new_node;
	     return;
	 }
	 
	 /* key�� �־��� ��� �ش� key�� �����ϰ� ó�� ����ġ�� ��带 �����Ѵ�.*/
	 void deleteNode(int key)
	 {
		 // temp�� head�� �������� �Ѵ�.
		 Node temp = head, prev = null;
	 
		 // head�� ���� ��� ����� ���
		 if (temp != null && temp.data == key) {
			 head = temp.next; // head�� �����ǹǷ� head�� ���� ���� ����Ų��.
			 return;
		 }
	 
		 // ������ ���(temp)�� �� ���� ���(prev)�� Ž���Ѵ�.
		 while (temp != null && temp.data != key) {
			 prev = temp;
			 temp = temp.next;
		 }
	 
		 // ���Ḯ��Ʈ���� �ش� key���� ��ã�� ��� �޼��� ����
		 if (temp == null)
			 return;
	 
		 // ���Ḯ��Ʈ�κ��� ��������
		 prev.next = temp.next;	
	 }
	 
	 /* ���Ḯ��Ʈ�� position ���� ��ġ�� ��带 ���� */
	 void deletePositionNode(int position)
	 {
		 // ���Ḯ��Ʈ�� ����ִ� ��� �������� ����
		 if (head == null)
			 return;
	 
		 // temp�� head�� ����Ŵ
		 Node temp = head;
	 
		 // ���� ������ ��尡 head(�Ǿ�)�� ���
		 if (position == 0)
		 {
			 head = temp.next;   // head ����
			 return;
		 }
	 
		 // ������ ����� ���� ���(temp)�� Ž��
		 // temp!=null�� �ϴ� ������ position���� ����� �������� ���� �� �ֱ� ����
		 for (int i=0; temp!=null && i<position-1; i++)
			 temp = temp.next;
	 
		 // ���� position���� ����� �������� ���� ��� �������� ����
		 if (temp == null || temp.next == null)
			 return;
	 
		 // ���� ���(temp)�� ������ ����� ���� ��带 ����Ų��.
		 Node next = temp.next.next;
	 
		 temp.next = next;  // ���Ḯ��Ʈ�κ��� ������ ��� ���� ���� ����
	 }
	
	 /* ���Ḯ��Ʈ�� head�������� ��ȸ */
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