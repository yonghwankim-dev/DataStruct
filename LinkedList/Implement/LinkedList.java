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
	
	 /* �־��� �ε��� �ڸ��� ���ο� ��带 �����մϴ�. */
	 public void insert(int idx, int new_data)
	 {
		 Node newNode = new Node(new_data);
		 
		 if(idx<0 || idx>size())	// �������� �ε��� ����
		 {
			 throw new IndexOutOfBoundsException();
		 }
		 else if(idx==0)			// 0��° ��ġ�� ��带 �����ϰ��� �ϴ� ���
		 {
			 newNode.next = head;
			 head = newNode;
		 }
		 else
		 {
			 Node prev = head;
			 // Ư�� �ε���-1��° ���� �̵� (prev)
			 for(int i=0;i<idx-1;i++)
			 {
				 prev = prev.next;
			 }
			 
			 // ���� ó��
			 newNode.next = prev.next;
			 prev.next = newNode;
		 }
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
	 
	 // key�� �־��� ��� �ش� key�� �����ϰ� ó�� ����ġ�� ��带 �����Ѵ�
	 void deleteKeyNode(int key)
	 {
		 // cur�� head�������� ������
		 Node cur = head, prev = null;
	 
		 // head�� ���� ��� ����� ���
		 if (cur != null && cur.data == key) 
		 {
			 head = cur.next; // head�� �����ǹǷ� head�� ���� ���� ����Ų��.
			 return;
		 }
	 
		 // ������ ���(cur)�� �� ���� ���(prev)�� Ž���Ѵ�.
		 while (cur != null && cur.data != key) 
		 {
			 prev = cur;
			 cur = cur.next;
		 }
	 
		 // ���Ḯ��Ʈ���� �ش� key���� ��ã�� ��� �޼��� ����
		 if (cur == null)
		 {
			 return; 
		 }
			 
		 // ���Ḯ��Ʈ�κ��� ��������
		 prev.next = cur.next;	
	 }
	 
	 // ���Ḯ��Ʈ�� position ���� ��ġ�� ��带 ����
	 void deletePositionNode(int position)
	 {	  
		 // prev�� head�� ����Ŵ
		 Node prev = head;
	 
		// ���Ḯ��Ʈ�� ����ִ� ��� �������� ����
		 if (head == null)
		 {
			 return; 
		 }
		 
		 // ���� ������ ��尡 head(�Ǿ�)�� ���
		 if (position == 0)
		 {
			 head = prev.next;   // head ����
			 return;
		 }
	 
		 // ������ ����� ���� ���(prev)�� Ž��
		 // prev!=null�� �ϴ� ������ position���� ����� �������� ���� �� �ֱ� ����
		 for (int i=0; prev!=null && i<position-1; i++)
		 {
			 prev = prev.next;
		 }
		 
		 // ���� position���� ����� �������� ���� ��� �������� ����
		 if (prev == null || prev.next == null)
		 {
			 return;
		 }
			 
		 // ���� ���(prev)�� ������ ����� ���� ��带 ����Ų��.
		 prev.next = prev.next.next;;  // ���Ḯ��Ʈ�κ��� ������ ��� ���� ���� ����
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
	     System.out.println();
	 }
	 
	 /* ���� ����Ʈ�� ũ�⸦ ��ȯ�մϴ�. */
	 public int size() {
		 int count = 0;
		 Node cur = head;
		 
		 while(cur!=null)
		 {
			 cur = cur.next;
			 count++;
		 }
		 return count;
	 }

}