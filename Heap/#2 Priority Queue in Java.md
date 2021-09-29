### 1\. Priority Queue 데이터 구조란 무엇인가?

Priority Queue는 객체들이 우선순위에 기반하여 처리될때 사용됩니다. Priority Queue의 처리순서는 일반적으로 Queue 데이터 구조인 FIFO(First-in-First-Out) 알고리즘을 따릅니다. 그러나 때때로 큐의 요소들이 우선순위에 따라 빠르게 처리해야 되는 경우가 존재합니다. 이럴때 Priority Queue를 통해서 순서에 상관없이 처리가 가능합니다.

Priority Queue의 데이터 구조는 힙(Heap) 데이터 구조에 기반합니다. 우선순위 큐의 정렬은 기본적으로 오름차순이지만 객체 생성시 Comparator 인터페이스를 통해서 정렬기준 및 순서를 정할 수 있습니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%232%20Priority%20Queue%20in%20Java/01_inheritance.png)

아래 Priority Queue 예제에서 아스키 값이 클수록 우선순위가 높습니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%232%20Priority%20Queue%20in%20Java/01_priorityqueue.png)

### 2\. Priority Queue 예제

아래 예제는 우선순위 큐의 기본적인 기능에 대해서 실습합니다.

-   boolean add(E element) : 우선순위 큐에 element를 삽입합니다.
-   E peek() : 우선순위 큐의 헤드, 즉 루트 노드를 참조합니다. 만약 우선순위 큐가 비어있다면 null을 반환합니다.
-   E poll() : 우선순위 큐의 헤드, 즉 루트 노드를 제거 및 반환합니다. 우선순위 큐가 비어있다면 null을 반환합니다.

```
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

	@Test
	void test() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(10);
		pq.add(20);
		pq.add(15);
		
		
		System.out.println(pq.peek()); // Expected Output : 10
		
		System.out.println(pq.poll());	// Expected Output : 10
		
		System.out.println(pq.peek()); // Expected Output : 15
		
		
	}

}
```

```
Output
10
10
15
```

#### 2.1 요소 추가(Adding Elements)

우선수위 큐에 요소를 추가하기 위하여 add() 메서드를 사용합니다. 우선순위 큐에서는 삽입 순서가 유지되지 않고 기본적으로 오름차순의 우선순위에 기반하여 정렬됩니다.

```
	@Test
	void addTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		System.out.println(pq);	// Expected Output : [For, Geeks, Geeks]
	}
```

```
Output
[For, Geeks, Geeks]
```

#### 2.2 요소 제거(Removing Elements)

우선순위 큐에서 요소를 제거하기 위해서 remove() 메서드를 사용할 수 있습니다. 매개변수로 넣은 객체가 있다면 첫번째로 마주치는 객체를 제거합니다. 이와는 별개로 poll() 메서드를 사용하면 우선순위 큐의 루트 노드에 있는 요소를 제거할 수 있습니다.

```
	@Test
	void removeTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		System.out.println("Initial PriorityQueue " + pq);	// Expected Output : [For, Geeks, Geeks]
		
		pq.remove("Geeks");
		
		System.out.println("After Remove - " + pq);	// Expected Output : [For, Geeks]
		
		System.out.println("Poll Method - " + pq.poll());	// Expected Output : For
		
		System.out.println("Final PriorityQueue - " + pq);	// Expected Output : [Geeks]
	}
```

```
Output

Initial PriorityQueue [For, Geeks, Geeks]
After Remove - [For, Geeks]
Poll Method - For
Final PriorityQueue - [Geeks]
```

#### 2.3 요소 접근(Accessing the Elements)

처리 순서가 큐의 FIFO를 따르기 때문에 오직 우선순위 큐의 루트 노드만을 참조할 수 있습니다. 우선순위 큐의 루트 노드에 접근하기 위해서 peek() 메서드를 사용할 수 있습니다.

```
	@Test
	void accessTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		System.out.println("PriorityQueue: " + pq);	// Expected Output : [For, Geeks, Geeks]
		
		
		System.out.println("Accessed Element: " + pq.peek());	// Expected Output : For
	}
```

```
Output

PriorityQueue: [For, Geeks, Geeks]
Accessed Element: For
```

#### 2.4 우선순위 큐 순회(Iterating the PriorityQueue)

우선순위 큐를 순회하기 위한 여러가지 방법이 존재합니다. 그중에서 가장 유명한 방법은 우선순위 큐를 배열로 변경한 다음 반복문을 사용하는 방법이 존재합니다. 그러나 큐 또한 내장 이터레이터를 가지고 있기 때문에 큐를 통해서 이터레이터 할 수 있습니다.

```
	@Test
	void iterateTest() {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		
		pq.add("Geeks");
		pq.add("For");
		pq.add("Geeks");
		
		Iterator<String> iterator = pq.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");	// Expected Output : For Geeks Geeks
		}
	}
```

```
Output

For Geeks Geeks
```

### 3\. Priority Queue 메서드

| [add(E e)](https://www.geeksforgeeks.org/priorityqueue-add-method-in-java/) | Inserts the specified element into this priority queue. |
| --- | --- |
| [clear()](https://www.geeksforgeeks.org/priorityqueue-clear-method-in-java/#:~:text=clear()%20method%20is%20used,only%20empty%20an%20existing%20PriorityQueue.) | Removes all of the elements from this priority queue. |
| [comparator()](https://www.geeksforgeeks.org/priorityqueue-comparator-method-in-java/) | Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements. |
| [contains​(Object o)](https://www.geeksforgeeks.org/priorityqueue-contains-method-in-java/#:~:text=PriorityQueue.,any%20particular%20element%20or%20not.&text=Return%20Value%3A%20The%20method%20returns,queue%20otherwise%20it%20returns%20False.) | Returns true if this queue contains the specified element. |
| forEach​(Consumer<? super E> action) | Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception. |
| [iterator()](https://www.geeksforgeeks.org/priorityqueue-iterator-method-in-java/) | Returns an iterator over the elements in this queue. |
|  [offer​(E e)](https://www.geeksforgeeks.org/priorityqueue-offer-method-in-java/) | Inserts the specified element into this priority queue. |
| [remove​(Object o)](https://www.geeksforgeeks.org/priorityqueue-remove-method-in-java/) | Removes a single instance of the specified element from this queue, if it is present. |
| removeAll​(Collection<?> c) | Removes all of this collection’s elements that are also contained in the specified collection (optional operation). |
| removeIf​(Predicate<? super E> filter) | Removes all of the elements of this collection that satisfy the given predicate. |
| retainAll​(Collection<?> c) | Retains only the elements in this collection that are contained in the specified collection (optional operation). |
| [spliterator()](https://www.geeksforgeeks.org/priorityqueue-spliterator-method-in-java/) | Creates a late-binding and fail-fast Spliterator over the elements in this queue. |
|  [toArray()](https://www.geeksforgeeks.org/priorityqueue-toarray-method-in-java/#:~:text=toArray(arr%5B%5D)%20method%20in,the%20previous%20method%20without%20parameters.) | Returns an array containing all of the elements in this queue. |
|  [toArray​(T\[\] a)](https://www.geeksforgeeks.org/priorityqueue-toarray-method-in-java/#:~:text=toArray(arr%5B%5D)%20method%20in,the%20previous%20method%20without%20parameters.) | Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array. |

### References

> source code : https://github.com/yonghwankim-dev/DataStruct  
> https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
