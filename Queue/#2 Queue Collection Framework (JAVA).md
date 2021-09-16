### 1\. Queue Collection Framework

Queue 인터페이스는 java.util 패키지안에 존재하고 Collection 인터페이스를 상속받습니다. Queue 인터페이스는 리스트의 시작으로부터 요소들을 삭제하고 리스트의 끝에 요소를 추가하는 객체들의 순서화된 리스트입니다. Queue 인터페이스는 FIFO(First-In-First-Out) 원칙을 따릅니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Queue/img/02_queue_inheritance.png)

Queue 인터페이스는 객체를 생성시 PriorityQueue 클래스나 LinkedList와 같은 콘크리트 클래스(Concrete Class)로 생성이 필요합니다.

### Declaration

```
public interface Queue extends Collection
```

### Queue 객체 생성

Queue는 인터페이스이기 때문에 Queue 타입으로 객체 생성이 불가능하다. 따라서 Queue 인터페이스를 구현한 콘크리트 클래스로부터 객체 생성이 필요하다. 대표적으로 Queue 인터페이스를 구현하는 PriorityQueue 클래스나 LinkedList 클래스의 객체 생성을 통하여 Queue 객체를 생성한다.

```
Queue<Object> queue = new PriorityQueue<Object>();
```

```
// Queue 객체 생성 실습
  
import java.util.LinkedList;
import java.util.Queue;
  
public class QueueExample {
  
    public static void main(String[] args)
    {
        Queue<Integer> q
            = new LinkedList<>();
 
        // {0, 1, 2, 3, 4} 데이터를 queue에 추가
        for (int i = 0; i < 5; i++)
            q.add(i);
  
        // 큐의 상태 출력
        System.out.println("Elements of queue "
                           + q);	// Expected Output : [0, 1, 2, 3, 4]
  
        // Queue의 제일 앞쪽 데이터 제거
        int removedele = q.remove();
        System.out.println("removed element-"
                           + removedele);	// Expected Output : 0
  
        System.out.println(q);	// Expected Output : [1, 2, 3, 4]
  
        // Queue의 제일 앞쪽 데이터 확인
        int head = q.peek();
        System.out.println("head of queue-"
                           + head);	// Expected Output : 1
  
		// Queue의 사이즈 확인
        int size = q.size();
        System.out.println("Size of queue-"
                           + size);	// Expected Output : 4
    }
}
```

```
Output

Elements of queue [0, 1, 2, 3, 4]
removed element-0
[1, 2, 3, 4]
head of queue-1
Size of queue-4
```

### Queue 인터페이스의 연산

Priority Queue 클래스를 기반으로 몇몇 자주 사용하는 연산들을 소개하겠습니다.

1\. 요소 추가

큐에 요소를 추가하기 위해서 add 메서드 사용합니다. PriorityQueue에서는 삽입 순서를 유지하지는 않습니다. 요소들은 은 기본적으로 오름차순을 기반으로 우선순위에 따라서 저장됩니다.

```
// 큐에 데이터 추가
import java.util.*;
  
public class GFG {
  
    public static void main(String args[])
    {
        Queue<String> pq = new PriorityQueue<>();
  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        System.out.println(pq);	// Expected Output : [For, Geeks, Geeks]
    }
}
```

2\. 요소 제거

큐의 요소를 제거하기 위해서 remove 메서드를 사용합니다. 만약 큐에 동일한 여러 객체들이 존재한다면 첫번째로 마주치는 객체를 제거합니다. 이와는 별개로 poll 메소드 또한 큐의 제일 앞쪽에 있는 데이터를 제거합니다. 현재 큐의 특성상 poll 메소드가 요소 제거에 제일 적합한 메서드입니다.

```
// 큐의 remove 메서드 실습
import java.util.*;
  
public class GFG {
  
    public static void main(String args[])
    {
        Queue<String> pq = new PriorityQueue<>();
  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        System.out.println("Initial Queue " + pq);	// Expected Output : [For, Geeks, Geeks]
  
        pq.remove("Geeks");
  
        System.out.println("After Remove " + pq);	// Expected Output : [For, Geeks]
  
        System.out.println("Poll Method " + pq.poll());	// Expected Output : For
  
        System.out.println("Final Queue " + pq); // Expected Output : [Geeks]
    }
}
```

```
Output

Initial Queue [For, Geeks, Geeks]
After Remove [For, Geeks]
Poll Method For
Final Queue [Geeks]
```

3\. Queue의 순회

큐의 데이터들을 순회하는 방법에는 여러가지 방법이 존재합니다. 가장 대표적인 방법은 Queue를 Array로 변환하고 반복문으로 순회하는 방법입니다. 그러나 Queue 또한 내장된 Iterator를 가지고 있습니다.

```
// Queue의 순회를 위한 실습
import java.util.*;
  
public class GFG {
  
    public static void main(String args[])
    {
        Queue<String> pq = new PriorityQueue<>();
  
        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");
  
        Iterator iterator = pq.iterator();
  
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " "); // Expected Output : For Geeks Geeks
        }
    }
}
```

```
Output

For Geeks Geeks
```

### Queue의 특징

-   Queue는 FIFO(First-In-First-Out) 원칙을 따릅니다. FIFO는 먼저 들어온 데이터가 먼저 제거되는 순서입니다.
-   Java Queue 인터페이스는 Collection Interface의 모든 메서드를 사용이 가능합니다.
-   LinkedList, ArrayBlockingQueue, PriorityQueue 클래스는 콘크리트 클래스로써 대표적인 Queue 인터페이스를 구현한 클래스입니다.
-   BlockingQueue 클래스에서 null 연산이 수행된다면 NullPointerExpcetion이 발생된다.
-   java.util 패키지에서 이용가능한 Queue 인터페이스는 사이즈가 동적이다.
-   java.util.concurrent 패키지에서 이용가능한 Queue 인터페이스는 사이즈가 정적이다.
-   Deques 클래스를 제외한 모든 Queue들은 큐의 head와 tail에 삭제와 삽입이 이루어진다. Deques 클래스는 head와 tail 전부 삽입과 삭제가 가능하다.

### Queue 인터페이스를 구현하는 클래스들

1\. PriorityQueue 클래스

Collection Framework에서 구현되는 PriorityQueue 클래스는 우선순위에 기반하여 객체들을 처리한다. PriorityQueue 클래스는 Queue의 원칙인 FIFO(First-In-First-Out) 알고리즘을 따르는 것으로 알려져 있다. 그러나 때때로 큐의 요소들이 우선순위에 따라 처리되는 것을 필요로 한다.

```
// PriorityQueue 클래스의 실습 예제 
import java.util.*;
  
class GfG {
  
    public static void main(String args[])
    {
        // PriorityQueue 객체 생성
        Queue<Integer> pQueue
            = new PriorityQueue<Integer>();
  
        // 데이터 추가
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // PriorityQueue의 제일 일순위 요소를 출력한다.
        System.out.println(pQueue.peek());	// Expected Output : 10
  
        // PriorityQueue의 제일 일순위 요소를 제거하고 반환한다.
        System.out.println(pQueue.poll());	// Expected Output : 10
  
        // PriorityQueue의 다시 일순위 요소를 출력한다.
        System.out.println(pQueue.peek());	// Expected Output : 15
    }
}
```

2\. LinkedList

LinkedList 클래스는 컬렉션 프레임워크(Collection Framework)로부터 구현된 콘크리트 클래스입니다. LinkedList 클래스는 연결리스트 데이터 구조를 구현한 클래스입니다. 대표적인 특징은 선형 데이터 구조이고 메모리상에 연속적인 위치에 저장되지 않기 때문에 랜덤 엑세스할 수 없다는 점입니다. 그리고 모든 노드들은 데이터 파트와 다음 노드를 가리키는 주소 파트로 구성되어 있습니다. 동적이고 쉬운 삽입과 삭제 연산때문에 LinkedList는 배열보단 큐 구조에서 수행됩니다. 

```
// LinkedList 객체 생성으로 Queue 객체 생성
import java.util.*;
  
class GfG {
  
    public static void main(String args[])
    {
        // LinkedList 기반 큐 객체 생성
        Queue<Integer> ll
            = new LinkedList<Integer>();
  
        ll.add(10);
        ll.add(20);
        ll.add(15);
  
		// 큐의 제일 앞에 있는 값을 출력한다.
        System.out.println(ll.peek());	// Expected Output : 10
  
        // 큐의 제일 앞에 있는 값을 제거하고 반환한다.
        System.out.println(ll.poll());	// Expected Output : 10
  
        // 다시 큐의 제일 앞에 있는 값을 출력한다.
        System.out.println(ll.peek());	// Expected Output : 20
    }
}
```

```
Output

10
10
20
```

3\. PriorityBlockingQueue

PriorityBlockingQueue 클래스는 PriorityQueue와 LinkedList 둘다 구현된 것에 주목합니다. 왜나하면 PriorityQueue와 LinkedList는 Thread-Safe 하지 않기 때문입니다.

만약 Thread-Safe 구현이 필요하다면 PriorityBlockingQueue는 하나의 대체적인 해결방법입니다. PriorityQueue는 PriorityQueue 클래스의 규칙을 따르는 동적인 blocking queue입니다. 동적이기 때문에 요소들을 추가하는 것은 때때로 실패할 수 있습니다. 왜냐하면 메모리 자원이 부족할 수 있기 때문입니다. 

```
// PriorityBlockingQueue 클래스를 사용한 큐의 생성 실습
import java.util.concurrent.PriorityBlockingQueue;
import java.util.*;
  
class GfG {
    public static void main(String args[])
    {
        Queue<Integer> pbq
            = new PriorityBlockingQueue<Integer>();
 
        pbq.add(10);
        pbq.add(20);
        pbq.add(15);
  
		// queue의 front 값 출력
        System.out.println(pbq.peek());	// Expected Output : 10
  
        // queue의 front 값 제거 및 반환
        System.out.println(pbq.poll());	// Expected Output : 10
  
        // 제거 후 queue의 front값 출력
        System.out.println(pbq.peek());	// Expected Output : 15
    }
}
```

```
Output

10
10
15
```

### References

> https://www.geeksforgeeks.org/queue-interface-java/
