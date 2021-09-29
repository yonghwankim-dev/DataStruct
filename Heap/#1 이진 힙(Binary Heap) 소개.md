### 1\. 이진 힙(Binary Heap) 데이터구조란 무엇인가?

이진 힙은 아래와 같은 특성을 가지고 있는 이진 트리입니다.

1.  이진 힙의 데이터 구조는 **완전 이진 트리** 기반
    -   완전 이진 트리란 마지막 레벨을 제외하고 모든 레벨이 채워져 있으며, 마지막 레벨의 모든 노드는 가능한 한 왼쪽에 있는 트리를 의미합니다.
2.  이진 힙 구성
    -   **최소 힙(MinHeap)** : 부모 노드가 자식 노드보다 값이 작음, 루트 노드의 경우 모든 노드들 중 가장 작은 값이 됨
    -   **최대 힙(MaxHeap)** : 부모 노드가 자식 노드보다 값이 금, 루트 노드의 경우 모든 노드들 중 가장 큰 값이 됨

즉, 정리하면 **이진 힙이란 완전 이진 트리이면서 최소 힙 또는 최대 힙의 규칙으로 구성된 트리**를 의미합니다.

최소 힙(Min Heap) 예제

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/01_binaryHeap.png)

위의 그림을 보면 최소 힙을 구성하는 것을 볼 수 있습니다. 그중에서 루트 노드인 10 노드는 트리 중에서 가장 작은 값을 가지는 것을 알 수 있습니다.

### 2\. 이진 힙의 부모, 자식 접근

이진 힙은 완전 이진 트리 기반이므로 배열을 통해서 접근이 가능합니다.

-   루트 노드는 Arr\[0\]와 같이 접근
-   Arr\[i\] 노드 기준 부모, 왼쪽 자식, 오른쪽 자식 노드 접근

| Arr\[(i-1)/2\] | 부모 노드 반환 |
| --- | --- |
| Arr\[(2\*i)+1\] | 왼쪽 자식 노드 반환 |
| Arr\[(2\*i)+2\] | 오른쪽 자식 노드 반환 |

배열 기반의 접근에 사용되는 순회 방법은 **Level Order** 방법이 존재합니다.

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/02_HeapAccessing.png)

### 3\. 힙의 용도

1.  **Heap Sort** : Heap Sort는 O(nLogn) 시간에 배열을 정렬하기 위해 이진 힙(Binary Heap)을 사용
2.  **Priority Queue** : 이진 힙(Binary Heap)은 insert(), delete(), extractmax(), decreaseKey() 연산들을 O(logN) 시간에 가능하기 때문에 이진 힙을 사용하여 효율적으로 PriorityQueue을 구현 가능합니다. Binomoial Heap과 Fibonacci Heap은 이진 힙의 변형중 하나입니다. 이러한 변형 힙들은 통합(union)과 같은 연산을 효율적으로 수행할 수 있습니다.
3.  **Graph Algorithms** : Priority Queue는 특히 Dijkstra's Shortest Path와 Prim's Minimum Spanning Tree와 같은 그래프 알고리즘에 사용됩니다.

### 4\. 최소 힙의 수행 과정

#### 4.1 최소 힙 삽입(Insert)

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/03_insert_01.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/03_insert_02.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/03_insert_03.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/03_insert_04.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/03_insert_05.png)

#### 4.2 최소 힙 수정(Update)

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/04_update_01.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/04_update_02.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/04_update_03.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/04_update_04.png)

#### 4.3 최소 힙 추출(extract)

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/05_extract_01.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/05_extract_02.png)

위 그림을 보시면 루트 노드의 값이 70이기 때문에 최소 힙의 원칙이 위배됩니다. 따라서 MinHeapify(0)을 수행하여 최소 힙조정을 수행해야 합니다. 최소 힙조정에 대한 과정은 4.4 최소 힙 조정(heapify)에 있습니다.

#### 4.4 최소 힙 조정(heapify)

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/06_heapify_01.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/06_heapify_02.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/06_heapify_03.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/06_heapify_04.png)

#### 4.5 최소 힙 삭제(Delete)

![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/07_delete_01.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/07_delete_02.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/07_delete_03.png)
![](https://github.com/yonghwankim-dev/DataStruct/blob/main/Heap/img/%231%20%EC%9D%B4%EC%A7%84%20%ED%9E%99(Binary%20Heap)%20%EC%86%8C%EA%B0%9C/07_delete_04.png)

### 5\. 최소 힙의 대표적인 연산

1.  **getMini()** : 최소 힙의 제일 작은 값인 루트 노드를 반환합니다. getMini() 메서드의 시간복잡도는 O(1) 입니다.
2.  **extractMin()** : 최소 힙에서 루트 노드를 제거합니다. 빈자리가 된 루트 노드의 자리를 최소 힙의 마지막 노드(배열로는 데이터가 위치하는 마지막 위치)로 대체하고 힙 조정(heapify)을 수행합니다. 힙 조정을 수행하는 이유는 최소 힙의 성질인 부모 노드가 자식 노드의 값보다 작아야 하기 때문입니다. 그래서 extractMin() 연산의 시간복잡도는 O(LogN)이 소요됩니다.
3.  **decreaseKey(int i, int new\_val)** : i번째 노드의 값을 new\_val값으로 변경합니다. 이 연산의 시간복잡도는 O(Logn)입니다. 만약 변경된 노드의 값이 부모 노드의 값보다 크다면 아무런 조정도 필요없습니다. 하지만 그렇지 않다면 위배된 최소 힙을 고치기 위해서 반복적으로 부모 노드와의 값을 비교하면서 부모 노드의 값이 더 크다면 값의 교환을 수행합니다.
4.  **insert(int k)** : 정수 k 값을 힙의 마지막 자리에 추가합니다. 새로운 값을 삽입하는 것은 O(Logn)의 시간이 소요됩니다. 만약 새로운 키가 부모 노드보다 크다면 아무런 일이 발생하지 않지만 그렇지 않다면 위배된 최소 힙을 고치기 위해 반복적으로 부모 노드와의 값을 비교하면서 부모 노드의 값이 더 크다면 값의 교환을 수행합니다.
5.  **delete(int i)** : 최소 힙에서 i번째 노드를 삭제합니다. 키를 삭제하는 것 또한 O(Logn)의 시간이 소요됩니다. 우선 delete() 메서드 호출시 i번째 노드의 값을 정수 최솟값(Integer.MIN\_VALUE)으로 변경합니다. 이렇게 되면 i번째 노드의 값이 정수의 최솟값이 되기 때문에 최소 힙의 원칙에도 위배가 됩니다. 따라서 최소 힙을 유지하기 위해서 정수의 최솟값을 가지는 i번째 노드는 루트 노드로 교환하면서 이동하게 됩니다. 이러한 과정을 decreaseKey() 메서드를 호출함으로써 수행됩니다. decreaseKey() 메서드 호출후 extractMin() 메서드를 사용합니다. extractMin() 메서드는 루트 노드를 제거하고 최소 힙의 마지막 노드를 루트 노드에 위치하게 두고 힙조정(heapify)을 수행하는 메서드입니다.

### 6\. 최소 힙의 구현

```
public class MinHeap {
	private int[] harr;
	private int capacity;	// 최소 힙의 최소 가능 크기
	private int heap_size;	// 최소 힙의 현재 크기
	
	public MinHeap()
	{
		this(10);
	}
	
	public MinHeap(int capacity)
	{
		harr = new int[capacity];
		this.capacity = capacity;
		heap_size = 0;
	}
	
	// 주어진 i번째 노드의 서브트리를 힙 조정하기 위한 메서드
	public void MinHeapify(int i)
	{
		int left = getLeftChild(i);
		int right = getRightChild(i);
		int smallest = i;
		
		if(left < heap_size && harr[left] < harr[i])
		{
			smallest = left;
		}
		if(right < heap_size && harr[right] < harr[smallest])
		{
			smallest = right;
		}
		
		if(smallest != i)
		{
			swap(smallest, i);
			MinHeapify(smallest);
		}		
	}
	
	// 주어진 i번째 노드의 부모 노드 반환
	public int getParent(int i)
	{
		return (i-1)/2;
	}
	
	// 주어진 i번째 노드의 왼쪽 자식 반환
	public int getLeftChild(int i)
	{
		return (2*i+1);
	}
	
	// 주어진 i번째 노드의 오른쪽 자식 반환
	public int getRightChild(int i)
	{
		return (2*i+2);
	}
	
	// 루트 노드의 값을 추출합니다. 추출된 루트 노드는 제거됩니다.
	public int extractMin()
	{
		if(heap_size<=0)
		{
			return Integer.MAX_VALUE;
		}
		
		if(heap_size==1)
		{
			heap_size--;
			return harr[0];
		}
		
		// 힙으로부터 루트 노드의 값을 제거하고 최소값으로 대체
		int root = harr[0];
		harr[0] = harr[heap_size-1];
		heap_size--;
		MinHeapify(0);	// 루트 노드 힙조정
		
		return root;
	}
	
	// i번째 노드의 값을 new_val 값으로 변경합니다.
	public void decreaseKey(int i, int new_val)
	{
		harr[i] = new_val;
		while(i!=0 && harr[getParent(i)] > harr[i])
		{
			swap(getParent(i), i);
			i = getParent(i);
		}
	}
	// 최소값 반환, 루트 노드의 값을 제거하지 않고 값만 반환합니다.
	public int getMin()
	{
		return harr[0];
	}
	
	// i번째 노드를 제거합니다.
	// i번째 자리는 정수의 최솟값으로 대체되고 extractMin()을 호출하여 힙조정이 수행됩니다.
	public void deleteKey(int i)
	{
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	// 새로운 값 'k' 삽입
	public void insertKey(int k)
	{
		if(heap_size==capacity)
		{
			System.out.println("Overflow : Could not insertKey\n");
			return;
		}
		
		// heap의 마지막 자리에 k를 추가
		heap_size++;
		int i = heap_size - 1;
		harr[i] = k;
		
		// i가 0이 아니고 부모 노드의 값이 현재(i) 노드의 값보다 큰 경우에만
		// 부모 노드와 현재 노드의 값을 변경한다. (최소 힙 유지)
		while(i!=0 && harr[getParent(i)]>harr[i])
		{
			swap(getParent(i),i);
			i = getParent(i);
		}
	}
	
	public void swap(int parent, int i)
	{
		int temp = harr[parent];
		harr[parent] = harr[i];
		harr[i] = temp;
	}
	
}
```

```
class MinHeapTest {

	@Test
	void minHeapTest() {
		MinHeap heap = new MinHeap(11);
		
		heap.insertKey(3);
		heap.insertKey(2);
		heap.deleteKey(1);	// value 3 제거
		heap.insertKey(15);
		heap.insertKey(5);
		heap.insertKey(4);
		heap.insertKey(45);
		
		System.out.println(heap.extractMin()); // Expected Output : 2
		System.out.println(heap.getMin());	// Expected Output : 4 
		heap.decreaseKey(2, 1);				
		System.out.println(heap.getMin());	// Expected Output : 1
		System.out.println(heap);
		
	}

}
```

### References

> source code : https://github.com/yonghwankim-dev/DataStruct  
> https://www.geeksforgeeks.org/binary-heap/
