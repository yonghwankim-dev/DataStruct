### 1\. 개요

이 글에서는 연결리스트에서 삭제 과정을 알아보도록 합니다. 연결리스트의 노드 삭제 방식은 대표적으로 2가지가 존재합니다. 첫번째는 노드의 data값인 key값을 탐색하고 제거하는 방법과 두번째는 연결리스트의 위치에 따른 노드 삭제 방식이 존재합니다. 아래의 글에서 2가지 방법을 소개해드립니다.

### 2\. 연결리스트 key값 삭제 과정

1.  삭제될 노드의 이전 노드(prev\_node)를 탐색
2.  이전 노드의 next를 변경
3.  삭제할 노드의 메모리 할당을 해제

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/LinkedList/img/05_linkedList_keyDelete.png)

```
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

    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("\nCreated Linked list is:");
        llist.printList();	// Expected Output : 2 3 1 7
 
        llist.deleteNode(1); // 노드 data값 1 삭제
 
        System.out.println(
            "\nLinked List after Deletion of 1:");
        llist.printList(); // Expected Output : 2 3 7
    }
}
```

```
Created Linked List: 
 2  3  1  7 
Linked List after Deletion of 1: 
 2  3  7
```

### 3\. 연결리스트 Position에 위치하는 노드 삭제

단순 연결리스트에서 연결리스트가 아래와 같을때 삭제 방식은 다음과 같습니다.

```
Input: position = 1, Linked List = 8->2->3->1->7
Output: Linked List =  8->3->1->7

Input: position = 0, Linked List = 8->2->3->1->7
Output: Linked List = 2->3->1->7
```

주의사항

1.  삭제하고자 하는 노드가 head인 경우 : head의 위치를 변경한다.
2.  만약 position이 노드의 개수보다 많은 경우 삭제 연산을 중지합니다.

```
// 연결리스트의 position 값에 따른 삭제 연산 예제
class LinkedList
{
    Node head;  // head of list
    
    ... 생략
    
    /* 연결리스트의 position 값에 위치한 노드를 삭제 */
    void deleteNode(int position)
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
  
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();	// Expected Output : 8 2 3 1 7
 
        llist.deleteNode(4);  // position 4 삭제 요청
 
        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();	// Expected Output : 8 2 3 1
    }
}
```

```
Created Linked List: 
 8  2  3  1  7 
Linked List after Deletion at position 4: 
 8  2  3  1
```

### References

> https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
