### 1\. 개요

이 글에서는 연결리스트에 새로운 노드를 삽입하는 방법에 대해서 설명합니다. 노드는 3곳에서 추가될 수있습니다.

1.  연결리스트의 앞쪽
2.  지정된 노드 뒤
3.  연결리스트의 뒤쪽

### 2\. 연결리스트 앞쪽에 노드 삽입

예를들어 연결리스트가 10->15->20->25로 구성되고 새로운 노드 5를 삽입한다고 가정하겠습니다. 연결리스트 앞쪽에 삽입된다면 연결리스트는 5->10->15->20->25와 같이 삽입됩니다. 

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/LinkedList/img/02_linkedList_front_insert.png)

노드 삽입 단계

1\. 노드 생성

2\. 새로운 노드(newNode)의 next는 기존 head가 가리키고 있는 노드를 가리킵니다.

3\. head는 새로운 노드(newNode)를 가리킵니다.

```
/* push 메서드는 LinkedList Class에서 수행됩니다.
	리스트의 앞쪽(front)에 새로운 노드를 삽입합니다.
    push 메서드는 아래와 같이 정의합니다.*/
public void push(int new_data)
{
    /* 1 & 2: 노드 할당 및 생성자에 데이터 삽입 */
    Node new_node = new Node(new_data);
 
    /* new_node의 next는 head를 가리킵니다. */
    new_node.next = head;
 
    /* head는 newNode를 가리킵니다. */
    head = new_node;
}
```

push() 메서드의 시간 복잡도(Time Complexity)는 O(1)입니다.

### 3\. 지정된 노드 뒤에 노드 삽입

새로운 노드를 지정된 노드 뒤에 삽입합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/LinkedList/img/03_linkedList_given_insert.png)

노드 삽입 단계

1\. 주어진 노드가 null인지 검사

2\. 새로운 노드(newNode) 생성

3\. 새로운 노드의 next는 주어진 노드(prev\_node)의 next를 가리킵니다.

4\. 주어진 노드(prev\_node)의 next는 새로운 노드(newNode)를 가리킵니다.

```
/* insertAfter 메소드는 LinkedList 클래스에 정의되었습니다.
	주어진 노드(prev_node) 뒤에 새로운 노드를 삽입합니다. */
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
```

insertAfter 메서드의 시간복잡도는 O(1)입니다.

### 3\. 연결 리스트 뒤쪽에 노드 삽입

새로운 노드를 연결 리스트 마지막에 추가합니다. 예를 들어 연결리스트가 5->10->15->20->25로 구성되어 있고 30을 추가할 경우 5->10->15->20->25->30과 같이 구성됩니다.

연결리스트는 헤드에 의해서 참조되기 때문에 리스트의 맨 뒤에 추가하기 위해서는 연결리스트의 마지막 노드로 포인터의 이동이 필요합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/LinkedList/img/04_linkedList_rear_insert.png)

노드 삽입 단계

1\. 새로운 노드 생성

2\. head의 검사

3\. 새로운 노드의 next 설정

4\. 연결리스트의 마지막 노드 탐색

5\. 마지막 노드의 next를 설정함으로써 새로운 노드를 리스트의 맨 뒤에 추가

```
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
```

시간 복잡도는 O(n)이 소요됩니다. 왜냐하면 노드를 추가하기 위해서는 연결리스트의 마지막 노드를 탐색해야 하기 때문입니다. 연결리스트의 노드 수가 5개라면 5개 만큼의 시간 복잡도가 소모됩니다.

```
// 연결리스트 삽입 메서드 예제
class LinkedList
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
 
    /* 연결리스트 삽입 메서드 호출*/
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        // 6->Nullist
        llist.append(6);
 
        // 7->6->NUllist
        llist.push(7);
 
        // 1->7->6->NUllist
        llist.push(1);
 
        // 1->7->6->4->NUllist
        llist.append(4);
 
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
 
        System.out.println("\nCreated Linked list is: ");	
        llist.printList();	// Expected Output : 1 7 8 6 4
    }
}
```

```
Output
Created Linked list is:  1  7  8  6  4
```

### References

> https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
